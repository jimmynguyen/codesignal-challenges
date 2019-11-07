function n = rangeBitCount(a, b)
	n = sum(cellfun(@(x) sum(arrayfun(@str2num, x)), @arrayfun(@dec2bin, a:b, 'UniformOutput', false)));
endfunction
%!assert(rangeBitCount(2, 7), 11)
%!assert(rangeBitCount(0, 1), 1)
%!assert(rangeBitCount(1, 10), 17)
%!assert(rangeBitCount(8, 9), 3)
%!assert(rangeBitCount(9, 10), 4)