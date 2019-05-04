function arr = replaceMiddle(arr)
	if mod(length(arr), 2) == 0
		arr = [arr(1:end/2-1), sum(arr(end/2:end/2+1)), arr(end/2+2:end)];
	endif
endfunction
%!assert(replaceMiddle([7, 2, 2, 5, 10, 7]), [7, 2, 7, 10, 7])
%!assert(replaceMiddle([-5, -5, 10]), [-5, -5, 10])
%!assert(replaceMiddle([45, 23, 12, 33, 12, 453, -234, -45]), [45, 23, 12, 45, 453, -234, -45])
%!assert(replaceMiddle([2, 8]), [10])
%!assert(replaceMiddle([-12, 34, 40, -5, -12, 4, 0, 0, -12]), [-12, 34, 40, -5, -12, 4, 0, 0, -12])
%!assert(replaceMiddle([9, 0, 15, 9]), [9, 15, 9])
%!assert(replaceMiddle([-6, 6, -6]), [-6, 6, -6])
%!assert(replaceMiddle([26, 26, -17]), [26, 26, -17])
%!assert(replaceMiddle([-7, 5, 5, 10]), [-7, 10, 10])