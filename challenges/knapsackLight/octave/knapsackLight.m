function res = knapsackLight(value1, weight1, value2, weight2, maxW)
	if weight1 > maxW && weight2 > maxW
		res = 0;
	elseif weight1 <= maxW && weight2 > maxW;
		res = value1;
	elseif weight1 > maxW && weight2 <= maxW
		res = value2;
	elseif weight1 + weight2 <= maxW
		res = value1 + value2;
	else
		res = max([value1, value2]);
	endif
endfunction
%!assert(knapsackLight(10, 5, 6, 4, 8), 10)
%!assert(knapsackLight(10, 5, 6, 4, 9), 16)
%!assert(knapsackLight(5, 3, 7, 4, 6), 7)
%!assert(knapsackLight(10, 2, 11, 3, 1), 0)
%!assert(knapsackLight(15, 2, 20, 3, 2), 15)
%!assert(knapsackLight(2, 5, 3, 4, 5), 3)
%!assert(knapsackLight(4, 3, 3, 4, 4), 4)
%!assert(knapsackLight(3, 5, 3, 8, 10), 3)