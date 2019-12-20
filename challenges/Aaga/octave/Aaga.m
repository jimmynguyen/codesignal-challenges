function r = Aaga(s)
	allowance = 1;
	while length(s) > 1
		mask = s(1) == s(2:end);
		if any(mask)
			ndx = find(mask);
			s([1 ndx(1)+1]) = [];
		elseif allowance > 0
			allowance = allowance - 1;
			s(1) = [];
		else
			r = 'False';
			return;
		endif
	endwhile
	r = 'True';
endfunction
%!assert(Aaga("abcdefghijklmnopqrstuvwxyz"), "False")
%!assert(Aaga("1234567890"), "False")
%!assert(Aaga("abc1234defabce1d2f3"), "True")