function j = maxZeros(n)
	s = dec2base(n, 2);
	l = length(s(s == '0'));
	j = 2;
	i = 3;
	while i <= 36
		s = dec2base(n, i);
		if length(s(s == '0')) > l
			l = length(s(s == '0'));
			j = i;
		endif
		i = i + 1;
	endwhile
endfunction
%!assert(maxZeros(9), 2)
%!assert(maxZeros(7), 7)
%!assert(maxZeros(127), 5)