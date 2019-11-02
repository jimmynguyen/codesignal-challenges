function r = alternatingSums(a)
	r = [sum(a(1:2:end)) sum(a(2:2:end))];
endfunction
%!assert(alternatingSums([50, 60, 60, 45, 70]), [180, 105])
%!assert(alternatingSums([100, 50]), [100, 50])
%!assert(alternatingSums([80]), [80, 0])
%!assert(alternatingSums([100, 50, 50, 100]), [150, 150])
%!assert(alternatingSums([100, 51, 50, 100]), [150, 151])