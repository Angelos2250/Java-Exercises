#pragma once
#include "shape.h"

class rectangle : public shape {
public:
	explicit rectangle(wxRect box, const wxPen& pen, const wxBrush& brush) : shape{ box, pen, brush } {
	}

protected:
	void do_draw(context_t& context) const override {
		context.DrawRectangle(m_box);
	}
};