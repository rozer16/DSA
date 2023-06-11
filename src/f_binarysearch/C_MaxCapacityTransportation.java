package f_binarysearch;


import java.util.Arrays;

/*
* n boxes : g[i] = weight of box i
* Transport them using a truck with capacity C in the same order they are given
* Sum of weight of the boxes taken at each transport can exceed C
* Find the minimum C such that we can move all boxes using maximum K transport.
*
* C : Maximum capacity of truck
* K: No of trip truck has to do to transport x boxes with maximum capacity of C
*
* Need to find C such that we can transport all boxes in k trips
*
* Step I: Find maximum element of an array
* Step II : Find sum of an array
* Step III : int getNoOfTrips(int arr[], int capacity)
*       Boxes weight : {7,3,2,3,1,4};
*
*       Max Capacity : 7 8 9 10 11 12  ... 20
*       No Of Rides  : 4 3 3 2  2  2   ... 1
*
* From above stats, lets say for k(max trips) = 3, we should have minimum capacity = 8
* Which tells us we need to find lower bound(first element that is greater than or equal to x)
*
*
* Now possible solution could be between maxElement to sum(7..20)
* So we can keep left = 7 and right = 20 and apply lower bound concept of binary search.
*
* */
public class C_MaxCapacityTransportation {


    public int getMinimumCapacityToTransportNBoxesUsingKTrip(int arr[], int k){
        int left = getMax(arr);
        int right = getSum(arr);
        int ans = 0;
        while(left <= right){
            int mid = (right+left)/2;

            if(getNoOfTripsForCapacity(arr,mid) <= k){
                ans = mid;
                right = mid -1;
            }else{
                left  = mid+1;
            }
        }

        return ans;
    }
    public int getMax(int [] arr){
        return Arrays.stream(arr).max().orElse(0);
    }

    public int getSum(int [] arr){
        return Arrays.stream(arr).sum();
    }

    public int getNoOfTripsForCapacity1(int [] arr,int c){
        int ans = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i] <=c){
                sum+=arr[i];
            }else{
                ans++;
                sum=arr[i];
            }

        }


        return  ans;
    }

    public int getNoOfTripsForCapacity(int [] arr,int c){
        int i = -1;
        int sum = 0;
        int ans = 0;
        while(i< arr.length-1){
            i++;
            sum = arr[i];

            while(i< arr.length-1 && sum+arr[i+1] <= c ) {
                sum += arr[i+1];
                i++;
            }

            ans++;
        }

        return ans;
    }



    public static void main(String[] args) {
        int arr[] = {7,3,2,3,1,4};
        C_MaxCapacityTransportation test = new C_MaxCapacityTransportation();
        System.out.println(test.getMinimumCapacityToTransportNBoxesUsingKTrip(arr,2));
    }
}
