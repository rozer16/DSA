package b_array;



/*
* Arr : 2 -7 10 3 -1 19 -20 23 17
*
* Query1 : update(2,6,5) ==> Update 2 to 6 index by value 5
*                        ==> Add temp1= temp[1]+5, substract temp1= temp[7]-5
* Query2 : update(3,7,2) ==> Update 3 to 7 index by value 2
* Query3 : update(1,5,-1) ==> Update 1 to 5 index by value -1
*
*
* newArr : 0 0 0 0 0 0 0 0 0
* query1 : 0 0 5 0 0 0 0 -5 0
* query2 : 0 0 5 2 0 0 0 -5 -2
* query3 : 0 -1 5 2 0 0 1 -5 -2
*
* sumArr : 0 -1 4 6 6 6 7 2 0
*
* arr+sumArr : 2 -8 14 9 5 25 -13 25 17
*
* */


import java.util.Arrays;

public class N_MultipleRangeUpdate {

    static int [] arr = new int[9];
    static  int [] temp1 = new int[9];


    public static void multipleRangeUpdate(int startIndex,int endIndex,int add){
        temp1[startIndex] = temp1[startIndex]+add;
        temp1[endIndex+1] = temp1[endIndex+1]-add;
    }

    public static void buildFinalArr(){
        for (int i = 1; i < temp1.length; i++) {
            temp1[i] = temp1[i]+temp1[i-1];
            arr[i] = arr[i]+temp1[i];
        }
    }

    public static void main(String[] args) {
        arr= new int[]{2, -7, 10, 3, -1, 19, -20, 23, 17};
        Arrays.fill(temp1,0);

        multipleRangeUpdate(2,6,5);
        multipleRangeUpdate(3,7,2);
        multipleRangeUpdate(1,5,-1);

        buildFinalArr();
        System.out.println(Arrays.toString(arr));
    }
}

