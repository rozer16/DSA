package c_binarysearch.B_BS_on_answers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class K_Painters_Partition {

    public static void main(String[] args) {
        K_Painters_Partition sol = new K_Painters_Partition();
        System.out.println(sol.findLargestMinDistance(Arrays.asList(10, 20, 30, 40),2));
    }
    public int findLargestMinDistance(List<Integer> boards, int k){
       int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low <= high){
            int mid = low + (high-low)/2;

            if(getNoOfPainterToPaintNBoards(boards, mid) > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;

        /*int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = getNoOfPainterToPaintNBoards(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;*/
    }

    public static int getNoOfPainterToPaintNBoards(List<Integer> boards, int maxLength){
        int sum = 0;
        int noOfPainter = 1;

        for(int board : boards){
            if(sum + board > maxLength){
                noOfPainter++;
                sum = board;
            }else{
                sum += board;
            }
        }

        return noOfPainter;
    }
}
