function r = isIdentityMatrix(matrix)
	r = true;
	for i = 1:length(matrix)
		if matrix{i}(i) ~= 1 || any(matrix{i}([1:i-1 i+1:end]) ~= 0)
			r = false;
			return;
		endif
	endfor
endfunction
%!assert(isIdentityMatrix({[1,0,0], [0,1,0], [0,0,1]}), true)
%!assert(isIdentityMatrix({[1,0,0], [0,0,0], [0,0,1]}), false)
%!assert(isIdentityMatrix({[1,1,0], [0,1,0], [0,0,1]}), false)
%!assert(isIdentityMatrix({[1,0], [0,1]}), true)
%!assert(isIdentityMatrix({[0,0,0], [0,1,0], [0,0,1]}), false)
%!assert(isIdentityMatrix({[1,0,0], [0,5,0], [0,0,1]}), false)
%!assert(isIdentityMatrix({[1,0,0,0], [0,5,0,0], [0,0,0,0], [0,0,0,5]}), false)
%!assert(isIdentityMatrix({[0,0,0], [0,5,0], [0,0,0]}), false)
%!assert(isIdentityMatrix({[0,0,1], [0,1,0], [1,0,0]}), false)
%!assert(isIdentityMatrix({[0,1,1], [1,0,1], [1,1,0]}), false)