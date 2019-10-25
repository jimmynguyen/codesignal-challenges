function c = equationSolutions(l, r)
    c = 0;
    for a = l:r
        for b = l:r
            if a^3 == b^2
                c = c + 1;
            endif
        endfor
    endfor
endfunction
%!assert(equationSolutions(1, 4), 1)
%!assert(equationSolutions(1, 8), 2)
%!assert(equationSolutions(1, 30), 3)
%!assert(equationSolutions(0, 10), 3)
%!assert(equationSolutions(-10, 10), 5)
%!assert(equationSolutions(1, 100), 4)