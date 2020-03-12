function r = countVowelConsonant(s)
	r = 2*sum(s >= 'a' & s <= 'z') - sum(s == 'a' | s == 'e' | s == 'i' | s == 'o' | s == 'u');
endfunction
%!assert(countVowelConsonant("a"), 1)
%!assert(countVowelConsonant("abcde"), 8)
%!assert(countVowelConsonant(""), 0)
%!assert(countVowelConsonant("oqaawtnkqo"), 16)
%!assert(countVowelConsonant("aiauaia"), 7)
%!assert(countVowelConsonant("dsnhpbpfkmqbclwy"), 32)
%!assert(countVowelConsonant("qrkwwqawbxgaasksrfpacpwhfobgfh"), 55)
%!assert(countVowelConsonant("fpwbqfvucwepocdapglyxwnqwlegsqxhxlfkmfaz"), 74)
%!assert(countVowelConsonant("teilziwavjyjykgccxkdzsalpkvnxoynpfpowgmhfvozwdbems"), 91)