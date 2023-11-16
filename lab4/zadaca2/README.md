A sequence of numbers is considered a zigzag sequence if the numbers in the sequence are alternately positive and negative i.e. for every pair of consecutive numbers, one is positive and the other is negative.

For example, -1 2 -9 8 -4 is a zigzag sequence, but -1 9 7 -3 8 -3 is not, because 9 and 7 are adjacent numbers, but both are positive. A zigzag sequence can start with either a positive or a negative number. A sequence of only one non-zero number is considered a zigzag sequence. For a given sequence of numbers, write an algorithm that will return the length of the longest subarray that represents a zigzag sequence.

In the first line of the input, the number N is given for the length of the string. In each of the next N rows, one number from the original sequence is given. The output should print the length of the longest subarray which is a zigzag sequence of the original array.


Name of Java class: ZigZagSequence
For example:

| Input         | Result        |
| ------------- | ------------- |
|   4           |  4            |
|  -1           |               |
|   4           |               |
|  -3           |               |
|   2           |               |

