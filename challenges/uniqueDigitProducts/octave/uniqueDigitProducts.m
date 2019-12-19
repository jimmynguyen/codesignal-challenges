function r = uniqueDigitProducts(a)
	r = length(unique(arrayfun(@(x) prod(arrayfun(@str2num, num2str(x))), a)));
endfunction
%!assert(uniqueDigitProducts([2, 8, 121, 42, 222, 23]), 3)
%!assert(uniqueDigitProducts([239]), 1)
%!assert(uniqueDigitProducts([100, 101, 111]), 2)
%!assert(uniqueDigitProducts([100, 23, 42, 239, 22339, 9999999, 456, 78, 228, 1488]), 10)
%!assert(uniqueDigitProducts([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]), 10)