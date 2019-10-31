function n = digitDistanceNumber(n)
	n = str2num(arrayfun(@num2str, abs(diff(arrayfun(@str2num, num2str(n))))));
endfunction
%!assert(digitDistanceNumber(2744), 530)
%!assert(digitDistanceNumber(330), 3)
%!assert(digitDistanceNumber(333), 0)
%!assert(digitDistanceNumber(19), 8)