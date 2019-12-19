function r = maxDigit(n)
	r = max(arrayfun(@str2num, num2str(n)));
endfunction
%!assert(maxDigit(111), 1)
%!assert(maxDigit(132), 3)
%!assert(maxDigit(0), 0)