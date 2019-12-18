function s = halvingSum(n)
	s = 0;
	d = 1;
	while floor(n/d) != 0
		s = s + floor(n/d);
		d = d * 2;
	endwhile
endfunction
%!assert(halvingSum(25), 47)
%!assert(halvingSum(127), 247)
%!assert(halvingSum(1000), 1994)
%!assert(halvingSum(1), 1)
%!assert(halvingSum(100), 197)
%!assert(halvingSum(512), 1023)