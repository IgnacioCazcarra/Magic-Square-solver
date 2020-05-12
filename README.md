# Magic-Square-solver
This project solves NxN magic squares using backtracking algorithm.
Keep in mind that if you try a NxN matrix with N>=5 it will take a while. Sometimes it seems to overflow due to the amount of iterations the backtracking algorithm does, so i recommend giving at least 2/3 of the numbers for a matrix with N>=5.


##IMPORTANT:
-If you set an impossible initial matrix as in the example below, the result wont show at all.
Example of an impossible answer:

```
2 9 6,
1 0 0,
0 0 8
```
A matrix with a negative number is considered impossible as well.
 
-If you leave an empty matrix such as: 
```
0 0 0,
0 0 0,
0 0 0
```
the function will return all posible solutions


