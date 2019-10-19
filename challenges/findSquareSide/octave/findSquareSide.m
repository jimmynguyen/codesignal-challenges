function d = findSquareSide(x, y)
	lengths = [];
	for i = 2:length(x)
		lengths(i-1) = (x(1) - x(i))^2 + (y(1) - y(i))^2;
	endfor
	d = mode(lengths);
endfunction
%!assert(findSquareSide([0, 1, 0, 1], [0, 1, 1, 0]), 1)
%!assert(findSquareSide([0, 1, 1, 0], [0, 1, 0, 1]), 1)
%!assert(findSquareSide([0, -1, -4, -3], [-1, -4, -3, 0]), 10)