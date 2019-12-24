function s = capitalizeVowelsRegExp(s)
	i = regexp(s, '[aeiouy]');
	s(i) = s(i) - 'a' + 'A';
endfunction
%!assert(capitalizeVowelsRegExp("There are 12 points"), "ThErE ArE 12 pOInts")
%!assert(capitalizeVowelsRegExp(" _Aaaaas 23"), " _AAAAAs 23")
%!assert(capitalizeVowelsRegExp(" a_2"), " A_2")