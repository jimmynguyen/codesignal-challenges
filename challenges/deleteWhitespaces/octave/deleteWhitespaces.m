function s = deleteWhitespaces(s)
	s(s==' ') = [];
endfunction
%!assert(deleteWhitespaces("a  b cd  e"), "abcde")
%!assert(deleteWhitespaces("a   b c  dc "), "abcdc")