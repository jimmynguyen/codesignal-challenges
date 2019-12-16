function r = sumUpDigits(s)
	r = sum(arrayfun(@(x) str2num(s(x)), regexp(s, '\d')));
endfunction
%!assert(sumUpDigits("2 apples, 12 oranges"), 5)
%!assert(sumUpDigits("12345"), 15)