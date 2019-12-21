function x = onlyEvenNumbers(l, r)
	x = [l:r](mod(l:r, 2) == 0);
endfunction
%!assert(onlyEvenNumbers(5, 10), [6, 8, 10])
%!assert(onlyEvenNumbers(11, 13), [12])