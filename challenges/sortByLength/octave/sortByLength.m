function r = sortByLength(a)
	[~, i] = sort(cellfun('length', a));
	r = a(i);
endfunction
%!assert(sortByLength({"abc", "", "aaa", "a", "zz"}), {"", "a", "zz", "abc", "aaa"})
%!assert(sortByLength({"zz", "", "bb", "ccc", "cc"}), {"", "zz", "bb", "cc", "ccc"})
%!assert(sortByLength({"abc", "e", "abcd"}), {"e", "abc", "abcd"})
%!assert(sortByLength({"a", "c", "a", "a"}), {"a", "c", "a", "a"})
%!assert(sortByLength({"thitl", "", "sadhxirg", "hx", "ondyxds", "kncor", "sqrg", "hqtchyxku", "rl", "wd"}), {"", "hx", "rl", "wd", "sqrg", "thitl", "kncor", "ondyxds", "sadhxirg", "hqtchyxku"})