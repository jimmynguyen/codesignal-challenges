function s = matrixElementsSum(m)
	r = length(m);
	c = length(m{1});
	m = transpose(reshape(cell2mat(m), c, r));
	a = m > 0;
	for i = 1:c
		ndx = find(m(:, i) == 0);
		if ~isempty(ndx)
			a(ndx(1):end, i) = false;
		endif
	endfor
	s = sum(m(a));
endfunction
%!assert(matrixElementsSum({[0,1,1,2], [0,5,0,0], [2,0,3,3]}), 9)
%!assert(matrixElementsSum({[1,1,1,0], [0,5,0,1], [2,1,3,10]}), 9)
%!assert(matrixElementsSum({[1,1,1], [2,2,2], [3,3,3]}), 18)
%!assert(matrixElementsSum({[0]}), 0)
%!assert(matrixElementsSum({[1,0,3], [0,2,1], [1,2,0]}), 5)
%!assert(matrixElementsSum({[1], [5], [0], [2]}), 6)
%!assert(matrixElementsSum({[1,2,3,4,5]}), 15)
%!assert(matrixElementsSum({[2], [5], [10]}), 17)
%!assert(matrixElementsSum({[4,0,1], [10,7,0], [0,0,0], [9,1,2]}), 15)
%!assert(matrixElementsSum({[1]}), 1)