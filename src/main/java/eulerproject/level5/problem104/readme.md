
### Problem 104

#### Description
The Fibonacci sequence is defined by the recurrence relation:

>Fn = Fn−1 + Fn−2, 
> where F1 = 1 and F2 = 1.

It turns out that F541, which contains 113 digits, is the first Fibonacci number for which the last nine digits are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F2749, which contains 575 digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.

Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.
#### Solution

##### Ideas
* The numbers for Fibonacci can be generated using iterative way. Since the numbers are enormous
we can get last 9 numbers using modulo generator. From that we can obtain k for all pandigit Fibonacci
values. 
* for all k we should generate full Fibonacci values using eg. Lucas sequence (or other way of getting those, might be 
not exact - because we need the first 9 digits)
* find the subset of aforementioned values - and the k for double-pandigit Fibonacci.

##### Links
[VTL reference](http://velocity.apache.org/engine/1.7/vtl-reference.html)

[Sequence of Fibonacci numbers with pandigital 1-9 first numbers](https://oeis.org/A112516)
[Sequence of Fibonacci numbers with pandigital 1-9 last numbers](https://oeis.org/A112371)
[Algorithms implementations](https://en.wikibooks.org/wiki/Algorithm_Implementation)

Created by lgrzesik 2018-12-31