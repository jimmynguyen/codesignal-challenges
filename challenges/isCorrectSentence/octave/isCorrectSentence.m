function r = isCorrectSentence(s)
	r = s(1) >= 'A' && s(1) <= 'Z' && s(end) == '.';
endfunction
%!assert(isCorrectSentence("This is a correct sentence."), true)
%!assert(isCorrectSentence("this is an incorrect sentence."), false)
%!assert(isCorrectSentence("This is another incorrect sentence"), false)
%!assert(isCorrectSentence("this."), false)
%!assert(isCorrectSentence("This"), false)
%!assert(isCorrectSentence("This."), true)
%!assert(isCorrectSentence("End ."), true)
%!assert(isCorrectSentence("True"), false)
%!assert(isCorrectSentence("true"), false)
%!assert(isCorrectSentence("Correct sentence."), true)