function r = shapeArea(n)
	r = sum([n-1:n].^2);
endfunction
%!assert(shapeArea(2), 5)
%!assert(shapeArea(3), 13)
%!assert(shapeArea(1), 1)
%!assert(shapeArea(5), 41)
%!assert(shapeArea(7000), 97986001)
%!assert(shapeArea(8000), 127984001)
%!assert(shapeArea(9999), 199940005)
%!assert(shapeArea(9998), 199900013)
%!assert(shapeArea(8999), 161946005)
%!assert(shapeArea(100), 19801)