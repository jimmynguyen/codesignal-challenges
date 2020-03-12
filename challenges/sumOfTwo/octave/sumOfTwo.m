function r = sumOfTwo(a, b, v)
	if length(a) < length(b)
		c = a;
		d = v - b;
	else
		c = b;
		d = v - a;
	endif
	for x = c
		if any(d == x)
			r = true;
			return;
		endif
	endfor
	r = false;
endfunction
%!assert(sumOfTwo([1, 2, 3], [10, 20, 30, 40], 42), true)
%!assert(sumOfTwo([1, 2, 3], [10, 20, 30, 40], 50), false)
%!assert(sumOfTwo([], [1, 2, 3, 4], 4), false)
%!assert(sumOfTwo([10, 1, 5, 3, 8], [100, 6, 3, 1, 5], 4), true)
%!assert(sumOfTwo([1, 4, 3, 6, 10, 1, 0, 1, 6, 5], [9, 5, 6, 9, 0, 1, 2, 1, 6, 10], 8), true)
%!assert(sumOfTwo([3, 2, 3, 7, 5, 0, 3, 0, 4, 2], [6, 8, 2, 9, 7, 10, 3, 8, 6, 0], 2), true)
%!assert(sumOfTwo([4, 6, 4, 2, 9, 6, 6, 2, 9, 2], [3, 4, 5, 1, 4, 10, 9, 9, 6, 4], 5), true)
%!assert(sumOfTwo([6, 10, 25, 13, 20, 21, 11, 10, 18, 21], [21, 10, 6, 0, 29, 25, 1, 17, 19, 25], 37), true)
%!assert(sumOfTwo([22, 26, 6, 22, 17, 11, 9, 22, 7, 12], [14, 25, 22, 27, 22, 30, 6, 26, 30, 27], 56), true)
%!assert(sumOfTwo([17, 72, 18, 72, 73, 15, 83, 90, 8, 18], [100, 27, 33, 51, 2, 71, 76, 19, 16, 43], 37), true)
%!assert(sumOfTwo([75, 38, 10, 57, 67, 39, 26, 14, 53, 80], [3, 19, 28, 92, 92, 47, 98, 30, 71, 21], 61), true)
%!assert(sumOfTwo([1, 2, 3], [], 1), false)