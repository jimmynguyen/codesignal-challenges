# reverseComplement

Link to Challenge: [https://app.codesignal.com/challenge/revx6ws9h53DS9KFF](https://app.codesignal.com/challenge/revx6ws9h53DS9KFF)

## Challenge Description

DNA is a double stranded molecule that is composed four repeating building blocks (a.k.a. bases). These are commonly denoted by the first letter for their chemical names (`A`, `T`, `C` and `G`). DNA is also a double stranded molecule that looks, for example, like this:
`strand A :: AAATTTGGGCCC`,
`strand B :: TTTAAACCCGGG`.

The complete molecule can be regenerated if only one "strand" is known. The process of obtaining the other strand is called complementation. `B` is complement to `A` and `A` is complement to `B`.

The pairing patterns are: `A` - `T` and `C` - `G`.
The base `N` denotes and unknown value and complements to `N`.
`S` denotes an ambiguous strong base. `G` and `C` are strong bases.
`W` denotes an ambiguous weak base. `A` and `T` are weak bases.

Given a strand, return the complement.

**Example**

For `strand = "AAA"`, the output should be
`reverseComplement(strand) = "TTT"`.

**Input/Output**

* **[time limit] 3000ms (java)**
* **[input] string strand**

  A DNA strand.

  *Guaranteed constraints:*
  `1 ≤ strand.length < 4000`.

* **[output] string**

  A DNA strand.

## Solution Strategy

Flip the strand. For each base, replace all instances with its complement base.

## Solution

### Relevant files

* [reverseComplement.m](https://github.com/jimmynguyen/codefights/blob/master/reverseComplement/reverseComplement.m)

### Example

```matlab
reverseComplementStrand = reverseComplement('AAA');

% reverseComplementStrand -> 'TTT'
```
