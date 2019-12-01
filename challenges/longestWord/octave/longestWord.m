function maxWord = longestWord(text)
	getLettersMask = @(s) s >= 'A' & s <= 'Z' | s >= 'a' & s <= 'z';
	lettersIndices = find(getLettersMask(text));
	gapIndices = lettersIndices(find(diff(lettersIndices) > 1));
	n = length(gapIndices);
	if n > 0
		maxWord = text(1:gapIndices(1));
		maxWord = maxWord(getLettersMask(maxWord));
		maxLength = length(maxWord);
		for i = 1:n
			if i == n
				word = text(gapIndices(n)+1:end);
			else
				word = text(gapIndices(i)+1:gapIndices(i+1));
			endif
			word = word(getLettersMask(word));
			if length(word) > maxLength
				maxLength = length(word);
				maxWord = word;
			endif
		endfor
	else
		maxWord = text(getLettersMask(text));
	endif
endfunction
%!assert(longestWord("Ready, steady, go!"), "steady")
%!assert(longestWord("Ready[[[, steady, go!"), "steady")
%!assert(longestWord("ABCd"), "ABCd")
%!assert(longestWord("To be or not to be"), "not")
%!assert(longestWord("You are the best!!!!!!!!!!!! CodeFighter ever!"), "CodeFighter")