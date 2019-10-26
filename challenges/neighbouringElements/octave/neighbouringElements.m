function r = neighbouringElements(a)
	r=0;
	m=length(a);
	n=length(a{1});
	for i=1:m
		for j=1:n
			if i<m && a{i}(j)==a{i+1}(j)
				r=r+1;
			endif
			if j<n && a{i}(j)==a{i}(j+1)
				r=r+1;
			endif
		endfor
	endfor
endfunction
%!assert(neighbouringElements({[1,1,1], [1,1,1], [1,1,1]}), 12)
%!assert(neighbouringElements({[0,1,2,3], [1,2,3,0], [2,3,1,0]}), 1)