function p = fixedPointsPermutation(p)
	p = sum(p == 1:length(p));
endfunction
%!assert(fixedPointsPermutation([1, 3, 2, 4, 5, 6]), 4)
%!assert(fixedPointsPermutation([1, 2, 3]), 3)
%!assert(fixedPointsPermutation([3, 1, 2]), 0)