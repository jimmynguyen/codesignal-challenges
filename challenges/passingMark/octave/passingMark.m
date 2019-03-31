function r = passingMark (p, g)
	h = g;
	h(g == 'A') = 'E';
	h(g == 'B') = 'D';
	h(g == 'D') = 'B';
	h(g == 'E') = 'A';
	r = mean(h-'A'+1) >= p;
endfunction
%!assert(passingMark(3.5, "ABC"), true)
%!assert(passingMark(4, "BBCD"), false)
%!assert(passingMark(1, "DEEEEEEEE"), true)
%!assert(passingMark(4, "B"), true)
%!assert(passingMark(4.8, "AAAB"), false)
%!assert(passingMark(4.8, "AAAAAAAAAAAAABB"), true)
%!assert(passingMark(4.8, "AAAAAAAAAABBBBB"), false)
%!assert(passingMark(4.9, "AAAAAAAAAAAAABB"), false)
%!assert(passingMark(4.8, "A"), true)
%!assert(passingMark(2.1, "E"), false)