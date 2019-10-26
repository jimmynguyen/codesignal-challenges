function n = piecesOfDistinctLengths(s)
	n = 0;
	while s > n
		n = n + 1;
		s = s - n;
	endwhile
endfunction
%!assert(piecesOfDistinctLengths(14), 4)
%!assert(piecesOfDistinctLengths(3), 2)
%!assert(piecesOfDistinctLengths(4), 2)
%!assert(piecesOfDistinctLengths(7), 3)
%!assert(piecesOfDistinctLengths(10), 4)
%!assert(piecesOfDistinctLengths(15), 5)
%!assert(piecesOfDistinctLengths(100), 13)