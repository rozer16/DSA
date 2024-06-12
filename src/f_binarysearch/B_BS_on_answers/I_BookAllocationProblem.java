package f_binarysearch.B_BS_on_answers;

import java.util.Arrays;
import java.util.List;

/*
https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/

https://www.youtube.com/watch?v=Z0hwjftStI4
https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries

Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.



There are ‘m’ number of students, and the task is to allocate all the books to the students.



Allocate books in such a way that:

1. Each student gets at least one book.
2. Each book should be allocated to only one student.
3. Book allocation should be in a contiguous manner.


You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.



If the allocation of books is not possible, return -1.

Rules to assign book

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
For n students all book must be distributed


The extremely naive approach is to check all possible pages from max(arr[]) to sum(arr[]).
            We are taking lower range as max of array since we need to distribute all the book so we take value less than max than we wont be able to distribute
            since student cant take more no of pages than decided
            We are upper range as taking sum of all since student can be 1 and we can assign sum no of pages

The minimum pages for which we can allocate all the books to M students will be our answer.
* */
public class I_BookAllocationProblem {
    public static void main(String[] args) {
        I_BookAllocationProblem sol = new I_BookAllocationProblem();
        System.out.println(sol.findPages(Arrays.asList(25, 46, 28, 49, 24),5,4));
    }

    public  int findPages(List<Integer> bookPages, int n, int m) {

        if (m > n)
            return -1;

        int [] maxSum = findMaxSum(bookPages);
        int low = maxSum[0];
        int high = maxSum[1];
        int ans = -1;

       while(low <= high){
           int mid = low + (high-low)/2;

           if(canAssignPPagesToSStudent(bookPages,mid) > m){
              low = mid+1;
           }else{
               high = mid-1;
           }
       }

        return low;
    }
    public  int findPagesBruteForce(List<Integer> arr, int n, int m) {

        if (m > n)
            return -1;

        int [] maxSum = findMaxSum(arr);
        int low = maxSum[0];
        int high = maxSum[1];

        for (int pages = low; pages <= high ; pages++) {
            //Check if we can assign all the books to all the student with noOfPages = pages
            if(canAssignPPagesToSStudent(arr,pages) == m){
                return pages;
            }
        }

        return -1;
    }

    public int canAssignPPagesToSStudent(List<Integer> arr, int pages){
        int noOfPages = 0;
        int noOfStudent = 1;

        for (int i = 0; i < arr.size(); i++) {
            if(noOfPages + arr.get(i) > pages){
                //  // add pages to next student
                noOfStudent++;
                noOfPages = arr.get(i);
            }else{
                // // add pages to current student
                noOfPages += arr.get(i);
            }
        }



        return noOfStudent;
    }
    public int[] findMaxSum(List<Integer> pages){
        int maxSum [] = new int[2];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int page : pages){
            if(max < page)
                max = page;

            sum += page;
        }

        return  new int[]{max, sum};
    }
}
