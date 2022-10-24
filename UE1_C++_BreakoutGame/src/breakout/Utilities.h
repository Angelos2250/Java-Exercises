#pragma once
#include <ml5/ml5.h>

int changeablesize = 50;

class util : public ml5::object {
public:

	util() {};
	~util() {};

	int bricks_destroyed = 0;
	int bricks_destroyed_count = 0;

	const int x_edge_offset = 1;
	const int y_edge_offset = 50;
	const int window_width = 800;
	const int window_height = 600;
	const int window_height_offset = (window_height - 20);

	int score = 0;
	
	std::chrono::milliseconds time{ 20 };
	std::chrono::milliseconds min_time{ 7 };
	int cols = 16;
	int rows = 6;

	bool hit_wall = true;//if wall has hit a wall before
	bool racket_hit = true;//if ball has hit the racket before

	//TODO READJUST SIZE WHEN CHANGING MAP SIZE
	int brick_x_size = window_width / cols;
	int brick_y_size = brick_x_size /2;

	void readjust_block_size() {
		brick_x_size = window_width / cols;
		brick_y_size = brick_x_size / 2;
	};

	wxPoint rakstart{ window_width / 2,window_height_offset };
	wxPoint raksize{ (window_width / 2) + changeablesize, window_height_offset - 10 };

	wxPoint ballstart{ window_width / 2,window_height_offset / 2 };
	wxPoint ballsize{ (window_width / 2) + 10, (window_height_offset / 2) - 15 };

	std::chrono::milliseconds decrease_Time() {
		if (time == min_time)
		{
			return time;
		}
		if ( bricks_destroyed_count >= trunc((rows*cols)/20))
		{
			bricks_destroyed_count = 0;
			return time--;
		}
		return time;
	};

	wxBrush NextColor() {
		index++;
		if (index == colors.size()+1)
		{
			index = 1;
		}
		return colors[index-1];
	}

private:
	int index{ 0 };
	std::vector<wxBrush> colors{ *wxYELLOW_BRUSH,*wxWHITE_BRUSH,*wxRED_BRUSH,*wxBLUE_BRUSH,*wxGREEN_BRUSH };
};