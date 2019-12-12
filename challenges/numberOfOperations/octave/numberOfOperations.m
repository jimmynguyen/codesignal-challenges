function c = numberOfOperations(a, b)
	c = 0;
	while mod(a, b) == 0 || mod(b, a) == 0
		if mod(a, b) == 0
			a = a / b;
		else
			b = b / a;
		endif
		c = c + 1;
	endwhile
endfunction
%!assert(numberOfOperations(432, 72), 4)
%!assert(numberOfOperations(7, 14), 1)