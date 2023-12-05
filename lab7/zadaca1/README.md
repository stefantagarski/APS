You are supposed to simulate a log in system. The user enters username and password. If such user exists in the system you are supposed to print "Najaven" to the standard output, else print "Nenajaven" and give the user another prompt for credentials. This stops when the user will enter username and password that match, a certain user credentials in the system.

Input: In the first line of the input you are given a single integer N. In the following N lines you are given usernames and passwords separated with one white space. These are the users that exist in the system. After this you are supposed to read usernames and passwords from the standard input until, a user can be successfully logged in.

Output: Print "Nenajaven" to the standard output for every failed log in try, until we get a successful log in. Then you have to print "Najaven"

Example. Input: 3 ana banana pero zdero trpe trpi ana ana ana banana trpe trpi KRAJ

Output: Nenajaven Najaven

Note: Use closed bucket hash table. Figure out the hash table size by yourself. The hash function has already been given to you.

Class name: Lozinki
