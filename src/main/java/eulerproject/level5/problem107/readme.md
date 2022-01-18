
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
* read the file to data structure - G (graph)
* data representation - simple 2D matrix, symetric, can be simplified
* calculation of weight, can be simplified too
* verify if the graph is consistent (without orphans)
* convert to list of edges that can be sorted by weight
* calculation of cycles in created H (forest)

##### Algorithm
Elegant Kruskals algorithm is well described in link below.

##### Links
[problem](https://projecteuler.net/problem=107)
[Minimum spanning tree](https://en.wikipedia.org/wiki/Minimum_spanning_tree#:~:text=A%20minimum%20spanning%20tree%20(MST,minimum%20possible%20total%20edge%20weight.)
[Kruskal Dijkstra](https://math.dartmouth.edu/~nadia/math38/04_29_Kruskal_and_Dijkstra.pdf)

Created by lgrzesik 2022-01-18