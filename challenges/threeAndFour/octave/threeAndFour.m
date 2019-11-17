function r = threeAndFour(n)
	r = [0:n-1](mod(0:n-1, 3) == 0 & mod(0:n-1, 4) == 0);
endfunction
%!assert(threeAndFour(30), [0, 12, 24])
%!assert(threeAndFour(3), [0])