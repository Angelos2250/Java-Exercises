#include <ml5/ml5.h>
#include "draw_application.h"

int main () {
	try
	{
		draw_application app{};
		app.run();
	}
	catch (const std::exception& x)
	{
		std::cout << x.what() << std::endl;
	}
}
