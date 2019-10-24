function res = splitAddress(address)
	[protocol, address] = strtok(address, ':');
	[domain, address] = strtok(address, '://.');
	[~, address] = strtok(address, '/');
	if length(address) <= 1
		res = {protocol, domain};
	else
		res = {protocol, domain, address(2:end)};
	endif
endfunction
%!assert(splitAddress("http://codesignal.com"), {"http", "codesignal"})
%!assert(splitAddress("http://stackoverflow.com/questions"), {"http", "stackoverflow", "questions"})