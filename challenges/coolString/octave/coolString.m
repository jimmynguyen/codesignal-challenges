function r = coolString(s)
	upper = s >= 'A' & s <= 'Z';
	lower = s >= 'a' & s <= 'z';
	r = all(upper | lower) && all(diff(find(upper)) == 2) && all(diff(find(lower)) == 2);
endfunction
%!assert(coolString("aQwFdA"), true)
%!assert(coolString("aAA"), false)
%!assert(coolString("q q"), false)
%!assert(coolString("wWw1"), false)
%!assert(coolString("2"), false)
%!assert(coolString("aAaAaAa"), true)
%!assert(coolString("z"), true)
%!assert(coolString("_"), false)
%!assert(coolString("AaAaAaAaAA"), false)
%!assert(coolString("z2ZkLzZ"), false)