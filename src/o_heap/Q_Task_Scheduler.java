package o_heap;


import java.util.Arrays;

/*
https://leetcode.com/problems/task-scheduler/description/



Intuition
The blocker by intuition should be the tasks with maximum frequency.(Greedy approach)

Approach
We calculate the max freq and subsequent required no of slots for it.
NOW THERE ARE ONLY 2 CASES (why does the greedy work?) :

Firstly the max frequency elements are placed with the minimum slots in between -we will call this 'SET'

The 2 cases:

Either the slots are more than(or equal to) the total number of tasks left and in that case they can be well accommodated within the current SET,why?
as even if the other tasks frequency is equal to the max frequency they can be adjusted in the SET with an offest

 eg: [A,A,A,B,B,B,C],N=2
 1st arngmnt  A_ _ A _ _A
 2nd          AB_AB_AB  (B added with offset position of 1)
 3rd          ABCAB_AB (Even if C's freq=3 =max its fine)
When the no of slots is lesser than the tasks left then first arrange whatever tasks you can in the current slots and then think of placing the left out tasks (with frequency lesser than max) next to each element of max frequency task and they too will also have the minimum gap between them
eg: [A,A,B,C,D],N=2
1st arngmnt A_ _A
2nd AB_A
3rd ACBA
4th ADCBA

Hence we can conclude the total no of cycles is either equal to number of total tasks or total tasks + no of slots left after placing tasks(when the no of slots is more)

Complexity
Time complexity:
O(n)
Space complexity:
O(26)
* */
public class Q_Task_Scheduler {

    public static void main(String[] args) {
        char c[] = {'A','A','A','B','B','B'};

        Q_Task_Scheduler sol = new Q_Task_Scheduler();
        System.out.println(sol.leastInterval(c, 2)); //8
    }
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char task : tasks)
            freq[task-'A']++;

        Arrays.sort(freq);

        int intervals =  freq[25] -1;
        int idleSpots = intervals * n;

        for(int i = 24; i>=0; i--)
            idleSpots -= Math.min(freq[i], intervals);


        return idleSpots < 0 ? tasks.length : tasks.length +  idleSpots;
    }
}
