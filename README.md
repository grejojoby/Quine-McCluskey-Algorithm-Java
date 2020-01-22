# Quine-McCluskey-Algorithm-Java
## Introduction:
The Quine–McCluskey algorithm (or the method of prime implicants) is a method used for minimization of Boolean functions that was developed by Willard V. Quine and extended by Edward J. McCluskey. It is functionally identical to Karnaugh mapping, but the tabular form makes it more efficient for use in computer algorithms, and it also gives a deterministic way to check that the minimal form of a Boolean function has been reached. It is sometimes referred to as the tabulation method.
The method involves two steps:
1.	Finding all prime implicants of the function.
2.	Use those prime implicants in a prime implicant chart to find the essential prime implicants of the function, as well as other prime implicants that are necessary to cover the function.

## Problem Definition:
The method groups the minterms entered by the user first according to the number of ones in their binary equivalent. Then the minterms are grouped in such a way that the there is only change in a single position of the two minterms compared. The comparing is carried forward to newer tables until there are no more groups to be formed. Then all the minterms that are never paired are chosen as prime implicants and using the least number of prime implicants that cover all minterms, we generate the minimized equation for the Boolean function.

## Modules:
- void minTermsDectoBin(); - Converts decimal minterms to binary equivalents.
- int totalSizeCalc(); - Calculates the max no. of minterms for the no of
   variables.
- int calcNoOfOnes(int[]); - Counts the no of ones in the binary of the minterm
- void display(); - Various Display Functions to display the tables
- int compare(); - Various compare functions to compare tables and
   minterms
- void firstStage(); - First Stage grouping
- void printParityTable(); - To print the parity table
- void parityInit(); - Initialize the parity table with -1
- int paritycheck(); - To check the prime implicants
- int checkForSingle(); - Prime implicants that are must to be included in eqn
- int parityToEqt(); - To generate equation from prime implicants
- void displayFinal(); - Display the final equation

## Conclusion:
The Quine-McCluskey Method was hence implemented using arrays. Array was used because the size of the data elements to be stored where fixed and was in a tabular form of a 2d array. Also, there was no need to access elements from between and hence a linear traversal was only required along with static storage, which provides a fast access. Hence, arrays were preferred for the implementation of tabular form Quine-McCluskey Method. And thereby using arrays we implemented the project which performs the operation of minimizing the Boolean function entered by the user. The method hence provided with the minimized equations of the function.
