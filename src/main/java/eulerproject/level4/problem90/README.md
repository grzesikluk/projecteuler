
### Problem 90

#### Description
Each of the six faces on a cube has a different digit (0 to 9) written on it; the same is done to a second cube. 
By placing the two cubes side-by-side in different positions we can form a variety of 2-digit numbers.

For example, the square number 64 could be formed:

![Foo](https://projecteuler.net/project/images/p090.gif)


In fact, by carefully choosing the digits on both cubes it is possible to display all of the square numbers below 
one-hundred: 01, 04, 09, 16, 25, 36, 49, 64, and 81.

For example, one way this can be achieved is by placing {0, 5, 6, 7, 8, 9} on one cube and {1, 2, 3, 4, 8, 9} on the other cube.

However, for this problem we shall allow the 6 or 9 to be turned upside-down so that an arrangement like {0, 5, 6, 7, 8, 9} 
and {1, 2, 3, 4, 6, 7} allows for all nine square numbers to be displayed; otherwise it would be impossible to obtain 09.

In determining a distinct arrangement we are interested in the digits on each cube, not the order.

{1, 2, 3, 4, 5, 6} is equivalent to {3, 6, 4, 1, 2, 5}
{1, 2, 3, 4, 5, 6} is distinct from {1, 2, 3, 4, 5, 9}

But because we are allowing 6 and 9 to be reversed, the two distinct sets in the last example both represent the 
extended set {1, 2, 3, 4, 5, 6, 9} for the purpose of forming 2-digit numbers.

How many distinct arrangements of the two cubes allow for all of the square numbers to be displayed?

#### Solution

##### Ideas
* not all variants of cubes are needed, let's consider all square numbers 

> {01, 04, 09, 16, 25, 36, 49, 64, 81}

and count all digits:
> {0=3, 1=3, 2=1, 3=1, 4=3, 5=1, 6=3, 7=0, 8=1, 9=2}

but if `6` equals `9` when reversed:
> {0=3, 1=3, 2=1, 3=1, 4=3, 5=1, {6,9}=5, 7=0, 8=1}

so in this case it is possible that `0` digit will be on ff
* one cube
* two cubes

but `1`
* one cube

and `7`
* none cube

We can map this as follows:
> {0={1,2}, 1={1,2}, 2={1}, 3={1}, 4={1,2}, 5={1}, {6,9}={1,2}, 7={}, 8={1}}

let's name above - *digit map*.

##### Questions
* Q1: is cube order fixed so C1 must always be first and C2 second? Is it any order?
* A1: No. Any order is possible to construct square number. **DONE**
* Q2: must all cubes sides be filled?
* A2: If this is true some digit will be doubled (not on one cube). 
* Q3: must all cubes sides be unique?
* A3: Yes.
* Q4: is it possible to generate all variants of cubes?
* A4: ?
* Q5: is it possible to generate all valid solutions?
* A5: ?
* Q6: Is it possible to have comparison of cubes?
* A6: Yes. Easy sort of set, compare from smallest until found bigger. If different length no comparison? **DONE**
* Q7: Is it possible to have comparison of two unordered cubes T1 with other two unordered cubes T2?
* A7: Compare cubes of T1 and T2. There are variants: C1>C2, C1==C2, C1<C2 for one and other tuple. Order the cubes so that C1 is 
smallest, C2 is biggest. Compare C1T1 with C1T2. If C1T1 < C1T2 than T1 < T2. If C2T1 > C2T2 - T1 is greater. In case of
equality eg. C1T1==C2T2 - compare C2T1 with C2T2 and decide about the result. **DONE**
* Q8: See Q2. Must all sides be assigned?
* A8: Let's say we have cube set that generates squares properly. One of cubes has empty sides. We can assign any number 
not existing in it to satisfy the condition of non empty sides. This however will generate new set of solutions. It is 
required to do all variants to calculate all of them.
* Q9: How to count secondary solutions?

##### Algorithm
* seems like there is a possibility to create a *cubes tree* of C1 C2 by traversing *digit map*. 
* We traverse all numbers one by one and creating tree of possible variants.
    * if there are possible variants like 0={1,2} three branches will be created 
    > B1={C1={0}, C2={0}}, B2={C1={0}, C2={}}, B3={C1={}, C2={0}}   

    * Further those branches will be extended by the same rule by picking next digit from *digit map*
    * On the tree leaves there will be some cubes
    * probably after creating *cubes tree* the leaves must be unique by eliminating some leaves

* when counting possible solutions we have basic solution which can be taken and we estimate how many secondary solutions
can be created by picking any digits and assigining it to the other sides of cube.
* generation of secondary solutions must take into account the other existing solutions (basic and secondary), this can be done
by getting the number of solutions that my solution already contains eg. cube {1, 2, 3, 4} is containted in {1, 2, 3, 4, 5}

##### TODO
* the problem of containment should be solved, so we can reduce amount of solutions. If one cube contains soluton S1 from other S2 we
can ommit the sum of S2. In fact the containment of cubes is not containtment of digits.
Example 1
> s1={1,2,3} and has 7*6*5 variants = 210 
> and contains for example s2={4,5,6} - exactly one solution s3 = {1,2,3,4,5,6} which needs to be reduced from s1 (?)

Example 2
> c1={1,2,3} = 210 and c2={1} = 181440 and c1 must be substracted from c2


##### Links

Created by lgrzesik 23/11/2017