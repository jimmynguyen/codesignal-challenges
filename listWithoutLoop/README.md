# listWithoutLoop

## Challenge Description

You are given n, return an array ans, composed in such way:
`ans = [n, n - 5, n - 10, ... , m, m + 5, ... , n - 5, n]`, where `m` stands for the first non-positive integer obtained by subtractions.
Try to solve it without any loop.

**Example**
For `n = 25`, the output should be
`listWithoutLoop(n) = [25, 20, 15, 10, 5, 0, 5, 10, 15, 20, 25]`.

**Input/Output**

* **[time limit] 3000ms (java)**
* **[input] integer n**

  *Guaranteed constraints:*
  <code>0 ≤ n ≤ 10<sup>5</sup></code>.

* **[output] array.integer**

## Solution Strategy

Use recursion...

## Solution

### Relevant files

* [listWithoutLoop.m](https://github.com/jimmynguyen/codefights/blob/master/listWithoutLoop/listWithoutLoop.m)

### Example

```matlab
list = listWithoutLoop(25);

% list -> [25, 20, 15, 10, 5, 0, 5, 10, 15, 20, 25]
```

