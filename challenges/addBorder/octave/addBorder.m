function p = addBorder(p)
	p = [char('*'*ones(1, length(p{1})+2)) cellfun(@(x) ['*' x '*'], p, 'UniformOutput', false) char('*'*ones(1, length(p{1})+2))];
endfunction
%!assert(addBorder({"abc", "ded"}), {"*****", "*abc*", "*ded*", "*****"})
%!assert(addBorder({"a"}), {"***", "*a*", "***"})
%!assert(addBorder({"aa", "**", "zz"}), {"****", "*aa*", "****", "*zz*", "****"})
%!assert(addBorder({"abcde", "fghij", "klmno", "pqrst", "uvwxy"}), {"*******", "*abcde*", "*fghij*", "*klmno*", "*pqrst*", "*uvwxy*", "*******"})
%!assert(addBorder({"wzy**"}), {"*******", "*wzy***", "*******"})