function s = matrixTrace(m)
	n = length(m);
	m = cell2mat(m);
	s = sum(m(1:n+1:n^2));
endfunction
%!assert(matrixTrace({[1,1,1], [0,5,0], [2,1,3]}), 9)
%!assert(matrixTrace({[0,1,1], [0,0,0], [2,1,0]}), 0)