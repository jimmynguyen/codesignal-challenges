function r = makeArrayConsecutive(s)
	r = setdiff(min(s):max(s), s);
endfunction
%!assert(makeArrayConsecutive([6, 2, 3, 8]), [4, 5, 7])
%!assert(makeArrayConsecutive([-1, -3]), [-2])
%!assert(makeArrayConsecutive([-1, 3]), [0, 1, 2])
%!assert(makeArrayConsecutive([5, 4, 6]), ones(1,0))