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