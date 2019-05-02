#include <iostream>
#include <sstream>
#include <string>
#include <vector>

std::vector<int> improperFractionToMixed(std::vector<int> a)
{
	std::vector<int> v{ a[0]/a[1], a[0]%a[1], a[1] };
	return v;
}

//https://stackoverflow.com/questions/8581832/converting-a-vectorint-to-string
const char* vector_to_c_str(std::vector<int> vec)
{
	std::ostringstream oss;
	if (!vec.empty())
	{
		// Convert all but the last element to avoid a trailing ","
		std::copy(vec.begin(), vec.end()-1, std::ostream_iterator<int>(oss, ","));

		// Now add the last element with no delimiter
		oss << vec.back();
	}
	return oss.str().c_str();
}

void custom_assert(bool assertion, std::string message) {
	if (!assertion) {
		throw std::runtime_error(message);
	}
}

int main(int argc, char *argv[])
{
	std::vector<std::vector<int>> input0{{7, 2}, {10, 3}, {23, 22}, {7, 3}, {8, 5}, {15, 4}, {18, 7}};
	std::vector<std::vector<int>> expectedOutput{{3, 1, 2}, {3, 1, 3}, {1, 1, 22}, {2, 1, 3}, {1, 3, 5}, {3, 3, 4}, {2, 4, 7}};
	char message[100];
	sprintf(message, "# input0 = %d, # expectedOutput = %d", (int)input0.size(), (int)expectedOutput.size());
	custom_assert(input0.size() == expectedOutput.size(), std::string(message));
	for (int i = 0; i < expectedOutput.size(); i++)
	{
		std::vector<int> actualOutput = improperFractionToMixed(input0[i]);
		sprintf(message, "improperFractionToMixed(%s) returned %s, but expected %s", vector_to_c_str(input0[i]), vector_to_c_str(actualOutput), vector_to_c_str(expectedOutput[i]));
		custom_assert(actualOutput == expectedOutput[i], std::string(message));
	}
	sprintf(message, "PASSES %d out of %d tests", (int)expectedOutput.size(), (int)expectedOutput.size());
	std::cout << message << std::endl;
	return 0;
}