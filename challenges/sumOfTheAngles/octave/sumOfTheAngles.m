function r = sumOfTheAngles(n)
	r = (n-2)*180;
endfunction
%!assert(sumOfTheAngles(3), 180)
%!assert(sumOfTheAngles(4), 360)