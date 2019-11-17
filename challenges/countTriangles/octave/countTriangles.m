function c = countTriangles(x, y)
	n = length(x);
	c = 0;
	for i = 1:n
		for j = i+1:n
			for k = j+1:n
				if x(i)*(y(j)-y(k)) + x(j)*(y(k)-y(i)) + x(k)*(y(i)-y(j)) ~= 0
					c = c + 1;
				endif
			endfor
		endfor
	endfor
endfunction
%!assert(countTriangles([0, 0, 1, 1], [0, 1, 1, 0]), 4)
%!assert(countTriangles([0, -1, -2], [0, -2, -4]), 0)
%!assert(countTriangles([0, 0, 0, 0], [1, 2, 3, 4]), 0)
%!assert(countTriangles([0, 0, 0, 0, 10], [1, 2, 3, 4, -10]), 6)
%!assert(countTriangles([10, 5, 7, 8, 9], [-2, -3, 5, 6, 8]), 10)