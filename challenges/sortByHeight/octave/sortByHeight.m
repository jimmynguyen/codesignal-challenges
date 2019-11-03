function a = sortByHeight(a)
	a(a > -1) = sort(a(a > -1));
endfunction
%!assert(sortByHeight([-1, 150, 190, 170, -1, -1, 160, 180]), [-1, 150, 160, 170, -1, -1, 180, 190])
%!assert(sortByHeight([-1, -1, -1, -1, -1]), [-1, -1, -1, -1, -1])
%!assert(sortByHeight([-1]), [-1])
%!assert(sortByHeight([4, 2, 9, 11, 2, 16]), [2, 2, 4, 9, 11, 16])
%!assert(sortByHeight([2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1]), [1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2])
%!assert(sortByHeight([23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3]), [1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77])