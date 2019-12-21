function n = divideAsLongAsPossible(n, d)
	while mod(n, d) == 0
		n = n / d;
	endwhile
endfunction
%!assert(divideAsLongAsPossible(36, 3), 4)
%!assert(divideAsLongAsPossible(20, 2), 5)
%!assert(divideAsLongAsPossible(64, 4), 1)
%!assert(divideAsLongAsPossible(162, 3), 2)