The text for the tasks for laboratory exercise #1
"Introduction to Java"

1. For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence. Print the transformed array to standard output.

For example:
Input:	
12
1 9 8 4 0 0 2 7 0 6 0 9

Result:
Transformiranata niza e:
0 0 0 0 1 9 8 4 2 7 6 9


2. For a given word entered from standard input, print it reversed. On input in the first line, the number of words that will be entered is given. In the following lines, the words are entered.

For example:

Input:	
3
one
two
three

Result:
eno
owt
eerht


3. For the purpose of software for keeping track of the revenue generated by employees in the sales department, define a 
QuarterlySales class that stores the number of sales, the revenue generated by each sale, and the number of the quarter.

Then define another SalesPerson class for which a name(string) and an array of quarterly sales (exactly 4) are stored. 
For the classes implement the appropriate constructors and methods for the correct execution of the program.

Implement the following requirements:
• Method `int sumSales(SalesPerson sp)' which will return the sum of all the revenues in all quarters generated by the given worker.

• Method `SalesPerson salesChampion(SalesPerson [] arr)' which for the given array of sales employees will return the worker with the most generated revenue (of all quarters)
• Add the `main' method, which will initialize an array of salespersons and quarters according to the input test cases. 

The number of sales employees is read from input in the first line, and then for each employee, the name is read in the first line, 
and then for each of the quarters for that employee in the first line we have the number of sales, and then in the next line the revenue generated by each of those sales.

• On standard output, print the array of sales employees using the method `void table(SalesPerson [] arr)', 
which will print a display for the array of sales persons in the following format (three spaces are used for printing space):

For example:

Input:
5
Damian
3
2000 1500 1000
5
1000 1300 2500 800 1100
2
3000 2000
1
1700
Samantha
4
1500 2000 1700 1200
6
900 1200 1800 1100 1500 1300
3
2500 3000 2000
5
800 1000 1300 1200 900
Jackson
5
1300 1500 1600 1200 1400
4
1700 2100 2000 1900
6
900 1200 1500 1800 2000 2200
7
500 700 900 1100 1300 1500 1700
Olivia
2
3500 3000
3
2000 2500 3000
4
1500 1800 2100 2400
5
1000 1300 1600 1900 2200
Liam
6
1100 1400 1700 2000 2300 2600
7
500 700 900 1100 1300 1500 1700
8
800 1000 1200 1400 1600 1800 2000 2200
3
2700 3000 3300

Result: 

SP   1   2   3   4   Total
Damian   4500   6700   5000   1700   17900
Samantha   6400   7800   7500   5200   26900
Jackson   7000   7700   9600   7700   32000
Olivia   6500   7500   7800   8000   29800
Liam   11100   7700   12000   9000   39800

SALES CHAMPION: Liam
