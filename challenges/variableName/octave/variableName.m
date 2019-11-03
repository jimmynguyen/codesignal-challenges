function valid = variableName(name)
    valid = all(name >= 'a' & name <= 'z' | name >= 'A' & name <= 'Z' | name >= '0' & name <= '9' | name == '_') && (name(1) < '0' || name(1) > '9');
endfunction
%!assert(variableName("var_1__Int"), true)
%!assert(variableName("qq-q"), false)
%!assert(variableName("2w2"), false)
%!assert(variableName(" variable"), false)
%!assert(variableName("va[riable0"), false)
%!assert(variableName("variable0"), true)
%!assert(variableName("a"), true)
%!assert(variableName("_Aas_23"), true)
%!assert(variableName("a a_2"), false)
%!assert(variableName("0ss"), false)