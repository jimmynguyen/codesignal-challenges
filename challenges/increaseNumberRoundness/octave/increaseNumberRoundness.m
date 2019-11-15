function r = increaseNumberRoundness(n)
	r = any(diff(find(num2str(n) == '0')) > 1) || sum(num2str(n) == '0') == 1 && find(num2str(n) == '0') ~= length(num2str(n));
endfunction
%!assert(increaseNumberRoundness(902200100), true)
%!assert(increaseNumberRoundness(11000), false)
%!assert(increaseNumberRoundness(99080), true)
%!assert(increaseNumberRoundness(1022220), true)
%!assert(increaseNumberRoundness(106611), true)
%!assert(increaseNumberRoundness(234230), false)
%!assert(increaseNumberRoundness(888), false)
%!assert(increaseNumberRoundness(100), false)
%!assert(increaseNumberRoundness(1000000000), false)
%!assert(increaseNumberRoundness(103456789), true)