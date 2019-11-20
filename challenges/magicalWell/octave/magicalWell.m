function r = magicalWell(a, b, n)
	r = sum((a + [0:n-1]) .* (b + [0:n-1]));
endfunction
%!assert(magicalWell(1, 2, 2), 8)
%!assert(magicalWell(1, 1, 1), 1)
%!assert(magicalWell(6, 5, 3), 128)
%!assert(magicalWell(1601, 337, 0), 0)
%!assert(magicalWell(1891, 352, 0), 0)
%!assert(magicalWell(1936, 1835, 5), 17800540)
%!assert(magicalWell(957, 57, 2), 110113)
%!assert(magicalWell(687, 1337, 0), 0)
%!assert(magicalWell(491, 1552, 4), 3060400)
%!assert(magicalWell(1275, 362, 2), 924738)