function c = excelSheetColumnNumber(s)
	n = length(s);
	c = 0;
	for i = 1:n
		c = c + (s(i)-'A'+1)*26^(n-i);
	endfor
endfunction
%!assert(excelSheetColumnNumber("AB"), 28)
%!assert(excelSheetColumnNumber("A"), 1)
%!assert(excelSheetColumnNumber("ZZ"), 702)
%!assert(excelSheetColumnNumber("OPQ"), 10573)
%!assert(excelSheetColumnNumber("DEAD"), 73714)
%!assert(excelSheetColumnNumber("SHEET"), 8826682)
%!assert(excelSheetColumnNumber("RABBIT"), 214358502)