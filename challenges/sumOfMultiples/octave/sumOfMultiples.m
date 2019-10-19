function output = sumOfMultiples(n, k)
	v = 1:n;
	res = sum(v(find(mod(v, k) == 0)));
endfunction
%!assert(sumOfMultiples(7, 2), 12)
%!assert(sumOfMultiples(4, 1), 10)
%!assert(sumOfMultiples(5, 2), 6)