package e_linkedlist.singly;

//https://leetcode.com/problems/linked-list-cycle-ii/submissions/957907149/
public class I_DetectLoopPoint {

    public Node detectLoopStartPoint(Node head){

        Node sp = head;
        Node fp = head;
        Node entry = head;


        while(fp != null && fp.next != null && fp.next.next != null){
            sp = sp.next;
            fp = fp.next.next;

            if(sp == fp){
                while(sp != entry){
                    sp = sp.next;
                    entry = entry.next;
                    return entry;
                }
            }
        }


        return null;
    }
}
