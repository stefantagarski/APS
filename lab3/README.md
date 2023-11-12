1. //
Before the battalion commander are lined up all the soldiers, and in a doubly linked list are given their IDs.
The commander doesn't like how the soldiers are lined up so he decides to choose one sub-interval and reverse it.

Input: In the first line you are given the number of soldiers. In the second line you are given the IDs of each solider. 
In the third line you are given two numbers, IDs of the first and last solider of the sub-interval.

Output: Print the new solider line-up (i.e. their IDs), from the beginning of the list to the end, and reversed.

Note 1: The sub-interval, as well as the list itself, will have at least two soldiers.
Note 2: Pay special attention when the interval begins with the first soldier of the list, or ends with the last one.

Pay attention:
1. All the needed code for the structure that you need to use is given. The test class DLLVojska.java is also given, with completely implemented input and output. You only need to change the code of the void battalion(DLL<Integer> list, int a, int b) method.
2. The moving of the intervals needs to be done with changing the links of the nodes in the list.
3. You must not change the main method !

2.//
Given N words (N>=2), find the number of pairs of words that begin with the same letter.

Input: In the first line of input you are given the number of words (N). Then, in the following N lines of input, you have the the words themselves.

Output: On output you should print the number of pairs of words that start with the same letter.

3.//
There are N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse.
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x -1. Any of these moves consumes 1 minute. More than 1 mouse can move at the same time.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Input: In the first line of input, separated with spaces, you are given the position of the mice, and in the second line, also separated with spaces, are the positions of the holes.

Output: The minimum time in minutes for all the mice to get in a certain hole.

