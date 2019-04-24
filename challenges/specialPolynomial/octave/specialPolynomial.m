function r = specialPolynomial (x, n)
	s = 1;
	k = 0;
	while s <= n
		k = k + 1;
		s = s + x^k;
	endwhile
	r = k - 1;
endfunction
%!assert(specialPolynomial(2, 5), 1)
%!assert(specialPolynomial(10, 111111110), 7)
%!assert(specialPolynomial(1, 100), 99)
%!assert(specialPolynomial(3, 140), 4)