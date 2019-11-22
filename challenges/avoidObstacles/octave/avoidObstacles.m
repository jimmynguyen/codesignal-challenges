function stepSize = avoidObstacles(obstacles)
	obstacles = sort(obstacles);
	goal = max(obstacles) + 1;
	stepSize = 1;
	while ~isempty(intersect(0:stepSize:goal, obstacles))
		stepSize = stepSize + 1;
	endwhile
endfunction
%!assert(avoidObstacles([5, 3, 6, 7, 9]), 4)
%!assert(avoidObstacles([2, 3]), 4)
%!assert(avoidObstacles([1, 4, 10, 6, 2]), 7)
%!assert(avoidObstacles([1000, 999]), 6)
%!assert(avoidObstacles([19, 32, 11, 23]), 3)
%!assert(avoidObstacles([5, 8, 9, 13, 14]), 6)