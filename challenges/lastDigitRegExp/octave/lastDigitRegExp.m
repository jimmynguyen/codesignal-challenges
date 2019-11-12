function n = lastDigitRegExp(s)
	n = s(regexp(s, '[0-9]')(end));
endfunction
%!assert(lastDigitRegExp("var_1__Int"), "1")
%!assert(lastDigitRegExp("qq2q"), "2")
%!assert(lastDigitRegExp("0ss"), "0")
%!assert(lastDigitRegExp("3w2"), "2")