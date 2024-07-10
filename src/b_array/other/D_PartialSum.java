package b_array.other;


/*
*       To get subarray sum we need to create a new arrays such that ps[i] = arr[0]+arr[1]...arr[n-1]
*       sum of subarray[n-n1] = ps[n1] - ps[n-1]
*       sum of subarray[2-4] = ps[4] - ps[1]
*
*
*
* */
import java.util.Arrays;

public class D_PartialSum {
    public int [] nos = {7,-2,3,9,-11,5,1,-3};

    public int [] partialSum = new int[8];

    public void populatePartialSum(){
        partialSum[0] = nos[0];
        for(int i=1;i<nos.length;i++){
            partialSum[i] = partialSum[i-1]+nos[i];
        }
    }

    public int getPartialSum(int start,int end){
        int result = 0;
        result =  partialSum[end]-partialSum[start-1];

        return result;

    }

    public static void main(String[] args) {
        D_PartialSum d_partialSum = new D_PartialSum();
        d_partialSum.populatePartialSum();
        System.out.println(Arrays.toString(d_partialSum.partialSum));
        System.out.println(d_partialSum.getPartialSum(2,4));
    }
}
