# Magic-Square-solver
This project solves NxN magic squares using backtracking algorithm.
Keep in mind that if you try a NxN matrix with N>=5 it will take a while. Sometimes it seems to overflow due to the amount of iterations the backtracking algorithm does, so i recommend giving at least half of the numbers, especially for a matrix with N>=5.
You can change the matrix at Test class.

## IMPORTANT:
-If you set an impossible matrix as in the example below, the result wont differ from the input but it will go through all possible combinations.
Example of an impossible matrix:

```
2 9 6
1 0 0
0 0 8
```
A matrix with a negative number is considered an impossible matrix as well.
 
-If you leave an empty matrix such as: 
```
0 0 0
0 0 0
0 0 0
```
the function will return the first found solution.
