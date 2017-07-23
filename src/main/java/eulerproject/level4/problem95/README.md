### Problem 95

The proper divisors of a number are all the divisors excluding the number itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.

Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220, forming a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.

Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:

12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)

Since this chain returns to its starting point, it is called an amicable chain.

Find the smallest member of the longest amicable chain with no element exceeding one million.


### Solution

##### Ideas
Searching for chains  Sum of proper divisors - SPD:
* create search map with all values 1 - MAX
* pick number to start i,
* get SPD for i, 
* go to next number i equal SPD
* if chain is formed, add it to chain repo, and remove from search map, if chain ends with no
further number (because it was removed) remove values from map
* if no further numbers to process end
* return longest chain
    
##### Problems
Seems calculating SPD is very time consuming, for 100k it takes some minutes but for 1M it is very long. 
For all values we must calculate to be sure we checked all chains possibilities. This will make this
very long to calculate.

Imagine that checking chain from value k1 -> .... -> kx -> ky -> kz -> ... (-> ky->). We must remove leading k1 to kx
and rearrange the chain.


### Todo:
* figure out optimising of SPD calculation
* implement chaining **done**

### Links
[How to optimise hint](https://math.stackexchange.com/questions/22721/is-there-a-formula-to-calculate-the-sum-of-all-proper-divisors-of-a-number)