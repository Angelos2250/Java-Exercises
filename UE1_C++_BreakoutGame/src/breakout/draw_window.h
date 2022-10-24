#pragma once
#include <ml5/ml5.h>
#include <iostream>
#include <memory>	//for unique_ptr, but included in ml5 anyway
#include <cmath>
#include "shape.h"
#include "rectangle.h"
#include "Utilities.h"
#include "racket.h"
#include "ball.h"
#include "blocks.h"

using std::cout;
using std::endl;

class draw_window : public ml5::window {
public:
	enum class shape_t { line, rectangle, ellipse };

	draw_window() : ml5::window{ std::string{"breakout game"} } {
		set_prop_allow_resize(false);
		set_prop_initial_size({ utilities.window_width,utilities.window_height });
		set_prop_background_brush(*wxBLACK_BRUSH);
	}


	void fillmap() {
		utilities.score = 0;
		for (int i = 0; i < utilities.rows; i++)
		{
			wxBrush currentColor = utilities.NextColor();
			for (int j = 0; j < utilities.cols; j++)
			{
				wxPoint block_pos{ utilities.x_edge_offset + (j * utilities.brick_x_size), utilities.y_edge_offset + (i * utilities.brick_y_size) };
				wxPoint block_size{ block_pos.x + utilities.brick_x_size, block_pos.y + utilities.brick_y_size };
				m_current_shape = std::make_unique<breakout::block>(wxRect{ block_pos,block_size }, *wxBLACK_PEN, currentColor);
				m_current_shape->points = (utilities.rows - i) * 10;
				m_shapes.add(std::move(m_current_shape));
			}
		}
	}

	void on_init() override {
		srand(time(NULL));
		rack = std::make_unique<breakout::racket>(wxRect{ utilities.rakstart, utilities.rakstart }, *wxRED_PEN, *wxRED_BRUSH);
		rack->set_right_bottom(utilities.raksize);
		fillmap();

		game_ball = std::make_unique<breakout::ball>(wxRect{ utilities.ballstart,utilities.ballstart }, *wxRED_PEN, *wxRED_BRUSH);
		game_ball->set_right_bottom(utilities.ballsize);
		start_timer(utilities.time);

		refresh();
		add_menu("&Racket Options", {
				{ "&Increase Size","Increses Racket Size"},
				{ "&Decrease Size","Decreses Racket Size"}
			});
		add_menu("&Ball Options", {
				{ "&Increase Speed","Increses Ball Speed"},
				{ "&Decrease Speed","Decreses Ball Speed"}
			});
		add_menu("&Map Options", {
				{ "&Small Size","Small sized Map"},
				{ "&Medium Size","Medium Sized Map"},
				{ "&Large Size","Large Sized Map"}
			});
	}

	void on_menu(ml5::menu_event const& event) override {
		std::string menu_item = event.get_title_and_item();
		if (menu_item == "Racket Options/Increase Size") {
			changeablesize += 10;
			utilities.raksize.x = rack->getPos().x + changeablesize;
			rack->m_box.SetRightBottom(utilities.raksize);
			cout << rack->getPos().x << endl;
			refresh();
		}
		else if (menu_item == "Racket Options/Decrease Size") {
			changeablesize -= 10;
			utilities.raksize.x = rack->getPos().x + changeablesize;
			rack->m_box.SetRightBottom(utilities.raksize);
			cout << rack->getPos().x << endl;
			refresh();
		}
		else if (menu_item == "Ball Options/Increase Speed") {
			game_ball->speed++;
		}
		else if (menu_item == "Ball Options/Decrease Speed") {
			game_ball->speed--;
		}
		else if (menu_item == "Map Options/Large Size") {
			utilities.cols = 16;
			utilities.rows = 6;
			m_shapes.clear();
			utilities.readjust_block_size();
			fillmap();
			refresh();
		}
		else if (menu_item == "Map Options/Medium Size") {
			utilities.cols = 11;
			utilities.rows = 4;
			m_shapes.clear();
			utilities.readjust_block_size();
			fillmap();
			refresh();
		}
		else if (menu_item == "Map Options/Small Size") {
			utilities.cols = 6;
			utilities.rows = 3;
			m_shapes.clear();
			utilities.readjust_block_size();
			fillmap();
			refresh();
		}
	}

	void on_mouse_move(ml5::mouse_event const& event) override {
		if (m_current_shape) {
			m_current_shape->set_right_bottom(event.get_position());
			refresh();			//damit die Linie wirklich gezeichnet wird
		}
		
		rack->move(event.get_position());
		refresh();
	}

	void on_key(ml5::key_event const& event) override {
		wxPoint cur_pos = rack->getPos();
		switch (event.get_key_code())
		{
		case WXK_LEFT: {
			cur_pos.x -= 35;
			rack->move(cur_pos);
			refresh();
			break;
		}
		case WXK_RIGHT: {
			cur_pos.x+=35;
			rack->move(cur_pos);
			refresh();
			break;
		}
		default:
			break;
		}
	}

	void on_paint(ml5::paint_event const& event) override {
		set_status_text("Score: " + std::to_string(utilities.score));
		for (auto &ptr_shape : m_shapes) {
			if (ptr_shape != nullptr) {
				ptr_shape->draw(event.get_context());
			}
		}
		rack->draw(event.get_context());
		game_ball->draw(event.get_context());
	}

	void on_timer(ml5::timer_event const& event) override {
		int counter = 0;
		bool col = false;
		game_ball->auto_move(game_ball->speed);
		//collision with borders
		if (game_ball->getPos().x >= 800 || game_ball->getPos().x < 0)
		{
			game_ball->dx *= -1;
			utilities.hit_wall = true;
		}
		if (game_ball->getPos().y >= 600) {
			game_ball->dy *= -1;
			cout << "You lost restart the game" << endl;
			//exit(1);
		}
		if (game_ball->getPos().y < 0) {
			game_ball->dy *= -1;
			cout << "hit top" << endl;
			utilities.hit_wall = true;
		}
		//Collision with racket
		if (utilities.racket_hit)
		{
			if (game_ball->getPos().y + 7.5 >= rack->getPos().y)
			{
				if (game_ball->getPos().x >= rack->getPos().x && game_ball->getPos().x <= rack->getPos().x + (changeablesize / 2)) { //If collision with left half of racket
					game_ball->dx--;
					game_ball->dy *= -1;
					utilities.hit_wall = true;
					utilities.racket_hit = false;
				}
				if (game_ball->getPos().x > rack->getPos().x + (changeablesize / 2) && game_ball->getPos().x <= rack->getPos().x + changeablesize) {//If collision with right half of racket
					game_ball->dx++;
					game_ball->dy *= -1;
					utilities.hit_wall = true;
					utilities.racket_hit = false;
				}
			}
			
		}
		//Collision with bricks
		for (auto& ptr_shape : m_shapes) {
			if (utilities.hit_wall)
			{
				if ((game_ball->getPos().y - 7.5 <= ptr_shape->getPos().y + utilities.brick_y_size && game_ball->getPos().y + 7.5 >= ptr_shape->getPos().y) && (game_ball->getPos().x + 5 >= ptr_shape->getPos().x && game_ball->getPos().x - 5 <= ptr_shape->getPos().x + utilities.brick_x_size))
				{
					game_ball->dy *= -1;
					col = true;
					utilities.hit_wall = false;
					utilities.racket_hit = true;
					break;
				}
				else if ((game_ball->getPos().x - 5 <= ptr_shape->getPos().x + utilities.brick_x_size) && (game_ball->getPos().x + 5 >= ptr_shape->getPos().x) && (game_ball->getPos().y <= ptr_shape->getPos().y + utilities.brick_y_size && game_ball->getPos().y >= ptr_shape->getPos().y)) {
					game_ball->dy *= -1;
					col = true;
					utilities.hit_wall = false;
					utilities.racket_hit = true;
					break;
				}
				counter++;
			}
		}
		if (col)
		{
			utilities.bricks_destroyed++;
			utilities.bricks_destroyed_count++;
			utilities.score += m_shapes[counter]->points;
			m_shapes.remove(m_shapes[counter]);
			if (m_shapes.size() == 0)
			{
				cout << "You won the Game congratz" << endl;
				exit(1);
			}
			restart_timer(utilities.decrease_Time());
			col = false;
			counter = 0;
		}
		refresh();
	}

private:
	util utilities{};
	std::unique_ptr<breakout::racket>  rack{};
	std::unique_ptr<breakout::ball> game_ball{};

	shape_t											m_shape_type{shape_t::rectangle};
	std::unique_ptr<breakout::block>				m_current_shape{};	//{} init with nullptr
	ml5::vector<std::unique_ptr<breakout::block>>	m_shapes{};
};