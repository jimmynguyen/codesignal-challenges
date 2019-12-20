function r = SoF(n)
	v = [1];
	for i = 2:n
		v(end+1) = v(end) * i;
	endfor
	r = sum(v);
endfunction
%!assert(SoF(1), 1)
%!assert(SoF(2), 3)
%!assert(SoF(3), 9)
%!assert(SoF(4), 33)
%!assert(SoF(5), 153)
%!assert(SoF(6), 873)