function list = listWithoutLoop (n)
    set(0,'RecursionLimit', 150000);
    if n <= 0
        list = n;
    else
        list = [n, listWithoutLoop(n-5), n];
    end
