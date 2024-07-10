package b_array.hard;


/*
https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
https://leetcode.com/problems/set-mismatch/description/
https://youtu.be/2D0D8HE6uak
* */
public class I_Find_The_Repeating_And_Missing_Number {



    /*
    Time Complexity: O(N), where N = the size of the given array.
    Reason: We are using only one loop running for N times. So, the time complexity will be O(N).

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
    * */
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length; // size of the array
        // Find Sn and S2n:
        long sum_Of_First_N_Numbers = (n * (n + 1)) / 2;
        long sum_Of_Sqaure_Of_First_N_Numbers = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long sumOfArrayElement = 0, sumOfSquareOfArrayElement = 0;
        for (int i = 0; i < n; i++) {
            sumOfArrayElement += nums[i];
            sumOfSquareOfArrayElement += (long)nums[i] * (long)nums[i];
        }

        //S-Sn = X-Y:
        long X_Minus_Y = sumOfArrayElement - sum_Of_First_N_Numbers;

        // S2-S2n = X^2-Y^2:
        long X_Square_Minus_Y_Square = sumOfSquareOfArrayElement - sum_Of_Sqaure_Of_First_N_Numbers;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        X_Square_Minus_Y_Square = X_Square_Minus_Y_Square / X_Minus_Y;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (X_Minus_Y + X_Square_Minus_Y_Square) / 2;
        long y = x - X_Minus_Y;

        int[] ans = {(int)x, (int)y};
        return ans;
    }


    /*
    Optimal Approach 2 (Using XOR):
    Using XOR, we are going to solve this problem using the following 3 steps.

    Assume the repeating number to be X and the missing number to be Y.

    Step 1: Find the XOR of the repeating number(X) and the missing number(Y)
    i.e. (X^Y) = (a[0]^a[1]^.....^a[n-1]) ^ (1^2^........^N)

    In order to find the XOR of the repeating number and the missing number,
    we will first XOR all the array elements and with that value, we will again XOR all the numbers from 1 to N.
    (X^Y) = (a[0]^a[1]^.....^a[n-1]) ^ (1^2^3^........^N)
    Step 2: Find the first different bit from right between the repeating and the missing number
    i.e. the first set bit from right in (X^Y)

    By convention, the repeating and the missing number must be different
    and since they are different they must contain different bits.
    Now, our task is to find the first different bit from the right i.e. the end.
     We know, the XOR of two different bits always results in 1.
     The position of the first different bit from the end will be the first set bit(from the right) in (X^Y)
      that we have found in step 1.
    Step 3: Based on the position of the different bits we will group all the elements
     ( i.e. all array elements + all elements between 1 to N) into 2 different groups

    Assume an imaginary array containing all the array elements and all the elements between 1 to N.
    Now, we will check that particular position for each element of that imaginary array
    and then if the bit is 0, we will insert the element into the 1st group otherwise,
    we will insert it into the 2nd group.
    After performing this step, we will get two groups.
    Now, if we XOR all the elements of those 2 groups, we will get 2 numbers.
     One of them will be the repeating number and the other will be the missing number.
     But until now, we do not know which one is repeating and which one is missing.
    Last step: Figure out which one of the numbers is repeating and which one is missing

    We will traverse the entire given array and check which one of them appears twice.
    And the number that appears twice is the repeating number and the other one is the missing number.
    Approach:
    The steps are as follows:

    For the first step, we will run a loop and calculate the XOR of all the array elements and the numbers between 1 to N.
     Let’s call this value xr.
    In order to find the position of the first set bit from the right,
     we can either use a loop or we can perform AND of the xr and negation of (xr-1) i.e. (xr & ~(xr-1)).
    Now, we will take two variables i.e. zero and one. Now,
     we will check the bit of that position for every element (array elements as well as numbers between 1 to N).
    If the bit is 1: We will XOR that element with variable one.
    If the bit is 0: We will XOR that element with variable zero.
    Finally, we have two variables i.e. two numbers zero and one.
     Among them, one is repeating and the other is missing. It’s time to identify them.
    We will traverse the entire array and check how many times variable zero appears.
    If it appears twice, it will be the repeating number, otherwise, it will be the missing. Now, based on variable zero’s identity, we can easily identify in which category, variable one belongs.


    * */

    public static int[] findMissingRepeatingNumbersOptimal2(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: find first 1 bit from right
        int number = (xr & ~(xr - 1));
        /*
        int no = 0;
        while((xr & 1<<no) == 0){
                no++;
        }

        */

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }


    /*
    Time Complexity: O(2^N), where N = the size of the given array.
    Reason: We are using two loops each running for N times. So, the time complexity will be O(2^N).

    Space Complexity: O(N) as we are using a hash array to solve this problem.
    * */
    public static int[] findMissingRepeatingNumbersBetter(int[] a) {
        int n = a.length; // size of the array
        int[] hash = new int[n + 1]; // hash array

        //update the hash array:
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
        }

        //Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }
    /*
    Time Complexity: O(N^2), where N = size of the given array.
    Reason: Here, we are using nested loops to count occurrences of every element between 1 to N.

    Space Complexity: O(1) as we are not using any extra space.
    * */
    public static int[] findMissingRepeatingNumbersBF(int[] a) {
        int n = a.length; // size of the array
        int repeating = -1, missing = -1;

        //Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            //Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == i) cnt++;
            }

            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }
}
