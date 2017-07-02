### Problem 96.

Su Doku (Japanese meaning number place) is the name given to a popular puzzle concept. Its origin is unclear, but credit must be attributed to Leonhard Euler who invented a similar, and much more difficult, puzzle idea called Latin Squares. The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in such that each row, column, and 3 by 3 box contains each of the digits 1 to 9. Below is an example of a typical starting puzzle grid and its solution grid.

A well constructed Su Doku puzzle has a unique solution and can be solved by logic, although it may be necessary to employ "guess and test" methods in order to eliminate options (there is much contested opinion over this). The complexity of the search determines the difficulty of the puzzle; the example above is considered easy because it can be solved by straight forward direct deduction.

The 6K text file, sudoku.txt (right click and 'Save Link/Target As...'), contains fifty different Su Doku puzzles ranging in difficulty, but all with unique solutions (the first puzzle in the file is the example above).

By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid; for example, 483 is the 3-digit number found in the top left corner of the solution grid above.

[Problem link](https://projecteuler.net/problem=96)


### Solution

#### Ideas
 
##### Todo:
* reading of matrix from file (**DONE**)
* creating structures   (**DONE**)      
* solving
* accumulating result
 
##### Data structures
Matrix that allows easily to do following actions:
* check zeros in row/cols/squares  (**DONE**)
* find set of missing numbers for row/column/square  (**DONE**)
* access and address squares  (**DONE**)
* return number that is the most numberous (**DONE**)

##### Algorithm

###### Intro
The algo should try to find some starting point. Propose:
* The col/row/square with many numbers in it,
* The number that occurs many times 
* algo will be iterative/recursive with unknown numbers of run, 

###### Algorithm "naive" - first approach    
1. pick next "zero" location
1a. if end of table - go to first zero location otherwise goto #5
2. for this location pick set of possible values basing on column/row/square
3. if set of missing values for this position is 1 element, place this value
4. go to 1
5. END - solved


#####Todo
The algo is not working properly. For some matrixes it is stuck with no 1 element missing
array.