
### Problem 88

#### Description
Let S(A) represent the sum of elements in set A of size n. We shall call it a special sum set if for any two non-empty disjoint subsets, B and C, the following properties are true:

* S(B) ≠ S(C); that is, sums of subsets cannot be equal.
* If B contains more elements than C then S(B) > S(C).

If S(A) is minimised for a given n, we shall call it an optimum special sum set. The first five optimum special sum sets are given below.

```aidl
n = 1: {1}
n = 2: {1, 2}
n = 3: {2, 3, 4}
n = 4: {3, 5, 6, 7}
n = 5: {6, 9, 11, 12, 13}

```

It seems that for a given optimum set, A = {a1, a2, ... , an}, the next optimum set is of the form B = {b, a1+b, a2+b, ... ,an+b}, 
where b is the "middle" element on the previous row.

By applying this "rule" we would expect the optimum set for n = 6 to be A = {11, 17, 20, 22, 23, 24}, with S(A) = 117. 
However, this is not the optimum set, as we have merely applied an algorithm to provide a near optimum set. 
The optimum set for n = 6 is A = {11, 18, 19, 20, 22, 25}, with S(A) = 115 and corresponding set string: 111819202225.

Given that A is an optimum special sum set for n = 7, find its set string.

NOTE: This problem is related to Problem 105 and Problem 106.

#### Solution

##### Ideas
Generation of all sets of n elements set is 2^n - 1. 

Algo is generating for m elements optimal set from range (n - 1, 5*n): 
* 2^(4*n - 1) 
* for all above sets it generates 2^n - 1 sets

so for n=6:  2^24 * (2^6 - 1) =~ 2^30 = 4'398'046'511'104 ~ 42s
so for n=7:  2^28 * (2^7 - 1) =~ 2^35 = 34'359'738'368 

#### Idea #1
We will proceed with generating the optimal sets like this:
* from optimal set for n-1 generate middle element, or elements
* from middle elements generate next potential lists candidates for n length
* from previous set - generate product of sets by addingn to each element range of +-3 


##### Algorithm


##### Links


[Problem 103](https://projecteuler.net/problem=103)
Created by lgrzesik 01/08/17



