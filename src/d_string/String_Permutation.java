package d_string;



/*
*               A B C
*  A is fixed:  Swap A with A : ABC , Swap B with B: ABC , Swap B with C : ACB
*  B is fixed:  Swap A with B : BAC , Swap A with A: BAC, swap A with C : BCA
*  C is fixed:  Swap A with C : CAB , Swap A with A: CAB, swap A with B : CBA
*
*  ABC,ACB,BAC,BCA,CAB,CBA
* Complexity : O(N * N!)
*
* */
public class String_Permutation {

    public static void main(String[] args) {
        String str="ABCD";
        permutation(str,0,str.length()-1);
    }

    private static void permutation(String str, int left, int right) {

        if(left == right){
            System.out.println(str);
        }
            else{
            for (int i = left; i <= right; i++) {

                str = swap(str, left, i);
                permutation(str, left + 1, right);
                str = swap(str, left, i);
            }
            }
    }

    private static  String swap(String str,int i,int j){
        char [] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] =   chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
}
