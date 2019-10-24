function m = deleteDigit(n)
	s = num2str(n);
	m = -1;
	for i = 1:length(s)
		v = str2num([s(1:i-1) s(i+1:end)]);
		if m < v
			m = v;
		endif
	endfor
endfunction
%!assert(deleteDigit(152), 52)
%!assert(deleteDigit(1001), 101)
%!assert(deleteDigit(10), 1)
%!assert(deleteDigit(222219), 22229)
%!assert(deleteDigit(109), 19)
%!assert(deleteDigit(222250), 22250)
%!assert(deleteDigit(44435), 4445)
%!assert(deleteDigit(12), 2)
%!assert(deleteDigit(218616), 28616)
%!assert(deleteDigit(861452), 86452)