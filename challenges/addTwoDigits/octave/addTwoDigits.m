function res = addTwoDigits(n)
	res = sum(arrayfun(@str2num, num2str(n)));
endfunction
%!assert(addTwoDigits(29), 11)
%!assert(addTwoDigits(48), 12)
%!assert(addTwoDigits(10), 1)
%!assert(addTwoDigits(25), 7)
%!assert(addTwoDigits(52), 7)
%!assert(addTwoDigits(99), 18)
%!assert(addTwoDigits(44), 8)
%!assert(addTwoDigits(50), 5)
%!assert(addTwoDigits(39), 12)
%!assert(addTwoDigits(26), 8)