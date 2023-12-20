A bus with capacity capacity drives its route and picks up and drops off passengers. For each passenger, you're given the time when they boarded the bus and the time when they got off the bus. You should determine whether all passengers can ride the bus, that is, whether the number of passengers currently on the bus doesn't exceed the capacity at any moment. In the first line, you're given the capacity. In the next line, you're given the number of passengers N. In the next N lines, you're given the time each passenger boarded and got off the bus in the format HH:MM.

To solve this problem you should use an appropriate data structure that will let you achieve the desired result with minimal complexity. The bus rides until  23:59.

You should print true if the maximum number of passengers on the bus at the same time doesn't exceed the capacity, otherwise false.

Input: In the first line, you're given the capacity. In the next line, you're given the number of passengers N. In the next N lines, you're given the time each passenger boarded and got off the bus in the format HH:MM.

Output: true if the maximum number of passengers on the bus at the same time doesn't exceed the capacity, otherwise false.

Example: 

2

3

08:30 9:30

09:25 10:10

07:00 9:00

Output: true
