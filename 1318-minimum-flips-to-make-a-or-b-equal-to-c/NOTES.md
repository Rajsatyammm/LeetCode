Suppose we have a = 5 (binary: 0101), b = 10 (binary: 1010), and c = 15 (binary: 1111).
​
In the first iteration:
​
bitA = a & 1 = 5 & 1 = 1
bitB = b & 1 = 10 & 1 = 0
bitC = c & 1 = 15 & 1 = 1
Since bitC is 1, we increment flips by 1.
​
In the second iteration:
​
a is right-shifted: a >>= 1 becomes a = 2 (binary: 0010)
b is right-shifted: b >>= 1 becomes b = 5 (binary: 0101)
c is right-shifted: c >>= 1 becomes c = 7 (binary: 0111)
In the second iteration:
​
bitA = a & 1 = 2 & 1 = 0
bitB = b & 1 = 5 & 1 = 1
bitC = c & 1 = 7 & 1 = 1
Since bitC is 1, we increment flips by 1.
​
In the third iteration:
​
a is right-shifted: a >>= 1 becomes a = 1 (binary: 0001)
b is right-shifted: b >>= 1 becomes b = 2 (binary: 0010)
c is right-shifted: c >>= 1 becomes c = 3 (binary: 0011)
In the third iteration:
​
bitA = a & 1 = 1 & 1 = 1
bitB = b & 1 = 2 & 1 = 0
bitC = c & 1 = 3 & 1 = 1
Since bitC is 1, we increment flips by 1.
​
In the fourth iteration:
​
a is right-shifted: a >>= 1 becomes a = 0 (binary: 0000)
b is right-shifted: b >>= 1 becomes b = 1 (binary: 0001)
c is right-shifted: c >>= 1 becomes c = 1 (binary: 0001)
In the fourth iteration:
​
bitA = a & 1 = 0 & 1 = 0
bitB = b & 1 = 1 & 1 = 1
bitC = c & 1 = 1 & 1 = 1
Since bitC is 1, we increment flips by 1.
​
After the iterations, flips will be equal to 3, which represents the minimum number of flips required to make (a | b) == c.
​
In this dry run, we can see that for each bit position, we increment flips by 1 when bitC is 1, indicating that a flip is required to match the bit of c. When bitC is 0, we increment flips by bitA + bitB, accounting for the flips needed to change the bits in a and b to 0 if they are currently 1.