function res = isPermutation (n, inputArray)
	sortedArray = sort(inputArray);
	res = all(sortedArray == 1:n) && sortedArray(end) == n;
endfunction
%!assert(isPermutation(4, [1, 3, 2, 4]), true)
%!assert(isPermutation(3, [2, 3, 2]), false)
%!assert(isPermutation(2, [2, 0]), false)
%!assert(isPermutation(1, [1]), true)
%!assert(isPermutation(1, [0]), false)
%!assert(isPermutation(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]), false)
%!assert(isPermutation(7, [1, 2, 3, 4, 5, 6, 7]), true)
%!assert(isPermutation(5, [5, 1, 3, 4, 2]), true)
%!assert(isPermutation(8, [1, 3, 4, 5, 6, 7, 8, 9]), false)
%!assert(isPermutation(8, [88, 8, 8, 88, 8, 80, 18, 28]), false)