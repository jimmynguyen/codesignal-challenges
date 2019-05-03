function maxSum = maxSubmatrixSum(matrix, n, m)
	maxSum = -inf;
	N = size(matrix, 2);
	M = size(matrix{1}, 2);
	matrix = reshape(cell2mat(matrix), [M, N])';
	for r = 1:N-n+1
		for c = 1:M-m+1
			submatrix = matrix(r:r+n-1, c:c+m-1);
			currentSum = sum(sum(submatrix));
			if currentSum > maxSum
				maxSum = currentSum;
			endif
		endfor
	endfor
endfunction
%!assert(maxSubmatrixSum({[1,12,11,10], [4,3,2,9], [5,6,7,8]}, 2, 1), 19)
%!assert(maxSubmatrixSum({[1,2,-1], [-4,-8,3]}, 2, 2), -4)
%!assert(maxSubmatrixSum({[0,-1]}, 1, 1), 0)
%!assert(maxSubmatrixSum({[1,2,1,3], [1,1,1,1], [2,2,2,2]}, 3, 2), 10)
%!assert(maxSubmatrixSum({[1,-1], [0,0], [2,-1], [3,-10]}, 1, 2), 1)