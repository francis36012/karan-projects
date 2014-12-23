#include <iostream>
#include <stdio.h>

using namespace std;

double tilingCost(int width, int height, double cost);

int main(int argc, char** argv) {
	
	int width;
	int height;
	double tileCost;

	if (argc != 3) {
		cout << "Enter the width and height of the floor separated by a space: ";
		scanf("%d", &width);
		scanf("%d", &height);
		cout << "Enter the cost of a tile: ";
		scanf("%lf", &tileCost);

		cout << "Cost for tiling a " << width << " x " << height << " floor is " << tilingCost(width, height, tileCost) << endl;

	}
	return 0;
}

double tilingCost(int width, int height, double cost) {
	double totalCost = 0;
	totalCost = (width * height) * cost;
	return totalCost;
}
