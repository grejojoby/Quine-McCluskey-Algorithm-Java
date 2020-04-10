import java.util.Scanner;
import java.util.Vector;
import ts.display;
class declarations {

    // Variable Declarations
    public static int i = 0, j = 0, l = 0, k = 0, c = 0, noOfVariables = 0, maxBit = 0, noOfMinTerms = 0;
    public static int[] minTermsDec = new int[16];
    public static int[][] minTermsBin = new int[16][16];
    public static int[] noOfOnes = new int[16];

    public static int[][] g0 = new int[14][5];
    public static int[][] g1 = new int[16][5];
    public static int[][] g2 = new int[16][5];
    public static int[][] g3 = new int[16][5];
    public static int[][] g4 = new int[16][5];

    public static int[][] h0 = new int[16][7];
    public static int[][] h1 = new int[16][7];
    public static int[][] h2 = new int[16][7];
    public static int[][] h3 = new int[16][7];

    public static int[][] i0 = new int[16][9];
    public static int[][] i1 = new int[16][9];
    public static int[][] i2 = new int[16][9];

    public static int[][] k0 = new int[16][13];
    public static int[][] k1 = new int[16][13];

    public static int[][] parityTable = new int[20][24];
    public static int gzero = 0, gone = 0, gtwo = 0, gthree = 0, gfour = 0;
    public static int hzero = 0, hone = 0, htwo = 0, hthree = 0;
    public static int izero = 0, ione = 0, itwo = 0;
    public static int kzero = 0, kone = 0;
    public static int[][] Final = new int[100][5];
    public static int finalc = 0;
    public static int parityCnt = 0;

    static Scanner s = new Scanner(System.in);

    //Constructor to initialize parity 
    declarations() {
    for (i = 0; i < 20; i++)
            for (j = 0; j < 24; j++)
                parityTable[i][j] = -1;
    }
    // Function Definitions
    public static int parityToEqt() // Function to generate the parity bits
    {
        for (j = 0; j < 16; j++) {
            if (checkForSingle(j) != 100) {
                Final[finalc][0] = parityTable[checkForSingle(j)][20];
                Final[finalc][1] = parityTable[checkForSingle(j)][21];
                Final[finalc][2] = parityTable[checkForSingle(j)][22];
                Final[finalc][3] = parityTable[checkForSingle(j)][23];
                finalc++;
            }
        }
        return 0;
    }
// Function to compare the parity table and final parities for equation
    public static int compareSamefinal(int a[][], int size) 
    {
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size;) {
                if ((a[j][0] == a[i][0]) && (a[j][1] == a[i][1]) && (a[j][2] == a[i][2]) && (a[j][3] == a[i][3])) {
                    for (k = j; k < size; k++) {
                        a[k][0] = a[k + 1][0];
                        a[k][1] = a[k + 1][1];
                        a[k][2] = a[k + 1][2];
                        a[k][3] = a[k + 1][3];
                    }
                    size--;
                } else {
                    j++;
                }
            }
        }
        return size;
    }
// Function to check for parity that are necessary for equation as they are lone contributers for a minterm
    public static int checkForSingle(int column) 
    {
        int patc = 0, temp121 = 0;
        for (i = 0; i < parityCnt; i++) {
            if (parityTable[i][column] == 999) {
                temp121 = i;
                patc++;
            }
        }
        if (patc == 1)
            return temp121;
        else
            return 100;
    }

    public static int paritycheck3(int a[][], int b[][], int h[][], int first, int second,
            int third) 
    {
        int t = 0;
        while (t != first) {
            int c = 0;
            for (i = 0; i < second; i++) {

                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != b[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            for (i = 0; i < third; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != h[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            if (c == 0) {
                parityTable[parityCnt][16] = a[t][4];
                parityTable[parityCnt][17] = a[t][5];
                parityTable[parityCnt][18] = a[t][6];
                parityTable[parityCnt][19] = a[t][7];

                parityTable[parityCnt][23] = a[t][3];
                parityTable[parityCnt][22] = a[t][2];
                parityTable[parityCnt][21] = a[t][1];
                parityTable[parityCnt][20] = a[t][0];

                parityTable[parityCnt][a[t][7]] = 999;
                parityTable[parityCnt][a[t][6]] = 999;
                parityTable[parityCnt][a[t][5]] = 999;
                parityTable[parityCnt][a[t][4]] = 999;
                parityCnt++;
            }
            t++;
        }
        return 0;
    }

    public static int paritycheck2(int a[][], int b[][], int h[][], int first, int second,
            int third) // Function to check parity
    {
        int t = 0;
        while (t != first) {
            int c = 0;
            for (i = 0; i < second; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != b[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            for (i = 0; i < third; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != h[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            if (c == 0) {
                parityTable[parityCnt][16] = a[t][4];
                parityTable[parityCnt][17] = a[t][5];

                parityTable[parityCnt][23] = a[t][3];
                parityTable[parityCnt][22] = a[t][2];
                parityTable[parityCnt][21] = a[t][1];
                parityTable[parityCnt][20] = a[t][0];

                parityTable[parityCnt][a[t][5]] = 999;
                parityTable[parityCnt][a[t][4]] = 999;
                parityCnt++;
            }
            t++;
        }
        return 0;
    }

    public static int paritycheck1(int a[][], int b[][], int h[][], int first, int second,
            int third) // Function to check parity
    {
        int t = 0;
        while (t != first) {
            int c = 0;
            for (i = 0; i < second; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != b[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            for (i = 0; i < third; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] != h[i][j]) {
                        flag++;
                    }
                }
                if (flag == 1) {
                    c++;
                }
            }
            if (c == 0) {
                parityTable[parityCnt][16] = a[t][4];
                parityTable[parityCnt][23] = a[t][3];
                parityTable[parityCnt][22] = a[t][2];
                parityTable[parityCnt][21] = a[t][1];
                parityTable[parityCnt][20] = a[t][0];
                parityTable[parityCnt][a[t][4]] = 999;
                parityCnt++;
            }
            t++;
        }
        return 0;
    }

    public static int totalSizeCalc() // Function to check the maximum no of minterms possible for the no of variables
    {
        for (i = 0; i < noOfVariables; i++) {
            maxBit = maxBit + (int) Math.pow(2, i);
        }
        return maxBit + 1;
    }

    public static void inputMinTerms() // Function to input the minterms
    {
        int inp = 0;
        Vector<Integer> vec = new Vector<Integer>(16);
        System.out.print("Enter the minterms to be minimized: \n");
        for (i = 0; i < maxBit; i++) {
            inp = s.nextInt();
            if (inp >= (maxBit)) {
                for (i = 0; i < noOfMinTerms; i++)
                    minTermsDec[i] = vec.get(i);
                return;
            }
            else if (inp == (-1)) {
                for (i = 0; i < noOfMinTerms; i++)
                    minTermsDec[i] = vec.get(i);
                return;
            } else {
                vec.add(inp);
                noOfMinTerms++;
            }
        }
    }

    public static int calcNoOfOnes(int num[]) // Function to calculate the no of ones in the minterms binary value
    {
        int flag = 0;
        for (i = 0; i < maxBit; i++) {
            if (num[i] == 1)
                flag++;
        }
        return flag;
    }

    public static void minTermsDectoBin() // Function to convert the minterms in decimal to their binary equivalents
    {
        int temp;
        for (i = 0; i <= noOfMinTerms; i++) {
            for (j = 0; j < noOfMinTerms; j++) {
                temp = minTermsDec[j];
                minTermsBin[j][4] = temp;
                for (l = 3; l >= 0; l--) {
                    minTermsBin[j][l] = temp % 2;
                    temp = temp / 2;
                }
                if (minTermsDec[j] == 1)
                    noOfOnes[j] = 1;
                else
                    noOfOnes[j] = calcNoOfOnes(minTermsBin[j]);
            }
        }
    }

    public static void firstStage() // Function for first stage comparisons
    {
        for (i = 0; i < noOfMinTerms; i++) {
            if (noOfOnes[i] == 0) {
                for (j = 0; j < 5; j++) {
                    g0[gzero][j] = minTermsBin[i][j];
                }
                gzero++;
            }
            if (noOfOnes[i] == 1) {
                for (j = 0; j < 5; j++) {
                    g1[gone][j] = minTermsBin[i][j];
                }
                gone++;
            }
            if (noOfOnes[i] == 2) {
                for (j = 0; j < 5; j++) {
                    g2[gtwo][j] = minTermsBin[i][j];
                }
                gtwo++;
            }
            if (noOfOnes[i] == 3) {
                for (j = 0; j < 5; j++) {
                    g3[gthree][j] = minTermsBin[i][j];
                }
                gthree++;
            }
            if (noOfOnes[i] == 4) {
                for (j = 0; j < 5; j++) {
                    g4[gfour][j] = minTermsBin[i][j];
                }
                gfour++;
            }
        }
    }

    public static void display() // Display function to display the no of ones
    {
        for (j = 0; j < noOfMinTerms; j++) {
            System.out.print(noOfOnes[j] + "\t");
        }
    }

    public void displayFinal() // Function to display the final table
    {
        for (i = 0; i < finalc; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(Final[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void displayArray(int a[][], int n) // Dsiplay Function
    {
        for (i = 0; i < n; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    static int compare(int a[][], int b[][], int h[][], int first, int second) // Compare Function
    {
        int y = 0, t = 0;
        while (t < first) {
            for (i = 0; i < second; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] == b[i][j]) {
                        h[y][j] = b[i][j];
                    } else {
                        h[y][j] = 9;
                        flag++;
                    }
                }
                if (flag == 1) {
                    h[y][4] = a[t][4];
                    h[y][5] = b[i][4];
                    if (h[y][6] == 0)
                        h[y][6] = 1;
                    y++;
                }
            }
            t++;
        }
        return y;
    }

    public static int compare1(int a[][], int b[][], int h[][], int first, int second) // Compare Function
    {
        int y = 0, t = 0;
        while (t != first) {
            for (i = 0; i < second; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] == b[i][j]) {
                        h[y][j] = b[i][j];
                    } else {
                        flag++;
                        h[y][j] = 9;
                    }
                }
                if (flag == 1) {
                    h[y][4] = a[t][4];
                    h[y][5] = a[t][5];
                    h[y][6] = b[i][4];
                    h[y][7] = b[i][5];
                    y++;
                }
            }
            t++;
        }
        return y;
    }

    public static int compare2(int a[][], int b[][], int h[][], int first, int second) // Compare function
    {
        int y = 0, t = 0;
        while (t != first) {
            for (i = 0; i < second; i++) {
                int flag = 0;
                for (j = 0; j < 4; j++) {
                    if (a[t][j] == b[i][j]) {
                        h[y][j] = b[i][j];
                    } else {
                        flag++;
                        h[y][j] = 9;
                    }
                }
                if (flag == 1) {

                    h[y][4] = a[t][4];
                    h[y][5] = a[t][5];
                    h[y][6] = a[t][6];
                    h[y][7] = a[t][7];

                    h[y][8] = b[i][4];
                    h[y][9] = b[i][5];
                    h[y][10] = b[i][6];
                    h[y][11] = b[i][7];

                    if (h[y][12] == 0)
                        h[y][12] = 1;
                    y++;
                }
            }
            t++;
        }
        return y;
    }

    public static int compareSame(int a[][], int size) // Compare Function
    {
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size;) {
                if ((a[j][0] == a[i][0]) && (a[j][1] == a[i][1]) && (a[j][2] == a[i][2]) && (a[j][3] == a[i][3])) {
                    for (k = j; k < size; k++) {
                        a[k][0] = a[k + 1][0];
                        a[k][1] = a[k + 1][1];
                        a[k][2] = a[k + 1][2];
                        a[k][3] = a[k + 1][3];
                        a[k][4] = a[k + 1][4];
                        a[k][5] = a[k + 1][5];
                        a[k][6] = a[k + 1][6];
                        a[k][7] = a[k + 1][7];
                        a[k][8] = a[k + 1][8];
                    }
                    size--;
                } else {
                    j++;
                }
            }
        }
        return size;
    }

    public static int compareSame2(int a[][], int size) // Compare Function
    {
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size;) {
                if ((a[j][0] == a[i][0]) && (a[j][1] == a[i][1]) && (a[j][2] == a[i][2]) && (a[j][3] == a[i][3])) {
                    for (k = j; k < size; k++) {
                        a[k][0] = a[k + 1][0];
                        a[k][1] = a[k + 1][1];
                        a[k][2] = a[k + 1][2];
                        a[k][3] = a[k + 1][3];
                        a[k][4] = a[k + 1][4];
                        a[k][5] = a[k + 1][5];
                        a[k][6] = a[k + 1][6];
                        a[k][7] = a[k + 1][7];
                        a[k][8] = a[k + 1][8];
                        a[k][9] = a[k + 1][9];
                        a[k][10] = a[k + 1][10];
                        a[k][11] = a[k + 1][11];
                        a[k][12] = a[k + 1][12];
                    }
                    size--;
                } else {
                    j++;
                }
            }
        }
        return size;
    }

    static void parityInit() // Function to initialize the parity table
    {
        for (i = 0; i < 20; i++)
            for (j = 0; j < 24; j++)
                parityTable[i][j] = -1;
    }

    static void printParityTable() // Function to print the parity table
    {
        for (i = 0; i < parityCnt; i++) {
            System.out.print("\n P" + i + 1 + " : ");
            for (j = 16; j < 20; j++) {
                if (parityTable[i][j] == -1)
                    continue;
                else {
                    System.out.print(" " + parityTable[i][j] + " ");
                    if (j != 19 && parityTable[i][j + 1] != -1)
                        System.out.print(",");
                }
            }
            System.out.print("\n");
        }
    }

    static void eqnGenerator() // Function to generate the equation from the parity
    {
        System.out.print("\n The Equation is : \t");
        for (i = 0; i < finalc; i++) {
            if (i != 0)
                System.out.print(" + ");
            for (j = 0; j < 4; j++) {
                if (j == 0 && j < noOfVariables) {
                    if (Final[i][j] == 0)
                        System.out.print("A'");
                    else if (Final[i][j] == 1)
                        System.out.print("A");
                } else if (j == 1 && j < noOfVariables) {
                    if (Final[i][j] == 0)
                        System.out.print("B'");
                    else if (Final[i][j] == 1)
                        System.out.print("B");
                } else if (j == 2 && j < noOfVariables) {
                    if (Final[i][j] == 0)
                        System.out.print("C'");
                    else if (Final[i][j] == 1)
                        System.out.print("C");
                } else if (j == 3) {
                    if (Final[i][j] == 0 && j < noOfVariables)
                        System.out.print("D'");
                    else if (Final[i][j] == 1)
                        System.out.print("D");
                }
            }
        }
    }
}
class l extends declarations {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your name");
            String s = sc.next();
            System.out.print("Enter the number of variables to be Minimized: ");
            noOfVariables = sc.nextInt();
            maxBit = totalSizeCalc();
            parityInit();
            inputMinTerms();
            System.out.println();
            minTermsDectoBin();
            System.out.print("\n\n  **STAGE 1**\n\n");
            firstStage();
            if (gzero != 0) {
                System.out.print("\ngroup of 0s\n");
                displayArray(g0, gzero);
            }
            if (gone != 0) {
                System.out.print("\ngroup of 1s\n");
                displayArray(g1, gone);
            }
            if (gtwo != 0) {
                System.out.print("\ngroup of 2s\n");
                displayArray(g2, gtwo);
            }
            if (gthree != 0) {
                System.out.print("\ngroup of 3s\n");
                displayArray(g3, gthree);
            }
            if (gfour != 0) {
                System.out.print("\ngroup of 4s\n");
                displayArray(g4, gfour);
            }
            System.out.print("\n\n  **STAGE 2**\n\n");
            hzero = compare(g0, g1, h0, gzero, gone);
            if (hzero != 0) {
                System.out.print("\n\nComparing Group 0 with 1:\n");
                displayArray(h0, hzero);
            }
            hone = compare(g1, g2, h1, gone, gtwo);
            if (hone != 0) {
                System.out.print("\n\nComparing Group 1 with 2:\n");
                displayArray(h1, hone);
            }
            htwo = compare(g2, g3, h2, gtwo, gthree);
            if (htwo != 0) {
                System.out.print("\n\nComparing Group 2 with 3:\n");
                displayArray(h2, htwo);
            }
            hthree = compare(g3, g4, h3, gthree, gfour);
            if (hthree != 0) {
                System.out.print("\n\nComparing Group 3 with 4:\n");
                displayArray(h3, hthree);
            }
            System.out.print("\n\n    **STAGE 3**\n\n");
            izero = compare1(h0, h1, i0, hzero, hone);
            izero = compareSame(i0, izero);
            if (izero != 0) {
                System.out.print("\n\nComparing Group 0 with 1:\n");
                displayArray(i0, izero);
            }
            ione = compare1(h1, h2, i1, hone, htwo);
            ione = compareSame(i1, ione);
            if (ione != 0) {
                System.out.print("\n\nComparing Group 1 with 2:\n");
                displayArray(i1, ione);
            }
            itwo = compare1(h2, h3, i2, htwo, hthree);
            itwo = compareSame(i2, itwo);
            if (itwo != 0) {
                System.out.print("\n\nComparing Group 2 with 3:\n");
                displayArray(i2, itwo);
            }
            System.out.print("\n\n Parity Check \n\n");
            paritycheck1(g0, g1, g1, gzero, gone, gone);
            paritycheck1(g1, g2, g0, gone, gtwo, gzero);
            paritycheck1(g2, g3, g1, gtwo, gthree, gone);
            paritycheck1(g3, g4, g2, gthree, gfour, gtwo);
            paritycheck1(g4, g3, g3, gfour, gthree, gthree);

            paritycheck2(h0, h1, h1, hzero, hone, hone);
            paritycheck2(h1, h0, h2, hone, hzero, htwo);
            paritycheck2(h2, h1, h3, htwo, hone, hthree);
            paritycheck2(h3, h2, h2, hthree, htwo, htwo);

            paritycheck3(i0, i1, i1, izero, ione, ione);
            paritycheck3(i1, i0, i2, ione, izero, itwo);
            paritycheck3(i2, i1, i1, itwo, ione, ione);

            parityToEqt();
            printParityTable();
            finalc = compareSamefinal(Final, finalc);
            System.out.print("\n");
            eqnGenerator();
            display d = new display();
            d.disp(s);
        } catch (Exception e) {
            System.out.println("Exception Encountered\n" + e + "\nPlease try again");
        }
    }
}