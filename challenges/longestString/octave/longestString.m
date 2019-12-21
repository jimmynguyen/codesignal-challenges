function x = longestString(s)
	[~, i] = max(cellfun(@length, s));
	x = s{i};
endfunction
%!assert(longestString({"a", "ab", "c"}), "ab")
%!assert(longestString({"aa"}), "aa")
%!assert(longestString({"xyzte", "x", "xyz"}), "xyzte")