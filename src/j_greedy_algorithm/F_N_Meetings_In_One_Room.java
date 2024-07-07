package j_greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

https://youtu.be/II6ziNnub1Q?list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma


There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i])
where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

nput:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output:
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output:
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)

* */
public class F_N_Meetings_In_One_Room {




    public static void main(String[] args) {
        int start [] = {1,0,3,8,5,8};
        int end [] = {2,6,4,9,7,9};

        F_N_Meetings_In_One_Room sol = new F_N_Meetings_In_One_Room();
       // System.out.println(sol.maxMeetings(start,end,start.length));


         int start1 [] = {1,3,0,5,8,5};
         int end1 [] = {2,4,6,7,9,9};
        //System.out.println(sol.maxMeetings(start1,end1,start1.length));

        int start2 [] =  { 86,32,31,98,37,65,98,71,99,58,59,32,52,69,15,75,4,86,57,36,83,18,58,50,43,29,98,53,80,5,89,73,8,97,17,100,9,21,55,55,32,74,60,32,87,72,54};
        int end2 [] ={126,112,134,138,89,118,107,124,126,83,133,64,124,109,108,132,111,95,82,106,86,118,82,78,92,55,128,121,118,95,94,110,111,146,124,148,95,146,109,61,93,126,74,76,110,78,91};
        System.out.println(sol.maxMeetings(start2,end2,start2.length));
    }

    public int maxMeetings(int start[], int end[], int n) {

        //Comparator to sort based on ending time of meeting , if ending time is same then index with lower value will come first.
        Comparator<Meeting> meetingComparator = (c1 , c2)-> {
            if(c1.end > c2.end) return 1;
            else if (c1.end < c2.end) return -1;
            else if(c1.index > c2.index) return 1;
            else return -1;

        };

        int index = 0;

        //Adding meeting details to list to sort them in ascending order of end time
        List<Meeting>  meetings = new ArrayList<>(n);
        while(index < n){
            meetings.add(new Meeting(start[index],end[index],index));
            index++;
        }

        //Soring meeting based on ascending order of end in order to accommodate  maximum meeting
        Collections.sort(meetings,meetingComparator);

        //List to add start meeting timing
        List<Integer> startMeet = new ArrayList<>();
        startMeet.add(meetings.get(0).start);

        //Var to track when prev meeting is completing.
        int prevMeetiingEndTime = meetings.get(0).end;

        index = 1;
        while(index < n){
            //If prev meeting is already running , move to next meeting.
            if(meetings.get(index).start < prevMeetiingEndTime) {
                index++;
                continue;
            }

            //Prev meeting is completed, next meeting can be started.
            startMeet.add(meetings.get(index).start);
            prevMeetiingEndTime = meetings.get(index).end;
            index++;
        }
        System.out.println(startMeet);
        return startMeet.size();




    }



    static class Meeting {
        int start;
        int end;

        int index;

        public Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    ", index=" + index +
                    '}';
        }
    }
}
