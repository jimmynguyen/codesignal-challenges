function res = percentageGreen(green, total)
	res = green / total * 100;
endfunction
%!assert(percentageGreen(2, 5), 40)
%!assert(percentageGreen(4, 5), 80)