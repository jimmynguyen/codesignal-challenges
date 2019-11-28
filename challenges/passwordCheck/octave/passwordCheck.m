function r = passwordCheck(s)
	r = length(s) > 4 & any(s >= 'A' & s <= 'Z') & any(s >= 'a' & s <= 'z') & any(s >= '0' & s <= '9');
endfunction
%!assert(passwordCheck("my.Password123"), true)
%!assert(passwordCheck("my.password123"), false)
%!assert(passwordCheck("aaAZ0"), true)
%!assert(passwordCheck("AAAZ0"), false)
%!assert(passwordCheck("fdhifeiUHDhfiue"), false)
%!assert(passwordCheck("fdhifeiUHDhf1ue"), true)
%!assert(passwordCheck("oO0"), false)
%!assert(passwordCheck("11llI"), true)
%!assert(passwordCheck("zfERIav.;{wa]@#"), false)
%!assert(passwordCheck("..............."), false)