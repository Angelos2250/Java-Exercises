#pragma once
#include "shape.h"

namespace breakout {
	class racket final : public shape {
	public:
		explicit racket(wxRect box, const wxPen& pen, const wxBrush& brush) : shape{ box, pen, brush } {}

		using context_t = ml5::paint_event::context_t;


	protected:
		void do_draw(context_t& context) const override {
			context.DrawRectangle(m_box);
		}
	};
}