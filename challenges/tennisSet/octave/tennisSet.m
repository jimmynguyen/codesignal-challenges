function set = tennisSet(score1, score2)
	set = max(score1, score2) == 6 && min(score1, score2) < 5 || max(score1, score2) == 7 && min(score1, score2) >= 5 && min(score1, score2) <= 6;
endfunction
%!assert(tennisSet(3, 6), true)
%!assert(tennisSet(8, 5), false)
%!assert(tennisSet(6, 5), false)
%!assert(tennisSet(7, 7), false)
%!assert(tennisSet(6, 4), true)
%!assert(tennisSet(7, 5), true)
%!assert(tennisSet(7, 2), false)
%!assert(tennisSet(7, 6), true)
%!assert(tennisSet(4, 10), false)
%!assert(tennisSet(0, 0), false)