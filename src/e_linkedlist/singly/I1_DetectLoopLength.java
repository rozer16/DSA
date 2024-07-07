package e_linkedlist.singly;

//https://leetcode.com/problems/linked-list-cycle-ii/submissions/957907149/
public class I1_DetectLoopLength {

    public int detectLoopLength(Node head){

        Node sp = head;
        Node fp = head;
        Node entry = head;


        while(fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;

            if(sp == fp){
                int counter = 1;
                Node temp = sp.next;
                while(temp != sp){
                    temp = temp.next;
                    counter++;
                }
                return counter;
            }
        }


        return 0;
    }
}
