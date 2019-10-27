function r = isLuckyNumber(n)
	a = arrayfun(@str2num, num2str(n));
	r = all(a == 4 | a == 7);
endfunction
%!assert(isLuckyNumber(47), true)
%!assert(isLuckyNumber(1), false)
%!assert(isLuckyNumber(54), false)
%!assert(isLuckyNumber(1231), false)
%!assert(isLuckyNumber(7777), true)
%!assert(isLuckyNumber(123451), false)
%!assert(isLuckyNumber(10000000), false)
%!assert(isLuckyNumber(4747444), true)
%!assert(isLuckyNumber(4444), true)
%!assert(isLuckyNumber(4), true)