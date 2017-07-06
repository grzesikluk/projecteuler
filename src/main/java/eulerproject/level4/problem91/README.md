### Problem 96.

The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and are joined to the origin, O(0,0), to form ΔOPQ.
                 
![](https://projecteuler.net/project/images/p091_1.gif)

Picture 1


There are exactly fourteen triangles containing a right angle that can be formed when each co-ordinate lies between 0 and 2 inclusive; that is,
0 ≤ x1, y1, x2, y2 ≤ 2.


![](https://projecteuler.net/project/images/p091_2.gif)

Picture 2.

Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?

[Problem link](https://projecteuler.net/problem=91)


### Solution

#### Ideas

1. First idea is to point by point - 50 x 50 = 2500 generate equation for line that is perpendicular
to OQ and for this equation find all points that satisfy this equation and are integer points.

> L1: y = a1*x + b1

> line perpendicular is:
> L2: y = a2*x + b2
> where a2 = - 1/a1
> b2 can be found when placing point O.

For L2 find all P points lying on it - satisfying L2 equation.
 
This we will find all basic figures starting in (0,0) point and having right angle right-bottom 
for this triange. This triangle T1 can be then transformed by X and Y mirroring producing another
two.

You can see this in picture 2 above. Counting triangles from left to right top down - 
Triangle T2 - second left top is transformed this way to produce T1 and T10. Note that not 
all triangles can be achieved this way. For example T6 cannot be transformed. 

The condition is that after this transformation:
* one vertex must remain (0,0)
* triangle is not equal to itself.

Operations to achieve this:
* mirroring X,
* mirroring Y,
* rotation,
* mirroring XY - line y=x

Eg - T10 can be transformed by X mirroring producing itself, but Y mirroring will produce wrong triangle.

2. Generate pythagorian triples (already implemented) and find which coordinates meet it.
 
##### Data structures

##### Algorithm

###### Intro

#####Todo/Bugs
