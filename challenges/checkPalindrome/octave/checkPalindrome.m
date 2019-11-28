function r = checkPalindrome(s)
	r = all(s(1:end/2) == s(end:-1:end/2+1));
endfunction
%!assert(checkPalindrome("aabaa"), true)
%!assert(checkPalindrome("abac"), false)
%!assert(checkPalindrome("a"), true)
%!assert(checkPalindrome("az"), false)
%!assert(checkPalindrome("abacaba"), true)
%!assert(checkPalindrome("z"), true)
%!assert(checkPalindrome("aaabaaaa"), false)
%!assert(checkPalindrome("zzzazzazz"), false)
%!assert(checkPalindrome("hlbeeykoqqqqokyeeblh"), true)
%!assert(checkPalindrome("hlbeeykoqqqokyeeblh"), true)