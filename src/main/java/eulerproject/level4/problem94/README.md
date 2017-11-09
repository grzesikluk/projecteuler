
### Problem 94 Almost equilateral triangles

#### Description
It is easily proved that no equilateral triangle exists with integral length sides and integral area. However, the almost equilateral triangle 5-5-6 has an area of 12 square units.

We shall define an almost equilateral triangle to be a triangle for which two sides are equal and the third differs by no more than one unit.

Find the sum of the perimeters of all almost equilateral triangles with integral side lengths and area and whose perimeters do not exceed one billion (1,000,000,000).

#### Solution

##### Ideas
* say triangle is size of {X,X,X-1} or {X, X, X+1}
    * perimeter is P=3X-1 or P=3X+1
    * area is from Herons formula: s = P/2, A= sqrt(s(s-a)(s-b)(s-c))
    * say we have A^2 to not calculate sqrt function 
        - if it is sqare number then we found triangle with integral area (and integral lengths)
* if perimeter should be smaller that one billion the A maximum is ca one third of billion
    * is this too much to use above ideas?
* if perimeter is ca 10^9 then what is the area size? - 10^16?
* the probable issue is the length of integers, area is very very big!


##### Algorithm
* generate all square numbers to compare
* from X=2 up to one billion/3 check
    * calculate s, A^2 and 
        * check if A^2 is square number
    * if yes add P to some accumulated value

##### Links
[Equilateral triangle wiki](https://en.wikipedia.org/wiki/Equilateral_triangle)
[Herons formula](https://www.mathsisfun.com/geometry/herons-formula.html)

Created by lgrzesik 20/09/2017