#pragma once
#include "shape.h"

class ellipse : public shape {
public:
	explicit ellipse(wxRect box, const wxPen& pen, const wxBrush& brush) : shape{ box, pen, brush } {
	}

protected:
	void do_draw(context_t& context) const override {
		context.DrawEllipse(m_box);
	}
};