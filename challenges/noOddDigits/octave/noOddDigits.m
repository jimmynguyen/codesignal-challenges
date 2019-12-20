function r = noOddDigits(n)
	r = arrayfun(@str2num, num2str(n));
	r = r(mod(r, 2) == 0);
	if isempty(r)
		r = 0;
	else
		r = str2num(arrayfun(@num2str, r));
	endif
endfunction
%!assert(noOddDigits(12345678), 2468)
%!assert(noOddDigits(299752), 22)
%!assert(noOddDigits(1), 0)
%!assert(noOddDigits(0), 0)