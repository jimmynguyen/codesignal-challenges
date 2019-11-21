function s = removeDuplicateCharacters(s)
	s = s(arrayfun(@(x) sum(s == x), s) == 1);
endfunction
%!assert(removeDuplicateCharacters("zaabcbd"), "zcd")
%!assert(removeDuplicateCharacters("zzzzzzz"), "")