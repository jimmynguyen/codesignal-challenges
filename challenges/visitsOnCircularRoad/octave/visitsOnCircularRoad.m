function t = visitsOnCircularRoad(n, visitsOrder)
	t = 0;
	currentLocation = 1;
	for i = 1:length(visitsOrder)
		if visitsOrder(i) > currentLocation
			t = t + min(visitsOrder(i)-currentLocation, n-visitsOrder(i)+currentLocation);
		else
			t = t + min(currentLocation-visitsOrder(i), n-currentLocation+visitsOrder(i));
		endif
		currentLocation = visitsOrder(i);
	endfor
endfunction
%!assert(visitsOnCircularRoad(4, [1, 3, 2, 3, 1]), 6)
%!assert(visitsOnCircularRoad(3, [3]), 1)