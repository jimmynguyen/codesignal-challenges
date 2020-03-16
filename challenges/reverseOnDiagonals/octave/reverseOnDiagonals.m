function matrix = reverseOnDiagonals(matrix)
	n = length(matrix);
	m = transpose(reshape(cell2mat(matrix), n, n));
	m(1:n+1:end) = m(end:-n-1:1);
	m(n:n-1:end-n+1) = m(end-n+1:-n+1:n);
	for i = 1:n
		matrix{i} = m(i:n:end);
	endfor
endfunction
%!assert(reverseOnDiagonals({[1,2,3], [4,5,6], [7,8,9]}), {[9,2,7], [4,5,6], [3,8,1]})
%!assert(reverseOnDiagonals({[239]}), {[239]})
%!assert(reverseOnDiagonals({[1,10], [100,1000]}), {[1000,100], [10,1]})
%!assert(reverseOnDiagonals({[43,455,32,103], [102,988,298,981], [309,21,53,64], [2,22,35,291]}), {[291,455,32,2], [102,53,21,981], [309,298,988,64], [103,22,35,43]})
%!assert(reverseOnDiagonals({[34,1000,139,248,972,584], [98,1,398,128,762,654], [33,498,132,543,764,43], [329,12,54,764,666,213], [928,109,489,71,837,332], [93,298,42,53,76,43]}), {[43,1000,139,248,972,93], [98,837,398,128,109,654], [33,498,764,54,764,43], [329,12,543,132,666,213], [928,762,489,71,1,332], [584,298,42,53,76,34]})
%!assert(reverseOnDiagonals({[1,1], [2,2]}), {[2,2], [1,1]})