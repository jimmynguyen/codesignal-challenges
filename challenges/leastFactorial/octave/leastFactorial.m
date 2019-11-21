function k = leastFactorial(n)
	k = 1;
	m = 1;
	while k < n
		m = m + 1;
		k = k * m;
	endwhile
endfunction
%!assert(leastFactorial(17), 24)
%!assert(leastFactorial(1), 1)
%!assert(leastFactorial(5), 6)
%!assert(leastFactorial(25), 120)
%!assert(leastFactorial(18), 24)
%!assert(leastFactorial(109), 120)
%!assert(leastFactorial(106), 120)
%!assert(leastFactorial(11), 24)
%!assert(leastFactorial(55), 120)
%!assert(leastFactorial(24), 24)