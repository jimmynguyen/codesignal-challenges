# cubeWorld

## Challenge Description

Your task is to find the volume of the structure created by the provided cubes.

Each cube is given in the format `[x, y, z, r]` and represents a cube with a corner at coordinate `(x, y, z)` which extends `r` units in the `+x`, `+y` and `+z` directions. For example `[1, 2, 3, 5]` is a cube with one corner at `(1, 2, 3)` and the opposing corner at `(6, 7, 8)` and a volume of <code>125 units<sup>3</sup></code>.

To make things a bit more complicated, the cubes might not all form a single structure. If this is the case return the volume of the **largest structure**.

Two cubes connect to form a single structure if they **overlap in space**. If they just share a surface but don't overlap they are not considered connected.
A structure is a collection of cubes which form a connected body - that is that each cube in the structure can be reached from any other cube in the structure through a series of connected neighbors (e.g. if `A` connects to `B` and `B` connects to `C` then `A + B + C` is a single structure.)

**Space trapped between cubes does not count as part of a structure.**

Not connected

```
  ┌---------┐
  │         │
  │         │
  │         │
  │         │
┌-┴-------┬-┘
│         │
│         │
│         │
│         │
└---------┘
```

Connected

```
  ┌---------┐
  │         │
┌-┼-------┐ │
│ │       │ │
│ │       │ │
│ └-------┼-┘
│         │
└---------┘
```

**Example**  
For

```
cubes = [[0, 0, 0, 10],
         [100, 100, 100, 5],
         [5, 5, 5, 2],
         [9, 9, 9, 5]]
```

the output should be  
`cubeWorld(cubes) = 1124`.

Cube `[0, 0, 0, 10]` has a volume of `1000`, it completely envelopes cube `[5, 5, 5, 2]` so no additional volume is added. Cube `[9, 9, 9, 5]` overlaps with `[0, 0, 0, 10]` by sharing the `1 × 1 × 1` cube at coordinates `(9, 9, 9)` so they are connected and have a joint volume of `1124` (`1000 + 125 - 1`).  
Cube `[100, 100, 100, 5]` does not overlap any other cube and only has a volume of `125`.

**Input/Output**

* **[time limit] 3000ms (java)**
* **[input] array.array.integer cubes**

  *Guaranteed constraints:*  
  `0 ≤ cubes.length ≤ 1000`  
  `0 ≤ x, y, z, x + r, y + r, z + r < 1000`,  
  `1 ≤ r ≤ 50`,  
  <code>Σr<sup>3</sup> < 10<sup>6</sup></code>.

* **[output] integer**

  Volume of the largest structure created by the cubes.

## Solution Strategy

1. Loop through all cubes
2. Break all cubes into cubes of size `1 × 1 × 1`, where a cube with coordinate `(x, y, z)` represents the cube described by the two points `(x, y, z)` and `(x+1, y+1, z+1)`
3. Create structures of connected cubes
    * Two cubes are considered connected if they share a `1 × 1 × 1` cube with the same coordinate
4. Find the structure with the largest volume (i.e. the most number of `1 × 1 × 1` cubes)

## Solution

### Relevant files

* [CubeWorld.java](https://github.com/jimmynguyen/codefights/blob/master/cubeWorld/src/main/java/CubeWorld.java)
* [Cube.java](https://github.com/jimmynguyen/codefights/blob/master/cubeWorld/src/main/java/Cube.java)
* [Structure.java](https://github.com/jimmynguyen/codefights/blob/master/cubeWorld/src/main/java/Structure.java)

### Example

```java
int[][] cubes = new int[][] {
    {  0,   0,   0, 10},
    {100, 100, 100,  5},
    {  5,   5,   5,  2},
    {  9,   9,   9,  5}
};

int largestStructureVolume = CubeWorld.getLargestStructureVolume(cubes);

// largestStructureVolume -> 1124
```
