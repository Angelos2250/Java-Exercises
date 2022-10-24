#pragma once
#include <ml5/ml5.h>
#include "Utilities.h"

class shape : public ml5::object {
public:
	using context_t = ml5::paint_event::context_t;
	wxRect  m_box{};
	explicit shape(wxRect box, const wxPen& pen, const wxBrush &brush) : m_box{ box }, m_pen{ pen }, m_brush{ brush } {
	}

	void set_right_bottom(wxPoint new_end) {
		m_box.SetRightBottom(new_end);
	}

	void move(wxPoint new_pos) {
		if (new_pos.x + changeablesize >= 800) {
			new_pos.y = 580;
			new_pos.x = 800 - changeablesize;
			m_box.SetPosition(new_pos);
		}
		else {
			new_pos.y = 580;
			m_box.SetPosition(new_pos);
		}
		if (new_pos.x <= 0)
		{
			new_pos.y = 580;
			new_pos.x = 0;
			m_box.SetPosition(new_pos);
		}
		else {
			new_pos.y = 580;
			m_box.SetPosition(new_pos);
		}
	}

	wxPoint getPos() {
		return m_box.GetPosition();
	}

	wxRect get_mbox() {
		return m_box;
	}

	bool empty() const {
		return m_box.GetWidth() == 0 && m_box.GetHeight() == 0;
	}

	void draw(context_t& context) const {
		if (!empty()) {
			context.SetPen(m_pen);
			context.SetBrush(m_brush);
			do_draw(context);
		}
	}


protected:
	virtual
	void do_draw(context_t &context) const = 0;

	
	wxPen   m_pen{};
	wxBrush m_brush{};
};