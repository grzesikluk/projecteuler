
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

##### Algorithm
*

##### Links
Created by lgrzesik 27/07/17