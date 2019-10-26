function output = higherVersion(ver1, ver2)
	ver1 = cellfun(@str2num, strsplit(ver1, '.'));
	ver2 = cellfun(@str2num, strsplit(ver2, '.'));
	output = false;
	for i = 1:length(ver1)
		if ver1(i) < ver2(i)
			return;
		elseif ver1(i) > ver2(i)
			output = true;
			return;
		endif
	endfor
endfunction
%!assert(higherVersion("1.2.2", "1.2.0"), true)
%!assert(higherVersion("1.0.5", "1.1.0"), false)
%!assert(higherVersion("1.1.0", "1.1.5"), false)
%!assert(higherVersion("10", "9"), true)
%!assert(higherVersion("1.0.10", "1.1.5"), false)
%!assert(higherVersion("5", "1"), true)
%!assert(higherVersion("1.1.10", "1.2.0"), false)
%!assert(higherVersion("1.2.2", "1.2.10"), false)
%!assert(higherVersion("1.10.2", "1.2.10"), true)
%!assert(higherVersion("0", "0"), false)
%!assert(higherVersion("4.3.22.1", "4.3.22.1"), false)