package f_bitmanipulation;

public class B_SwapTwoNoWithoutUsingThirdVar {



    public static void main(String[] args) {
        B_SwapTwoNoWithoutUsingThirdVar test = new B_SwapTwoNoWithoutUsingThirdVar();
        test.swapTwoNosWithoutUsingThirdVar(3,5);
    }


    /*
     *
     * a = a^b
     * b = a^b
     * a = a^b
     *
     *
     * */
    private void swapTwoNosWithoutUsingThirdVar(int i, int i1) {
        i = i^i1;
        //i^i1^i1 ==> i
        i1 = i^i1;
        //i^i1^i ==> i1
        i = i^i1;
    }
}
