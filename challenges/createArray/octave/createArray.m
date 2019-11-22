function arr = createArray(size)
	arr = ones(1, size);
endfunction
%!assert(createArray(4), [1, 1, 1, 1])
%!assert(createArray(2), [1, 1])
%!assert(createArray(1), [1])
%!assert(createArray(5), [1, 1, 1, 1, 1])
%!assert(createArray(49), [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1])