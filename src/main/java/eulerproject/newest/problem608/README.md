### Problem 608
Trying to get the [One in a hundred](https://projecteuler.net/award=41) aware!

#### Description

Let D(m,n)=∑d|m∑k=1nσ0(kd)D(m,n)=∑d|m∑k=1nσ0(kd) where dd runs through all divisors of mm and σ0(n)σ0(n) is the number of divisors of nn.

You are given D(3!,102)=3398D(3!,102)=3398 and D(4!,106)=268882292D(4!,106)=268882292.

Find D(200!,10^12) mod (10^9+7)

#### Solution

##### Ideas
* Sum of divisors has this property: σ(a*b)=σ(a)*σ(b)
* by this sums can be counted separately for σ(d|m) multiplied by σ(k)
* finding of prime factorization for n! can be done by Legrandre's Theorem - "The prime factorization of Factorials" **DONE**
* having prime-power factorization need 
    * find all divisors ????
    * sum of all divisors can be found in Mathworld (eq 14) - **DONE**

##### Algorithm
* 

##### Links
[Project Euler](https://projecteuler.net/problem=608)

[Forum](https://math.stackexchange.com/questions/982488/how-to-sum-the-divisors-of-n-mod-k-if-all-i-have-is-n-mod-k)

[Number Theory](http://www.math.cmu.edu/~mlavrov/arml/13-14/number-theory-09-29-13.pdf)

[Legendre's Theorem](http://www.cut-the-knot.org/blue/LegendresTheorem.shtml)

[Mathworld](http://mathworld.wolfram.com/DivisorFunction.html)

Created by lgrzesik 03/08/2017