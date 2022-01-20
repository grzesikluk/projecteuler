
### Problem 108

#### Description
The following undirected network consists of seven vertices and twelve edges with a total weight of 243.


The same network can be represented by the matrix below.

>     	    A	B	C	D	E	F	G
>       A	-	16	12	21	-	-	-
>       B	16	-	-	17	20	-	-
>       C	12	-	-	28	-	31	-
>       D	21	17	28	-	18	19	23
>       E	-	20	-	18	-	-	11
>       F	-	-	31	19	-	-	27
>       G	-	-	-	23	11	27	-
However, it is possible to optimise the network by removing some edges and still ensure that all points on the network remain connected. The network which achieves the maximum saving is shown below. It has a weight of 93, representing a saving of 243 − 93 = 150 from the original network.
Using network.txt (right click and 'Save Link/Target As...'), a 6K text file containing a network with forty vertices, and given in matrix form, find the maximum saving which can be achieved by removing redundant edges whilst ensuring that the network remains connected.
#### Solution

##### Ideas
TODO:
The sorted list of edges proves there are edges with same weight and that means they might be processed in many orders.
The number of possible solutions is total number of permutations of edges with same weight.
* find the weights and do permutations of all orders

Example = let's say there is edges list with w0..wn. There are w1, w2 for which there are many edges:
(a,b), w1; (c,d), w1
(b,e), w2; (f,k), w2, (n,p), w2
We need to generate 2! * 3! edges list from that, containing different orders of same weight edges.






##### Algorithm
Elegant Kruskals algorithm is well described in link below.

##### Links
[problem](https://projecteuler.net/problem=107)

[Kruskal Dijkstra](https://math.dartmouth.edu/~nadia/math38/04_29_Kruskal_and_Dijkstra.pdf)

[Detect cycles](https://www.geeksforgeeks.org/detect-cycle-undirected-graph/)

[Detect cycles algo](https://en.wikipedia.org/wiki/Cycle_(graph_theory)#:~:text=real%20numbers%2C%20etc.-,Cycle%20detection,over%20are%20part%20of%20cycles.)

Created by lgrzesik 2022-01-18