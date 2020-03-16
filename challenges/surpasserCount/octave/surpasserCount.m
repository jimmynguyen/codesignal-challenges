function s = surpasserCount(a)
	s = 0;
	for i = 1:length(a)
		s = s + sum(a(i) < a(i+1:end));
	endfor
endfunction
%!assert(surpasserCount([1, 2, 3, 4, 5]), 10)
%!assert(surpasserCount([54, 11, 58]), 2)
%!assert(surpasserCount([10, 20, 40, 2, 11]), 5)
%!assert(surpasserCount([0, 68, 75, 34, 89, 66, 76, 72, 25]), 20)
%!assert(surpasserCount([60, 64, 94, 30, 93, 84, 76, 16, 45, 0, 0, 57, 80]), 28)
%!assert(surpasserCount([75]), 0)
%!assert(surpasserCount([20, 100, 100, 1000000, 1000000]), 8)
%!assert(surpasserCount([13, 84, 4, 76]), 3)
%!assert(surpasserCount([52, 0, 0]), 0)
%!assert(surpasserCount([74, 68, 45, 90, 24, 20, 12, 75, 52, 84, 32, 40, 70, 44, 12]), 41)
%!assert(surpasserCount([92, 94, 90, 65, 96, 62, 76, 80, 35, 0, 66, 81, 30, 90, 25]), 32)
%!assert(surpasserCount([34, 96, 70, 80, 92, 34, 83, 80, 41, 44, 56, 10, 81, 56, 54, 56, 64, 36, 54, 94, 55, 88]), 110)
%!assert(surpasserCount([44, 63, 8, 36, 8, 83, 27, 37, 84, 60, 10, 80, 71, 4, 40, 4, 20, 0, 29, 68, 50, 3, 72, 75, 50, 34, 4, 70, 94, 96, 58]), 257)