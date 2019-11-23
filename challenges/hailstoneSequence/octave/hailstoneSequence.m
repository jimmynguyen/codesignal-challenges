function c = hailstoneSequence(n)
	c = 0;
	while n ~= 1
		if mod(n, 2) == 0
			n = n / 2;
		else
			n = 3 * n + 1;
		endif
		c = c + 1;
	endwhile
endfunction
%!assert(hailstoneSequence(5), 5)
%!assert(hailstoneSequence(27), 111)
%!assert(hailstoneSequence(1), 0)
%!assert(hailstoneSequence(3), 7)
%!assert(hailstoneSequence(14), 17)
%!assert(hailstoneSequence(16), 4)