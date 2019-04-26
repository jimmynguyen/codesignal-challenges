function res = subtractionByRegrouping(minuend, subtrahend)
	minuend = arrayfun('str2num', num2str(minuend));
	subtrahend = arrayfun('str2num', num2str(subtrahend));
	res = [];
	for i = length(minuend):-1:1
		a = minuend(i);
		b = subtrahend(i);
		if a < b
			a = a + 10;
			minuend(i-1) = minuend(i-1)-1;
		endif
		res = [res, a];
	endfor
endfunction
%!assert(subtractionByRegrouping(2024, 1234), [4, 12, 9, 1])
%!assert(subtractionByRegrouping(6, 5), [6])
%!assert(subtractionByRegrouping(4567, 3456), [7, 6, 5, 4])
%!assert(subtractionByRegrouping(3001, 2901), [1, 0, 10, 2])
%!assert(subtractionByRegrouping(5000, 4999), [10, 9, 9, 4])
%!assert(subtractionByRegrouping(1, 1), [1])
%!assert(subtractionByRegrouping(51234, 12345), [14, 12, 11, 10, 4])
%!assert(subtractionByRegrouping(20100, 19199), [10, 9, 10, 9, 1])