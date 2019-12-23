function r = differentDigitsNumberSearch(a)
	a = arrayfun(@num2str, a, 'UniformOutput', false);
	r = -1;
	for i = 1:length(a)
		found = true;
		for j = 1:length(a{i})/2+1
			if sum(a{i}(j) == a{i}) > 1
				found = false;
			endif
		endfor
		if found
			r = str2num(a{i});
			return;
		endif
	endfor
endfunction
%!assert(differentDigitsNumberSearch([22, 111, 101, 124, 33, 30]), 124)
%!assert(differentDigitsNumberSearch([1111, 404]), -1)
%!assert(differentDigitsNumberSearch([10, 11, 12, 13]), 10)