function x = eulersTotientFunction(n)
	x = 0;
	for i = 1:n
		if coprime(i, n)
			x = x + 1;
		endif
	endfor
endfunction

function x = coprime(a, b)
	x = gcd(a, b) == 1;
endfunction

function x = gcd(a, b)
	while a ~= 0 && b ~= 0
		if a > b
			a = mod(a, b);
		else
			b = mod(b, a);
		endif
	endwhile
	x = max([a b]);
endfunction
%!assert(eulersTotientFunction(5), 4)
%!assert(eulersTotientFunction(49), 42)
%!assert(eulersTotientFunction(1), 1)
%!assert(eulersTotientFunction(69), 44)