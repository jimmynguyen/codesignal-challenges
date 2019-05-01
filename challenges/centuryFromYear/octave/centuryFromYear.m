function r = centuryFromYear(y)
	r = floor(y/100) + (mod(y, 100)~=0);
endfunction
%!assert(centuryFromYear(1905), 20)
%!assert(centuryFromYear(1700), 17)
%!assert(centuryFromYear(1988), 20)
%!assert(centuryFromYear(2000), 20)
%!assert(centuryFromYear(2001), 21)
%!assert(centuryFromYear(200), 2)
%!assert(centuryFromYear(374), 4)
%!assert(centuryFromYear(45), 1)
%!assert(centuryFromYear(8), 1)