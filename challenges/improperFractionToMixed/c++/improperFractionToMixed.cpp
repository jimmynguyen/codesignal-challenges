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
std::string vector_to_str(std::vector<int> vec)
{
	std::ostringstream oss;
	if (!vec.empty())
	{
		// Convert all but the last element to avoid a trailing ","
		std::copy(vec.begin(), vec.end()-1, std::ostream_iterator<int>(oss, ","));

		// Now add the last element with no delimiter
		oss << vec.back();
	}
	return oss.str();
}

void custom_assert(bool assertion, std::string message) {
	if (!assertion) {
		throw std::runtime_error(message);
	}
}

int main(int argc, char *argv[])
{
	std::vector<std::vector<int>> input0{{7, 2}, {10, 3}};
	std::vector<std::vector<int>> expected_output{{3, 1, 2}, {3, 1, 3}};
	char message[100];
	sprintf(message, "# input0 = %d, # expectedOutput = %d", (int)input0.size(), (int)expected_output.size());
	custom_assert(input0.size() == expected_output.size(), std::string(message));
	for (int i = 0; i < expected_output.size(); i++)
	{
		std::vector<int> actual_output = improperFractionToMixed(input0[i]);
		sprintf(message, "improperFractionToMixed(%s) returned %s, but expected %s", vector_to_str(input0[i]).c_str(), vector_to_str(actual_output).c_str(), vector_to_str(expected_output[i]).c_str());
		custom_assert(actual_output == expected_output[i], std::string(message));
	}
	sprintf(message, "PASSES %d out of %d tests", (int)expected_output.size(), (int)expected_output.size());
	std::cout << message << std::endl;
	return 0;
}