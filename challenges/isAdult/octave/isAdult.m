function res = isAdult (age, adulthoodAge)
	res = age >= adulthoodAge;
endfunction
%!assert(isAdult(18, 21), false)
%!assert(isAdult(1, 18), false)
%!assert(isAdult(20, 20), true)
%!assert(isAdult(19, 20), false)
%!assert(isAdult(21, 20), true)
%!assert(isAdult(20, 22), false)
%!assert(isAdult(25, 20), true)
%!assert(isAdult(1, 14), false)
%!assert(isAdult(1, 25), false)
%!assert(isAdult(25, 25), true)