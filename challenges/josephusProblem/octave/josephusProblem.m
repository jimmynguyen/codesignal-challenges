function x = josephusProblem(n, k)
	x = 1:n;
	i = 0;
	while length(x) > 1
		i = mod(i+k-1, length(x));
		x(i+1) = [];
	endwhile
endfunction
%!assert(josephusProblem(3, 2), 3)
%!assert(josephusProblem(7, 2), 7)