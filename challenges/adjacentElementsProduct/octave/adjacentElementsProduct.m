function x = adjacentElementsProduct(a)
	x = max(a(1:end-1).*a(2:end));
endfunction
%!assert(adjacentElementsProduct([3, 6, -2, -5, 7, 3]), 21)
%!assert(adjacentElementsProduct([-1, -2]), 2)
%!assert(adjacentElementsProduct([5, 1, 2, 3, 1, 4]), 6)
%!assert(adjacentElementsProduct([1, 2, 3, 0]), 6)
%!assert(adjacentElementsProduct([9, 5, 10, 2, 24, -1, -48]), 50)
%!assert(adjacentElementsProduct([5, 6, -4, 2, 3, 2, -23]), 30)
%!assert(adjacentElementsProduct([4, 1, 2, 3, 1, 5]), 6)
%!assert(adjacentElementsProduct([-23, 4, -3, 8, -12]), -12)
%!assert(adjacentElementsProduct([1, 0, 1, 0, 1000]), 0)