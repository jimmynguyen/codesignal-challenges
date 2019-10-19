function output = digitSum(n)
	output =  sum(arrayfun(@str2num, num2str(n)));
endfunction
%!assert(digitSum(111), 3)
%!assert(digitSum(0), 0)