function s = rangeDigitSum(A, B)
	s = sum(arrayfun(@str2num, [arrayfun(@num2str, A:B, 'UniformOutput', false){:}]));
endfunction
%!assert(rangeDigitSum(1, 10), 46)
%!assert(rangeDigitSum(3, 15), 63)
%!assert(rangeDigitSum(51, 56), 51)
%!assert(rangeDigitSum(48, 310), 2779)