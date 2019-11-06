## Question
Given a number as a binary string  
* If even divided by 2 
* If odd subtract 1
Return how many times you subtracted or divided to reach 0.

## Solution Discussion 
* Returns the number of operations after a single pass.  
* A '0' is counted as a division or a shift right operation.
* A '1' is both a subtraction and then a division and is recorded as two operations.
* The algo loops to the the first occurrence of a '1', ignoring the leading '0'.
* The first '1' is only counted as a single subtraction operation as it is in the right most position after shifting. 
  
