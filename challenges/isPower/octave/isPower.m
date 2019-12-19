function res = isPower(n)
	if n == 1
		res = true;
		return;
	endif
	res = false;
	for i = 2:sqrt(n)
		if mod(nthroot(n, i), 1) == 0
			res = true;
			return;
		endif
	endfor
endfunction
%!assert(isPower(125), true)
%!assert(isPower(72), false)
%!assert(isPower(100), true)
%!assert(isPower(11), false)
%!assert(isPower(324), true)
%!assert(isPower(256), true)
%!assert(isPower(119), false)
%!assert(isPower(400), true)
%!assert(isPower(350), false)
%!assert(isPower(361), true)