A single linked list of duplicate numbers is given. For a given value of an info field in the list, 
ensure that the number of repetitions (duplicates) of that number is even. If for the given value of the info field,
the number of elements with that value is odd, an element with the same value should be added before the first appearance of the value.

**Note**: 0 is an even number.

**Input**: In the first line, the number of elements in the list are given, then the elements themselves, and finally, the number (value) that will ensure that it appears an even number of times.

**Output**: The list with an even number of duplicates for a given value is printed on output.

**Examples**:

_Input_: 
</br>
6 </br>
1 2 5 7 9 12 </br>
7

_Output_:
1 2 5 7 7 9 12
