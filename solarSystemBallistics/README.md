# solarSystemBallistics

## Challenge Description

You are an engineer working for entrepreneur Elom Nusk (no relation) on the HyperWormHole-Loop project. The project will send a vehicle through a wormhole to another body in the solar system. There is a slight technical hiccup which causes vehicles on the far end to be ejected from the wormhole at high velocity.

To help make this project a reality you must calculate where to place the ACME™ air bag which will prevent passengers from dying in a fiery crash.

Determine the horizontal distance a car will travel given a stellar body, angle and velocity - ignoring curvature and atmospheric resistance (this is only engineering after all).

These are the stellar bodies used in the tests and their gravitational acceleration

| Body     | G [m/s<sup>2</sup>] |
| -------- | ------------------- |
| Sun      | 274.0               |
| Mercury  | 3.7                 |
| Venus    | 8.87                |
| Earth    | 9.807               |
| Mars     | 3.711               |
| Jupiter  | 24.79               |
| Saturn   | 10.44               |
| Uranus   | 8.69                |
| Neptune  | 11.15               |
| Moon     | 1.62                |
| Pluto    | 0.62                |
| Ganymede | 1.428               |
| Callisto | 1.235               |
| Io       | 1.796               |
| Europa   | 1.314               |
| Titan    | 1.352               |

**Example**

For `body = "Earth"`, `a = 20` and `v = 100`, the output should be
`solarSystemBallistics(body, a, v) = 655.43755`.
A body on planet Earth shot at a velocity of `100`m/s and an angle of `20` degrees will fall back to Earth at a distance of `655.43755`m.

**Input/Output**

* **[time limit] 3000ms (java)**
* **[input] string body**

  A stellar body from the given list.

* **[input] integer a**

  Angle in degrees.

  *Guaranteed constraints:*  
  `0 < a < 180`.

* **[input] integer v**

  Velocity in m/s.

  *Guaranteed constraints:*  
  `0 ≤ v ≤ 1000`.

* **[output] float**

  The distance a projectile will travel under the given conditions.

## Solution Strategy

1. Get gravitational acceleration for body
2. Compute time

   ![equation](http://latex.codecogs.com/gif.latex?t=\frac{2v\sin(\theta)}{G})

3. Compute displacement

   ![equation](https://latex.codecogs.com/gif.latex?d=v\cos(\theta)t)

## Solution

### Relevant files

* [solarSystemBallistics.m](https://github.com/jimmynguyen/codefights/blob/master/solarSystemBallistics/solarSystemBallistics.m)

### Example

```matlab
displacement = solarSystemBallistics('Earth', 20, 100);

% displacement -> 655.44
```
