It is necessary to make a computer application that will speed up the operation of a pharmacy. The application should enable the user (pharmacist) to quickly search through the huge set of drugs entered into the system. The way he should search is as follows: it is enough to enter the first 3 letters of the name of the drug so that a list of the drugs available in the system can be displayed. The job of the pharmacist is to check if the drug is in the system and to give information to the client. The information he should give to the customer is whether the drug is on the positive list of drugs, what is the price and how many pieces of the drug are in stock. If the drug exists, the customer orders it, stating how many pieces he will buy. The pharmacist should record this action on the system (that is, reduce the stock of drugs by as many pieces as he dispensed to the client). If the customer's order is greater than the drug stock in the system, no action is taken.

Input: From the standard input, a number N is first given which represents the number of drugs that will be entered into the system. In the next N lines are given the names of the drugs, whether they are on the positive list (1/0), the price and number of pieces, all separated by a space. Lines are then given with drug names and number of pieces ordered by the customer. The word is given to indicate the end KRAJ.

Output: The following information should be printed on the standard output for each of the inputs: IME POZ/NEG CENA BR_LEKOVI. If the drug is not found, Nema takov lek. is printed. If the customer's order is larger than the stock, it is printed  Nema dovolno lekovi, otherwise Napravena naracka.

Note: The problem should be solved with a hash table. The function that maps drug names to numbers is as follows: h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780 where the word w=c1c2c3c4c5…. is composed of all capital letters.

Also, for the drugs, a separate class should be made which will have the specified characteristics of the drug in the system as attributes.

Class name: Apteka.
