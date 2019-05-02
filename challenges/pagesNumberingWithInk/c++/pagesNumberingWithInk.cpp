#include <iostream>
#include <sstream>
#include <string>
#include <vector>

int pagesNumberingWithInk(int current, int numberOfDigits) {
	int currentNumberOfDigits = std::to_string(current).length();
	while (numberOfDigits >= currentNumberOfDigits) {
		numberOfDigits -= currentNumberOfDigits;
		currentNumberOfDigits = std::to_string(++current).length();
	}
	return current-1;
}

void custom_assert(bool assertion, std::string message) {
	if (!assertion) {
		throw std::runtime_error(message);
	}
}

int main(int argc, char *argv[])
{
	std::vector<int> input0{1, 21, 8, 21, 10, 76, 80};
	std::vector<int> input1{5, 5, 4, 6, 3, 250, 1000};
	std::vector<int> expectedOutput{5, 22, 10, 23, 10, 166, 419};
	char message[100];
	sprintf(message, "# input0 = %d, # expectedOutput = %d", (int)input0.size(), (int)expectedOutput.size());
	custom_assert(input0.size() == expectedOutput.size(), std::string(message));
		sprintf(message, "# input1 = %d, # expectedOutput = %d", (int)input1.size(), (int)expectedOutput.size());
	custom_assert(input1.size() == expectedOutput.size(), std::string(message));
	for (int i = 0; i < expectedOutput.size(); i++)
	{
		int actualOutput = pagesNumberingWithInk(input0[i], input1[i]);
		sprintf(message, "pagesNumberingWithInk(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		custom_assert(actualOutput == expectedOutput[i], std::string(message));
	}
	sprintf(message, "PASSES %d out of %d tests", (int)expectedOutput.size(), (int)expectedOutput.size());
	std::cout << message << std::endl;
	return 0;
}