function res = computeDefiniteIntegral (l, r, p)
	n = 1:length(p);
	res = sum(p.*(r.^n./n - l.^n./n));
endfunction
%!assert(computeDefiniteIntegral(-1, 2, [0, 0, 0, 1]), 3.75)
%!assert(computeDefiniteIntegral(1, 3, [1, 0, 0, 4]), 82)
%!assert(computeDefiniteIntegral(-150, 150, [0, 1, 0, 1, 0, 2, 0, 3]), 0)