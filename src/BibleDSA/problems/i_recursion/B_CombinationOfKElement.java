package BibleDSA.problems.i_recursion;

public class B_CombinationOfKElement {

    public int combination(int n,int k){
        if(k == 0 || k==n)
            return n;
        return combination(n-1,k)+combination(n-1,k-1);
    }

    public static void main(String[] args) {
        B_CombinationOfKElement test = new B_CombinationOfKElement();
        System.out.println(test.combination(5,2));
    }
}
