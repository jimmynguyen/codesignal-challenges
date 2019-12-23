function r = candies(n, m)
	r = floor(m/n)*n;
endfunction
%!assert(candies(3, 10), 9)
%!assert(candies(1, 2), 2)
%!assert(candies(10, 5), 0)
%!assert(candies(4, 4), 4)
%!assert(candies(4, 15), 12)
%!assert(candies(9, 100), 99)
%!assert(candies(8, 2), 0)
%!assert(candies(3, 3), 3)
%!assert(candies(7, 10), 7)
%!assert(candies(3, 23), 21)