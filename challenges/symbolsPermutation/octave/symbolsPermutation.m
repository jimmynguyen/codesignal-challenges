function res = symbolsPermutation (word1, word2)
	res = length(word1) == length(word2) && sort(word1) == sort(word2);
endfunction
%!assert(symbolsPermutation("abc", "cab"), true)
%!assert(symbolsPermutation("aaaa", "aaa"), false)
%!assert(symbolsPermutation("sutr", "cybk"), false)
%!assert(symbolsPermutation("kscsa", "ncwxt"), false)
%!assert(symbolsPermutation("imazpsni", "kbyafemd"), false)
%!assert(symbolsPermutation("ekufzjmk", "chhmjxmy"), false)
%!assert(symbolsPermutation("seha", "zims"), false)
%!assert(symbolsPermutation("beicgzwj", "pazofnfl"), false)
%!assert(symbolsPermutation("nbimwm", "xwidkg"), false)
%!assert(symbolsPermutation("ryqa", "ayrq"), true)