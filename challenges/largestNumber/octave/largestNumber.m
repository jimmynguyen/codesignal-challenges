function res = largestNumber(n)
	res = str2num(arrayfun(@char, ones(1, n)*'9'));
endfunction
%!assert(largestNumber(2), 99)
%!assert(largestNumber(1), 9)
%!assert(largestNumber(7), 9999999)
%!assert(largestNumber(4), 9999)
%!assert(largestNumber(3), 999)