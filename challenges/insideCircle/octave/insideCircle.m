function res = insideCircle(point, center, radius)
	res = sqrt(sum((point - center).^2)) <= radius;
endfunction
%!assert(insideCircle([1, 1], [2, 2], 1), false)
%!assert(insideCircle([1, 1], [0, 0], 3), true)
%!assert(insideCircle([-1, -1], [-2, -2], 2), true)
%!assert(insideCircle([1, 1], [2, 2], 2), true)
%!assert(insideCircle([0, 0], [0, 0], 1), true)
%!assert(insideCircle([-1, -1], [2, 2], 2), false)
%!assert(insideCircle([100, -100], [-10, 10], 5), false)
%!assert(insideCircle([10, 10], [5, 10], 5), true)
%!assert(insideCircle([0, -1], [0, -2], 5), true)
%!assert(insideCircle([-1, -1], [-2, -2], 4), true)