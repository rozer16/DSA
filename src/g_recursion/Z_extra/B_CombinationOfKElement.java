package g_recursion.Z_extra;

/*
 Problem : Given no of element find possible combination with k elements

 For e.g.

 Elements : 1,2,3
 k =2

 combinations
 1,2 1,3 2,3

*/

public class B_CombinationOfKElement {

    public int combination(int n,int k){
        if(k == 0 || k==n)
            return n;
        return combination(n-1,k)+combination(n-1,k-1);
    }

    public static void main(String[] args) {
        B_CombinationOfKElement test = new B_CombinationOfKElement();
        System.out.println(test.combination(3,2));
    }
}
