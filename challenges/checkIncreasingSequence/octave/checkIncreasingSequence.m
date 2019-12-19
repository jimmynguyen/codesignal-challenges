function res = checkIncreasingSequence(seq)
	res = all(diff(seq) > 0);
endfunction
%!assert(checkIncreasingSequence([1, 3, 8]), true)
%!assert(checkIncreasingSequence([2, 2, 3]), false)
%!assert(checkIncreasingSequence([2, 2]), false)
%!assert(checkIncreasingSequence([1, 2, 4, 6, 11]), true)
%!assert(checkIncreasingSequence([1, 3, 1, 2, 3]), false)
%!assert(checkIncreasingSequence([3, 2, 1]), false)
%!assert(checkIncreasingSequence([1, 2, 3, 4, 5, 4]), false)
%!assert(checkIncreasingSequence([1, 2, 2, 3, 4, 5]), false)
%!assert(checkIncreasingSequence([1, 2, 3, 4, 5]), true)
%!assert(checkIncreasingSequence([1]), true)