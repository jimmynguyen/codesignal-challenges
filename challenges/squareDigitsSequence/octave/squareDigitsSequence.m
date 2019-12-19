function r = squareDigitsSequence(n)
	a = [];
	while isempty(a) || ~any(a == n)
		a(end+1) = n;
		n = sum(arrayfun(@str2num, num2str(n)).^2);
	endwhile
	r = length(a)+1;
endfunction
%!assert(squareDigitsSequence(16), 9)
%!assert(squareDigitsSequence(103), 4)
%!assert(squareDigitsSequence(1), 2)
%!assert(squareDigitsSequence(13), 4)
%!assert(squareDigitsSequence(89), 9)
%!assert(squareDigitsSequence(612), 16)