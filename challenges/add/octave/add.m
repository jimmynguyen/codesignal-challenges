function c = add(a, b)
	c = a + b;
endfunction
%!assert(add(1, 2), 3)
%!assert(add(0, 1000), 1000)
%!assert(add(2, -39), -37)
%!assert(add(99, 100), 199)
%!assert(add(-100, 100), 0)
%!assert(add(-1000, -1000), -2000)