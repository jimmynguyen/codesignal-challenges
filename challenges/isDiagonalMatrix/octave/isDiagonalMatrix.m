function r = isDiagonalMatrix(matrix)
	r = true;
	for i = 1:length(matrix)
		row = matrix{i};
		row(i) = [];
		if any(row ~= 0)
			r = false;
			return
		endif
	endfor
endfunction
%!assert(isDiagonalMatrix({[1,0,0], [0,5,0], [0,0,3]}), true)
%!assert(isDiagonalMatrix({[1,0,0], [0,5,0], [2,0,3]}), false)
%!assert(isDiagonalMatrix({[1,0,0], [0,5,0], [0,1,0]}), false)
%!assert(isDiagonalMatrix({[1,0,0,0], [0,5,0,0], [0,0,0,0], [0,0,0,1000]}), true)
%!assert(isDiagonalMatrix({[0,0,0], [0,9,0], [0,0,0]}), true)
%!assert(isDiagonalMatrix({[0,0,0], [0,0,0], [0,1,0]}), false)
%!assert(isDiagonalMatrix({[0,1,1], [1,0,1], [1,1,0]}), false)
%!assert(isDiagonalMatrix({[1000,0,0,0], [0,1000,0,0], [0,0,1000,0], [0,0,0,1000]}), true)
%!assert(isDiagonalMatrix({[0,0,0,0], [0,0,0,0], [0,0,0,0], [0,0,0,0]}), true)
%!assert(isDiagonalMatrix({[0]}), true)