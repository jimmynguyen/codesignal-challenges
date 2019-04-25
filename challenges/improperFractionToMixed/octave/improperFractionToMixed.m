function r = improperFractionToMixed(a)
	r = [floor(a(1)/a(2)), mod(a(1), a(2)), a(2)];
endfunction
%!assert(improperFractionToMixed([7, 2]), [3, 1, 2])
%!assert(improperFractionToMixed([10, 3]), [3, 1, 3])