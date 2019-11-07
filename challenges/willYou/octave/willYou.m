function wrong = willYou(young, beautiful, loved)
	wrong = young && beautiful && ~loved || loved && (~young || ~beautiful);
endfunction
%!assert(willYou(true, true, true), false)
%!assert(willYou(true, false, true), true)
%!assert(willYou(false, false, false), false)
%!assert(willYou(false, false, true), true)