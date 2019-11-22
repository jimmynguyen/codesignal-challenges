function d = appleBoxes(k)
	d = sum([2:2:k].^2) - sum([1:2:k].^2);
endfunction
%!assert(appleBoxes(5), -15)
%!assert(appleBoxes(15), -120)
%!assert(appleBoxes(36), 666)
%!assert(appleBoxes(1), -1)
%!assert(appleBoxes(14), 105)
%!assert(appleBoxes(12), 78)
%!assert(appleBoxes(9), -45)
%!assert(appleBoxes(40), 820)
%!assert(appleBoxes(37), -703)