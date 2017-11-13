function d = solarSystemBallistics (body, a, v)
    t = 2*v*sind(a)/getG(body);
    d = abs(v*cosd(a)*t);

function G = getG(body)
    switch body
        case 'Sun'
            G = 274;
        case 'Mercury'
            G = 3.7;
        case 'Venus'
            G = 8.87;
        case 'Earth'
            G = 9.807;
        case 'Mars'
            G = 3.711;
        case 'Jupiter'
            G = 24.79;
        case 'Saturn'
            G = 10.44;
        case 'Uranus'
            G = 8.69;
        case 'Neptune'
            G = 11.15;
        case 'Moon'
            G = 1.62;
        case 'Pluto'
            G = 0.62;
        case 'Ganymede'
            G = 1.428;
        case 'Callisto'
            G = 1.235;
        case 'Io'
            G = 1.796;
        case 'Europa'
            G = 1.314;
        case 'Titan'
            G = 1.352;
    end
