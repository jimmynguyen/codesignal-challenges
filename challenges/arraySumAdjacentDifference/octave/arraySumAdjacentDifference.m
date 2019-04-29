function output = arraySumAdjacentDifference(inputArray)
	output = sum(abs(diff(inputArray)));
endfunction
%!assert(arraySumAdjacentDifference([4, 7, 1, 2]), 10)
%!assert(arraySumAdjacentDifference([1, 5, 10, 4, 2]), 17)
%!assert(arraySumAdjacentDifference([1, 1, 1, 1]), 0)