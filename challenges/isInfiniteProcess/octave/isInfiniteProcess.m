function res = isInfiniteProcess (a, b)
	res = false;
	while a ~= b
		if a > b
			res = true;
			break;
		endif
		a = a + 1;
		b = b - 1;
	endwhile
endfunction
%!assert(isInfiniteProcess(2, 6), false)
%!assert(isInfiniteProcess(2, 3), true)
%!assert(isInfiniteProcess(2, 10), false)
%!assert(isInfiniteProcess(0, 1), true)
%!assert(isInfiniteProcess(3, 1), true)
%!assert(isInfiniteProcess(10, 10), false)
%!assert(isInfiniteProcess(5, 10), true)
%!assert(isInfiniteProcess(6, 10), false)
%!assert(isInfiniteProcess(10, 0), true)
%!assert(isInfiniteProcess(5, 5), false)