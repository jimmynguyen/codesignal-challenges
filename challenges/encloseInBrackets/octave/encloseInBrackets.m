function s = encloseInBrackets(s)
	s = ['(' s ')'];
endfunction
%!assert(encloseInBrackets("abacaba"), "(abacaba)")
%!assert(encloseInBrackets("abcdef"), "(abcdef)")
%!assert(encloseInBrackets("aaad"), "(aaad)")
%!assert(encloseInBrackets("if"), "(if)")
%!assert(encloseInBrackets("it"), "(it)")
%!assert(encloseInBrackets("doesnt"), "(doesnt)")
%!assert(encloseInBrackets("challenge"), "(challenge)")
%!assert(encloseInBrackets("you"), "(you)")
%!assert(encloseInBrackets("itt"), "(itt)")
%!assert(encloseInBrackets("wont"), "(wont)")