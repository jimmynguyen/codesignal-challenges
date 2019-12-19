function r = sumOfSquares(n)
	r = sum([1:n].^2);
endfunction
%!assert(sumOfSquares(5), 55)
%!assert(sumOfSquares(1), 1)
%!assert(sumOfSquares(2), 5)
%!assert(sumOfSquares(4), 30)
%!assert(sumOfSquares(7), 140)