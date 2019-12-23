function c = divisorsSubset(subset, n)
	c = 0;
	for i = 1:n
		divisors = [];
		for j = 1:sqrt(i)
			if mod(i, j) == 0
				divisors(end+1) = j;
				if i/j ~= j
					divisors(end+1) = i/j;
				endif
			endif
		endfor
		subsetInDivisors = true;
		for j = subset
			if ~any(divisors == j)
				subsetInDivisors = false;
				break;
			endif
		endfor
		if subsetInDivisors
			c = c + 1;
		endif
	endfor
endfunction
%!assert(divisorsSubset([2, 3], 13), 2)
%!assert(divisorsSubset([1], 62), 62)
%!assert(divisorsSubset([12, 2, 4, 6], 143), 11)