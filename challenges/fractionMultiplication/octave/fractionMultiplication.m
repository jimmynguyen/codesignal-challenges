function r = fractionMultiplication(a, b)
	r = a .* b;
	a = r(1);
	b = r(2);
	c = mod(b, a);
	while c ~= 0
		b = a;
		a = c;
		c = mod(b, a);
	endwhile
	r = r ./ a;
endfunction
%!assert(fractionMultiplication([3, 2], [2, 5]), [3, 5])
%!assert(fractionMultiplication([2, 3], [3, 5]), [2, 5])