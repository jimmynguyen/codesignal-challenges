function res = isSumOfConsecutive2 (n)
    i = 1;
    res = 0;
    while i < n
        s = i;
        for j = i+1:n-1
            s = s + j;
            if s == n
                res = res + 1;
                break;
            elseif s > n
                break;
            endif
        endfor
        i++;
    endwhile
endfunction
%!assert(isSumOfConsecutive2(9), 2)
%!assert(isSumOfConsecutive2(8), 0)
%!assert(isSumOfConsecutive2(15), 3)
%!assert(isSumOfConsecutive2(24), 1)
%!assert(isSumOfConsecutive2(13), 1)
%!assert(isSumOfConsecutive2(25), 2)
%!assert(isSumOfConsecutive2(99), 5)