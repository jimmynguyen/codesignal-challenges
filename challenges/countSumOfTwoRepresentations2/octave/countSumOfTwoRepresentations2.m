function c = countSumOfTwoRepresentations2(n, l, r)
	a = l:r;
	b = n - a;
	c = sum(b >= a & b <= r);
endfunction
%!assert(countSumOfTwoRepresentations2(6, 2, 4), 2)
%!assert(countSumOfTwoRepresentations2(6, 3, 3), 1)
%!assert(countSumOfTwoRepresentations2(10, 9, 11), 0)
%!assert(countSumOfTwoRepresentations2(24, 8, 16), 5)
%!assert(countSumOfTwoRepresentations2(24, 12, 12), 1)
%!assert(countSumOfTwoRepresentations2(93, 24, 58), 12)