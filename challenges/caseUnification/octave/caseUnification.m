function s = caseUnification(s)
	if length(s(s >= 'A' & s <= 'Z')) > length(s)/2
		s = toupper(s);
	else
		s = tolower(s);
	endif
endfunction
%!assert(caseUnification("Aba"), "aba")
%!assert(caseUnification("ABa"), "ABA")
%!assert(caseUnification("ZZZZZ"), "ZZZZZ")