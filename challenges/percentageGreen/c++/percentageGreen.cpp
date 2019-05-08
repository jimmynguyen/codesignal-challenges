#include <iostream>
#include <sstream>
#include <string>
#include <vector>

int percentageGreen(int green, int total)
{
	return (int)((double) green / total * 100);
}

void custom_assert(bool assertion, std::string message) {
	if (!assertion) {
		throw std::runtime_error(message);
	}
}

int main(int argc, char *argv[])
{
	std::vector<int> input0{2, 4};
	std::vector<int> input1{5, 5};
	std::vector<int> expectedOutput{40, 80};
	char message[100];
	sprintf(message, "# input0 = %d, # expectedOutput = %d", (int)input0.size(), (int)expectedOutput.size());
	custom_assert(input0.size() == expectedOutput.size(), std::string(message));
		sprintf(message, "# input1 = %d, # expectedOutput = %d", (int)input1.size(), (int)expectedOutput.size());
	custom_assert(input1.size() == expectedOutput.size(), std::string(message));
	for (int i = 0; i < expectedOutput.size(); i++)
	{
		int actualOutput = percentageGreen(input0[i], input1[i]);
		sprintf(message, "percentageGreen(%d, %d) returned %d, but expected %d", input0[i], input1[i], actualOutput, expectedOutput[i]);
		custom_assert(actualOutput == expectedOutput[i], std::string(message));
	}
	sprintf(message, "PASSES %d out of %d tests", (int)expectedOutput.size(), (int)expectedOutput.size());
	std::cout << message << std::endl;
	return 0;
}