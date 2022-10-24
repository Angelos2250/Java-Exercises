#pragma once

#include <ml5/ml5.h>
#include "draw_window.h"

class draw_application : public ml5::application {
    std::unique_ptr<ml5::window>make_window() const override {
        return std::make_unique<draw_window>();
    }
};