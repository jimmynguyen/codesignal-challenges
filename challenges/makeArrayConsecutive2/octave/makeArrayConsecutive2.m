function res = makeArrayConsecutive2 (statues)
    res = length(min(statues):max(statues)) - length(statues);
endfunction
%!assert(makeArrayConsecutive2([6, 2, 3, 8]), 3)
%!assert(makeArrayConsecutive2([0, 3]), 2)
%!assert(makeArrayConsecutive2([5, 4, 6]), 0)
%!assert(makeArrayConsecutive2([6, 3]), 2)
%!assert(makeArrayConsecutive2([1]), 0)