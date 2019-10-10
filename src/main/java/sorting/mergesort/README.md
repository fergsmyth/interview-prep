## Merge sort
#### Time complexity
* O(n log n) : Loops through the entire input n, log n times
* Memory= O(n)
####Process
Divide and conquer approach to recursively to sort array.  
Mergesort approach initially passes the begin of the array to be sorted and the end of the array as the left and right indices.  
The function finds the mid way between them and then recursively calls itself passing, (left, mid) and (mid,right).  
This is done until the leaf nodes are reached in the recursive call.
As each call returns along the call chain, they sort the elements between their left and right index until the initial call is reached with a fully sorted array.  
#####Pros
* More suited to large lists, other algorithms are better for smaller tasks.
* Recursive calls can be parallelised.
* Supports stable sort.
#####Cons  
*Memory usage for sub lists.
  

