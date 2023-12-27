Your task is to create an unoriented unweighted graph by using an adjacency list, where each vertex information is аn integer. You create the graph according to the received commands. You will be given an array of commands that can be one of the following:

CREATE - you should create a new graph.

ADDEDGE [number1] [number2] - you should create an edge between the vertices with ordinal number number1 and ordinal number number2. 

DELETEEDGE [number1] [number2] - you should remove the edge between the vertices with ordinal number number1 and ordinal number number2.

ADЈACENT [number1] [number2] - you should print true if the vertices with ordinal number number1 and ordinal number number2 are adjacent, otherwise print false.

PRINTGRAPH - you should print the adjacency list. 

The number of commands is given in the first input line. 

Input	
5
CREATE
ADDEDGE 0 3
PRINTGRAPH
ADJACENT 0 2
DELETEEDGE 3 0

Result
0: [3]
3: [0]
false
