function r = houseNumbersSum(a)
	r = 0;
	for x = a
		if x == 0
			break;
		endif
		r = r + x;
	endfor
endfunction
%!assert(houseNumbersSum([5, 1, 2, 3, 0, 1, 5, 0, 2]), 11)
%!assert(houseNumbersSum([4, 2, 1, 6, 0]), 13)
%!assert(houseNumbersSum([4, 1, 2, 3, 0, 10, 2]), 10)
%!assert(houseNumbersSum([0, 1, 2, 3, 0]), 0)
%!assert(houseNumbersSum([5, 1, 1, 3, 0, 1, 5, 0, 2]), 10)
%!assert(houseNumbersSum([10, 10, 10, 10, 10, 10, 10, 10, 10, 0]), 90)
%!assert(houseNumbersSum([10, 10, 10, 10, 10, 10, 10, 10, 0, 10]), 80)