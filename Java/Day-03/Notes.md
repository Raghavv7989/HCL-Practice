# Day 3: Java Stream Operations

## Intermediate operations

Intermediate operations return another stream. They are lazy and run when a terminal operation is called.

- **flatMap()**: Converts each element into a stream and combines the results into one stream.
- **limit(n)**: Keeps only the first n elements.
- **takeWhile(condition)**: Takes elements from the beginning while the condition remains true. Stops at the first element that fails.
- **dropWhile(condition)**: Skips elements from the beginning while the condition remains true. Keeps the remaining elements after the first failure.

## Program

See [OrderStreamOperations.java](OrderStreamOperations.java). It demonstrates these operations along with filtering, sorting, min, max, counting, summing, averaging, and grouping orders.

**Note:** The program sorts orders by amount before using takeWhile() and dropWhile(), so the amount condition is applied to an ascending sequence.
