# commonCharacterCount

Link to Challenge: [https://app.codesignal.com/challenge/EmRRenvtbS4x5i2ud](https://app.codesignal.com/challenge/EmRRenvtbS4x5i2ud)
Link to Challenge: [https://app.codesignal.com/arcade/intro/level-3/JKKuHJknZNj4YGL32](https://app.codesignal.com/arcade/intro/level-3/JKKuHJknZNj4YGL32)

## Challenge Description

Given two strings, find the number of common characters between them.

**Example**

For `s1 = "aabcc"` and `s2 = "adcaa"`, the output should be
`commonCharacterCount(s1, s2) = 3`.

Strings have `3` common characters - `2` "a"s and `1` "c".

**Input/Output**

* **[execution time limit] 3 seconds (java)**
* **[input] string s1**

  A string consisting of lowercase English letters.

  *Guaranteed constraints:*

  `1 ≤ s1.length < 15`.
* **[input] string s2**

  A string consisting of lowercase English letters.

  *Guaranteed constraints:*

  `1 ≤ s2.length < 15`.
* **[output] integer**

## Solution Strategy

1. Loop through each character `c` in first input string
2. Remove `c` from second input string
3. Number of common characters will be the difference between the start and final lengths of the second input string

## Solution

### Relevant files

* [CommonCharacterCount.java](https://github.com/jimmynguyen/codefights/blob/master/commonCharacterCount/CommonCharacterCount.java)

### Example

```java
int count = CommonCharacterCount.countCommonCharacters("aabcc", "adcaa");

% count -> 3
```
