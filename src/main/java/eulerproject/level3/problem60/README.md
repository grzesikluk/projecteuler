
### Problem 60

#### Description
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the
result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes,
792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

#### Solution
For now the algo finds quickly 4 concatenated primes.

##### Ideas
Questions:
* how to estimate maximum prime number from two concatenated primes?
* do we need primes in BigInteger or long is enough?
* how to find sets? start with sets of two primes, and from this set search for further subsets?

Some ideas:
* do not need to generate big concatenated primes, it is enough to evaluate if this is prime.
* starting with sets of doublets might simplify things
* can we ommit string operations when concatenating - just using normal values?
* Integer.MAX_VALUE =  2147483647 or even Long.MAX_VALUE =  9223372036854775807 - is this enought to handle 2 
concatenated primes?

How to search chains - hints:
* first set limit and if Pk * N is greater the search can be finished, because this will
be no minimal sum of S,

##### Algorithm - search N concatenated primes set
The algo needs to search recursively through primes. For example if having prime which is
Pk-1 and found Pk - we shall search for further Pk' values that follow this condition. For
each such found - create set and do the same. This needs recursion and collecting of all
those to some structure.

##### Links
Created by lgrzesik 27/07/17