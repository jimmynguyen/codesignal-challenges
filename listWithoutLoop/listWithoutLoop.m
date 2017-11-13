function res = listWithoutLoop (n)
    set(0,'RecursionLimit', 150000);
    if n <= 0
        res = n;
    else
        res = [n, listWithoutLoop(n-5), n];
    end
