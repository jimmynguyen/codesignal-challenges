function d = numberOfEvenDigits(n)
	d = 0;
	for c = num2str(n)
		if mod(str2num(c), 2) == 0
			d = d + 1;
		endif
	endfor
endfunction
%!assert(numberOfEvenDigits(1010), 2)
%!assert(numberOfEvenDigits(123), 1)
%!assert(numberOfEvenDigits(135), 0)