function r = shefferStroke(a, b)
	r = ~a | ~b;
endfunction
%!assert(shefferStroke(true, true), false)
%!assert(shefferStroke(false, true), true)
%!assert(shefferStroke(true, false), true)