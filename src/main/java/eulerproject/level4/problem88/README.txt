A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers, {a1, a2, ... , ak}
is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.

For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.

For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number. The minimal
product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.

k=2: 4 = 2 × 2 = 2 + 2
k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6

Hence for 2≤k≤6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.

In fact, as the complete set of minimal product-sum numbers for 2≤k≤12 is {4, 6, 8, 12, 15, 16}, the sum is 61.

What is the sum of all the minimal product-sum numbers for 2≤k≤12000?

-----
General idea:
1) Generate bounded composition of sum with limits <1...N/2> in lexographic order (first small)
2) check the product after
3) if equal - result is found


----- Reading
Algorithm of generating bounded compositions is well described here: https://arxiv.org/abs/1302.6558
http://www.mathworks.com/matlabcentral/fileexchange/44186-restricted-integer-compositions-with-fixed-number-of-parts?focused=3801971&tab=function
-----


https://en.wikipedia.org/wiki/Partition_(number_theory)
http://mathworld.wolfram.com/Partition.html

-----
https://www.math.upenn.edu/~wilf/website/CombinatorialAlgorithms.pdf