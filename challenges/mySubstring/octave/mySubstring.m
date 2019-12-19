function s = mySubstring(s, l, r)
	s = s(l+1:r+1);
endfunction
%!assert(mySubstring("abcde", 2, 3), "cd")
%!assert(mySubstring("abcdef", 0, 2), "abc")