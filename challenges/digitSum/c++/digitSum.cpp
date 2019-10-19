#include <iostream>
#include <sstream>
#include <string>
#include <vector>

int digitSum(int n)
{
	int s = 0;
	while (n > 0) {
		s += n % 10;
		n /= 10;
	}
	return s;
}

void custom_assert(bool assertion, std::string message) {
	if (!assertion) {
		throw std::runtime_error(message);
	}
}

int main(int argc, char *argv[])
{
	std::vector<int> input0{111, 0};
	std::vector<int> expectedOutput{3, 0};
	char message[100];
	sprintf(message, "# input0 = %d, # expectedOutput = %d", (int)input0.size(), (int)expectedOutput.size());
	custom_assert(input0.size() == expectedOutput.size(), std::string(message));
	for (int i = 0; i < expectedOutput.size(); i++)
	{
		int actualOutput = digitSum(input0[i]);
		sprintf(message, "digitSum(%d) returned %d, but expected %d", input0[i], actualOutput, expectedOutput[i]);
		custom_assert(actualOutput == expectedOutput[i], std::string(message));
	}
	sprintf(message, "PASSES %d out of %d tests", (int)expectedOutput.size(), (int)expectedOutput.size());
	std::cout << message << std::endl;
	return 0;
}