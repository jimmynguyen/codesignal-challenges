function s = greetPerson(s)
	s = ['Hello, ' s];
endfunction
%!assert(greetPerson("Polly"), "Hello, Polly")
%!assert(greetPerson("Ann"), "Hello, Ann")