function x = pointInLine(point, line)
	x = sum(point.*line(1:2)) == -line(3);
endfunction
%!assert(pointInLine([0, 1], [1, 1, 0]), false)
%!assert(pointInLine([1, -1], [1, 1, 0]), true)
%!assert(pointInLine([10, 7], [1, 0, -10]), true)
%!assert(pointInLine([100, 0], [1, 0, -10]), false)
%!assert(pointInLine([-100, -100], [1, 0, 100]), true)
%!assert(pointInLine([-18, -95], [-47, -21, -35]), false)
%!assert(pointInLine([-16, -3], [47, -51, -38]), false)
%!assert(pointInLine([0, 0], [-70, -23, 0]), true)
%!assert(pointInLine([53, 42], [-13, 52, 20]), false)
%!assert(pointInLine([22, -70], [36, 11, -22]), true)