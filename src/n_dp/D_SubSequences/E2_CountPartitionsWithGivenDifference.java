package n_dp.D_SubSequences;

public class E2_CountPartitionsWithGivenDifference {

    public static void main(String[] args) {

        int N = 4;
        int D = 3;
        int [] ARR = {5, 2, 5, 1};


        E2_CountPartitionsWithGivenDifference solution = new E2_CountPartitionsWithGivenDifference();
        System.out.println("No of partition with D = 3 : "+solution.countPartitionsWithKDiff(ARR,D));

    }


    //S1+S2 = totalSum  ==> S1 = totalSum-S2
    //S1-S2 =D ==> totalSum-S2-S2 = D ==> totalSum - 2S2 = D ==> 2S2 = totalSum-D ==> S2 = (totalSum-D)/2



    public int countPartitionsWithKDiff(int [] arr, int D){

       int totalSum = 0;
        for (int i = 0; i < arr.length; i++)
            totalSum += arr[i];

        int D2 = totalSum -D;


        //As the array elements are positive integers including zero, we don’t want to find the case when S2 is negative or
        // we can say that totSum is lesser than D, therefore if totSum<D, we simply return 0.

        //S2 can’t be a fraction, as all elements are integers, therefore if totSum - D is odd, we can return 0.
        if(D2 < 0 || (D2%2) != 0)
            return 0;

        return new D2_CountSubsetsWithSumK().countSubsetWithSumKSpaceOptimization2(arr,D2/2);
    }


}
