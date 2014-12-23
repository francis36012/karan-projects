#include <iostream>
#include <string>
#include <sstream>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

int bin2Dec(string binNum);
string dec2Bin(int decNum);

int main() {
	
	int choice;
	int decimalNum;
	string binarynum;

	cout << "Type of conversion [1 for binary to decimal, 2 for decimal to binary]: ";
	scanf("%d", &choice);
	switch (choice) {
		case 1:
			cout << "Enter binary number: ";
			cin.ignore();
			std::getline(cin, binarynum);
			cout << "decimal: " << bin2Dec(binarynum) << endl;
			break;
		case 2:
			cout << "Enter deciaml number: ";
			scanf("%d", &decimalNum);
			cout << "binary: " << dec2Bin(decimalNum) << endl;
			break;
		default:
			cerr << "Invalid conversion type" << endl;
	}
	return 0;
}

int bin2Dec(string binNum) {
	int length = binNum.size() - 1;	
	int dec = 0;
	int exp = 0;
	
	int i;
	for (i = length; i >= 0; i--, exp++) {
		dec += (binNum.at(i) % 48) << exp;
	}
	return dec;
}

string dec2Bin(int decNum) {
	string binNum = "";
	string temp = "";

	ostringstream str;
	while (decNum > 0) {
		str << (decNum % 2);
		decNum = int(decNum >> 1);
	}

	temp += str.str();
	int i;
	for (i = temp.size() - 1; i >= 0; i--) {
		binNum += temp.at(i);
	}
	return binNum;
}
