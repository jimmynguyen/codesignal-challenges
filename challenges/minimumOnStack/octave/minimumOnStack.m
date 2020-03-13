function output = minimumOnStack(operations)
    stack = [];
    output = [];
    for i = 1:length(operations)
        operation = operations{i};
        if strcmp(operation, 'min')
            output(end+1) = min(stack);
        elseif strcmp(operation, 'pop')
            stack(end) = [];
        else
            [~, num] = strtok(operation, ' ');
            stack(end+1) = str2num(num(num ~= ' '));
        endif
    endfor
endfunction
%!assert(minimumOnStack({"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"}), [10, 5, 5, 5, 10])
%!assert(minimumOnStack({"push 10", "min", "pop", "push 3", "min", "push 5", "pop", "push 3", "min", "pop"}), [10, 3, 3])
%!assert(minimumOnStack({"push 10"}), [])
%!assert(minimumOnStack({"push 10", "pop"}), [])