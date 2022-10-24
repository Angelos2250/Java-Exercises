#pragma once

#include <random>
#include "shape.h"

namespace breakout {
	class ball final : public shape {
	public:
		int speed{ 1 };
		/*int dx{ rand() % (5 - (-5) + 1) + (-5) };
		int dy{ rand() % (3 - 1 + 1) + 1 };*/
		int dx{ 2 };
		int dy{ 1 };
		explicit ball(wxRect box, const wxPen& pen, const wxBrush& brush) : shape{ box, pen, brush } {}

		using context_t = ml5::paint_event::context_t;

		void auto_move(int steps) {
			int x = m_box.GetPosition().x +dx;
			int y = m_box.GetPosition().y +dy;

			m_box.SetPosition({x+(dx*steps),y+(dy*steps)});
		}

	protected:
		void do_draw(context_t& context) const override {
			context.DrawEllipse(m_box);
		}
	};
}