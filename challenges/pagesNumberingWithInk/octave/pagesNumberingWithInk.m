function res = pagesNumberingWithInk(current, numberOfDigits)
	while numberOfDigits >= length(num2str(current))
		numberOfDigits = numberOfDigits - length(num2str(current));
		current = current + 1;
	endwhile
	res = current - 1;
endfunction
%!assert(pagesNumberingWithInk(1, 5), 5)
%!assert(pagesNumberingWithInk(21, 5), 22)
%!assert(pagesNumberingWithInk(8, 4), 10)
%!assert(pagesNumberingWithInk(21, 6), 23)
%!assert(pagesNumberingWithInk(76, 250), 166)
%!assert(pagesNumberingWithInk(80, 1000), 419)