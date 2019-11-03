function res = almostIncreasingSequence(sequence)
	mask = diff(sequence) < 0;
	ndx = find(~mask);
	n = length(sequence);
	res = (n == 2 || sum(mask) == 1 && (all(diff(sequence([1 ndx+1])) > 0) || all(diff(sequence([ndx n])) > 0)));
endfunction

function res = almostIncreasingSequence_iterative(sequence)
	res = false;
	for i = 1:length(sequence)
		subSequence = sequence([1:i-1, i+1:end]);
		if all(diff(subSequence) > 0)
			res = true;
			return;
		endif
	endfor
endfunction
%!assert(almostIncreasingSequence([1, 3, 2, 1]), false)
%!assert(almostIncreasingSequence([1, 3, 2]), true)
%!assert(almostIncreasingSequence([1, 2, 1, 2]), false)
%!assert(almostIncreasingSequence([3, 6, 5, 8, 10, 20, 15]), false)
%!assert(almostIncreasingSequence([1, 1, 2, 3, 4, 4]), false)
%!assert(almostIncreasingSequence([1, 4, 10, 4, 2]), false)
%!assert(almostIncreasingSequence([10, 1, 2, 3, 4, 5]), true)
%!assert(almostIncreasingSequence([1, 1, 1, 2, 3]), false)
%!assert(almostIncreasingSequence([0, -2, 5, 6]), true)
%!assert(almostIncreasingSequence([1, 2, 3, 4, 5, 3, 5, 6]), false)
%!assert(almostIncreasingSequence([40, 50, 60, 10, 20, 30]), false)
%!assert(almostIncreasingSequence([1, 1]), true)
%!assert(almostIncreasingSequence([1, 2, 5, 3, 5]), true)
%!assert(almostIncreasingSequence([1, 2, 5, 5, 5]), false)
%!assert(almostIncreasingSequence([10, 1, 2, 3, 4, 5, 6, 1]), false)
%!assert(almostIncreasingSequence([1, 2, 3, 4, 3, 6]), true)
%!assert(almostIncreasingSequence([1, 2, 3, 4, 99, 5, 6]), true)
%!assert(almostIncreasingSequence([123, -17, -5, 1, 2, 3, 12, 43, 45]), true)
%!assert(almostIncreasingSequence([3, 5, 67, 98, 3]), true)