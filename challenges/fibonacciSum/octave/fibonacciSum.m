function s = fibonacciSum(n)
	s = [n];
	if n > 1
		f = [0 1 1 2];
		while f(end) < n
			f(end+1) = sum(f(end-1:end));
		endwhile
		if f(end) ~= n
			s = [];
			i = length(f);
			while sum(s) < n
				if f(i) + sum(s) <= n
					s = [f(i) s];
				endif
				i = i-1;
			endwhile
		endif
	endif
endfunction
%!assert(fibonacciSum(20), [2, 5, 13])
%!assert(fibonacciSum(21), [21])
%!assert(fibonacciSum(33), [1, 3, 8, 21])