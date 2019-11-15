function r = rounders(n)
	s = arrayfun(@str2num, num2str(n))(end:-1:1);
	for i = 1:length(s)-1
		if s(i) >= 5
			s(i+1) = s(i+1) + 1;
		endif
		s(i) = 0;
	endfor
	if s(end) >= 10
		s(end) = 0;
		s(end+1) = 1;
	endif
	r = str2num(arrayfun(@num2str, s(end:-1:1)));
endfunction
%!assert(rounders(15), 20)
%!assert(rounders(1234), 1000)
%!assert(rounders(1445), 2000)
%!assert(rounders(14), 10)
%!assert(rounders(10), 10)
%!assert(rounders(7001), 7000)
%!assert(rounders(99), 100)