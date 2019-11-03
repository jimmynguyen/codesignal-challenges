function a = allLongestStrings(a)
    l = cellfun(@length, a);
    a(l ~=  max(l)) = [];
endfunction
%!assert(allLongestStrings({"aba", "aa", "ad", "vcd", "aba"}), {"aba", "vcd",  "aba"})
%!assert(allLongestStrings({"aa"}), {"aa"})
%!assert(allLongestStrings({"abc", "eeee", "abcd", "dcd"}), {"eeee", "abcd"})
%!assert(allLongestStrings({"a", "abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa"}), {"zzzzzz", "abcdef", "aaaaaa"})
%!assert(allLongestStrings({"enyky", "benyky", "yely", "varennyky"}), {"varennyky"})
%!assert(allLongestStrings({"abacaba", "abacab", "abac", "xxxxxx"}), {"abacaba"})
%!assert(allLongestStrings({"young", "yooooooung", "hot", "or", "not", "come", "on", "fire", "water", "watermelon"}), {"yooooooung", "watermelon"})
%!assert(allLongestStrings({"onsfnib", "aokbcwthc", "jrfcw"}), {"aokbcwthc"})
%!assert(allLongestStrings({"lbgwyqkry"}), {"lbgwyqkry"})
%!assert(allLongestStrings({"i"}), {"i"})