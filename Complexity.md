Big-O notation is a way of analyzing the amount of time it takes for algorithms to execute, as the input size grows.

Typically, we can expect that as the input size grows, the execution time will also grow. The different Big O complexities tell us how these execution times grow, e.g. linearly, quadratically etc.

To download the high resolution images, please see the link below (no email necessary).


1. O(1) - Constant Time
   Runtime remains constant regardless of the size of the input.

- Pushing and popping from the end of an array
- Array lookups, given an index
- Hashmap insertions, lookups and removals


2. O(√ n) - Square Root Time
   Runtime of the algorithm grows at a rate proportional to the square root of the input size.

- Sieve of Eratosthenes
- Getting all factors of a number


3. O(log n) - Logarithmic Time
   Runtime of the algorithm grows logarithmically as the input size increases.

- Binary Search on a BST
- Binary Search on a sorted array
- Heap Push and Pop


4. O(n) - Linear Time
   Runtime of the algorithm grows linearly to the size of the input.

- Looping through an array
- Building a heap


5. O(n log n) - Linearithmic Time
   Runtime of the algorithm combines linear and logarithmic growth.

- MergeSort
- HeapSort


6. O(n*m) - Bilinear Time
   Runtime of the algorithm grows proportionally to n and m's product.

- Traversing a rectangle grid
- Get every pair of elements from two arrays


7. O(n^2) - Quadratic Time
   Runtime of the algorithm grows quadratically with the size of the input.

- Insertion Sort
- Traversing a square grid
- Get every pair of elements in an array


8. O(2^n) - Exponential Time
   Runtime of the algorithm doubles with each additional input element.

- Fibonacci Sequence
- Two branch recursion


9. O(n!) - Factorial Time

Runtime of the algorithm grows factorially to the size of the input
- Permutations
- Travelling Salesman Problem (TSP)