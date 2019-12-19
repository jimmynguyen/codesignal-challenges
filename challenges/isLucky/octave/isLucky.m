function r = isLucky(n)
	s = num2str(n);
	f = @(x) sum(arrayfun(@str2num, x));
	r = f(s(1:end/2)) == f(s(end/2+1:end));
endfunction
%!assert(isLucky(1230), true)
%!assert(isLucky(239017), false)
%!assert(isLucky(134008), true)
%!assert(isLucky(10), false)
%!assert(isLucky(11), true)
%!assert(isLucky(1010), true)
%!assert(isLucky(261534), false)
%!assert(isLucky(100000), false)
%!assert(isLucky(999999), true)
%!assert(isLucky(123321), true)