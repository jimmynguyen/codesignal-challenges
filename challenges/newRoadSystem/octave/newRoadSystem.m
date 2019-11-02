function isValid = newRoadSystem(roadRegister)
	isValid = true;
	n = length(roadRegister);
	roadRegister = reshape(cell2mat(roadRegister), n, n);
	for i = 1:n
		if sum(roadRegister(i, :)) ~= sum(roadRegister(:, i))
			isValid = false;
			return;
		endif
	endfor
endfunction
%!assert(newRoadSystem({[false,true,false,false], [false,false,true,false], [true,false,false,true], [false,false,true,false]}), true)
%!assert(newRoadSystem({[false,true,false,false,false,false,false], [true,false,false,false,false,false,false], [false,false,false,true,false,false,false], [false,false,true,false,false,false,false], [false,false,false,false,false,false,true], [false,false,false,false,true,false,false], [false,false,false,false,false,true,false]}), true)
%!assert(newRoadSystem({[false,true,false], [false,false,false], [true,false,false]}), false)
%!assert(newRoadSystem({[false,false,false,false], [false,false,false,false], [false,false,false,false], [false,false,false,false]}), true)
%!assert(newRoadSystem({[false]}), true)
%!assert(newRoadSystem({[false,true,true,true,false], [true,false,true,true,true], [true,true,false,true,false], [true,true,true,false,true], [true,true,true,true,false]}), false)
%!assert(newRoadSystem({[false,true,true,true,true], [true,false,true,true,true], [true,true,false,true,true], [true,true,true,false,true], [true,true,true,true,false]}), true)
%!assert(newRoadSystem({[false,true,false,true,true], [false,false,false,false,true], [true,false,false,true,true], [true,true,true,false,false], [true,true,true,false,false]}), false)
%!assert(newRoadSystem({[false,true,true,false,true], [true,false,false,true,false], [false,true,false,true,false], [true,true,true,false,true], [true,true,false,false,false]}), false)
%!assert(newRoadSystem({[false,true,false,true,true], [true,false,true,true,true], [false,false,false,false,true], [false,false,true,false,true], [true,false,true,true,false]}), false)
%!assert(newRoadSystem({[false,false,false,false,true,true,false,true,false,true], [false,false,true,false,false,false,true,false,false,true], [false,false,false,true,false,false,false,true,false,true], [false,true,false,false,true,false,false,true,false,false], [false,true,false,true,false,false,false,true,false,false], [true,true,true,true,true,false,true,false,true,true], [false,false,true,true,true,true,false,false,false,true], [true,true,true,false,false,false,false,false,false,false], [false,false,false,true,false,true,true,true,false,false], [false,true,true,true,true,false,true,false,true,false]}), false)
%!assert(newRoadSystem({[false,false,false,false,true,true,true,true,true,true,false,true,true,true], [true,false,true,true,false,true,true,true,true,false,false,true,false,false], [false,false,false,true,false,false,true,true,false,true,false,true,true,false], [true,true,false,false,true,true,false,false,false,true,true,true,false,true], [false,true,true,true,false,true,true,true,false,false,true,false,true,false], [true,true,false,true,true,false,true,false,true,true,true,true,true,true], [true,false,true,true,false,true,false,false,false,false,true,true,true,true], [false,true,false,true,true,false,true,false,true,true,true,true,false,false], [true,true,false,false,false,true,true,true,false,false,true,true,true,true], [true,false,true,false,false,true,false,true,true,false,true,false,true,true], [true,true,true,true,true,true,false,true,true,true,false,true,false,false], [true,true,false,false,true,true,false,false,true,true,true,false,true,true], [true,true,false,false,true,true,true,true,true,false,true,false,false,false], [false,false,true,true,true,true,false,false,true,true,true,false,false,false]}), true)