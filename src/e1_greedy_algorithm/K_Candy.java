package e1_greedy_algorithm;

import java.util.Arrays;

public class K_Candy {

    public static void main(String[] args) {
        K_Candy sol = new K_Candy();
        System.out.println(sol.candy(new int[]{1,0,2}));
    }

    public int candy(int[] ratings) {
        int sum = 1;
        int ind = 1;
        int n = ratings.length;

        while(ind < n){
            //Flat
            if(ratings[ind-1] == ratings[ind]){
                sum += 1;
                ind++;
                continue;
            }


            //Upwords
            int peak = 1;
            while(ind < n && ratings[ind-1] < ratings[ind]){
                peak += 1;
                sum += peak;
                ind++;
            }

            //downword
            int down =1;
            while(ind < n && ratings[ind-1] >  ratings[ind]){
                sum += down;
                down += 1;
                ind++;
            }

            //If peak was less then down then add down-peak to sum
            if(down > peak)
                sum += down - peak;
        }

        return sum;
    }


    //TC : O(3N)
    //SC : O(2N)
    public int candyBF(int[] ratings) {
        int n = ratings.length;
        int [] left = new int[n];
        int [] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;


        for(int i = 1; i< n; i++){
            if(ratings[i] > ratings[i-1])
                left[i] = left[i-1]+1;
            else
                left[i] = 1;
        }
        System.out.println(Arrays.toString(left));
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                right[i] = right[i+1]+1;
            else
                right[i] = 1;
        }
        System.out.println(Arrays.toString(right));
        int sum = 0;
        for(int i = 0; i< n; i++){
            sum = sum + Math.max(left[i], right[i]);
        }

        return sum;
    }
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int [] left = new int[n];


        left[0] = 1;
        left[n-1] = 1;


        for(int i = 1; i < n; i++){
            int temp = 0;
            if(ratings[i] > ratings[i-1]){
                temp  = left[i-1]+1;
                left[i] = Math.max(temp, left[i]);
            }else{
                left[i] = Math.max(1, left[i]);
            }

            if(ratings[n-1-i] > ratings[n-i]){
                temp =  left[n-i]+1;
                left[n-1-i]  =  Math.max(temp, left[n-1-i]);
            }else{
                left[n-1-i] = Math.max(left[n-1-i],1);
            }
        }
        System.out.println(Arrays.toString(left));
        int sum = 0;
        for(int i = 0; i< n; i++){
            sum = sum + left[i];
        }

        return sum;
    }
}
