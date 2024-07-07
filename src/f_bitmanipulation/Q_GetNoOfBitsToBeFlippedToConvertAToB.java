package f_bitmanipulation;

public class Q_GetNoOfBitsToBeFlippedToConvertAToB {

    public static void main(String[] args) {
        int A = 11;
        int B = 3;
        System.out.println(A+"'s binary representation : "+Integer.toBinaryString(A));
        System.out.println(B+"'s binary representation : "+Integer.toBinaryString(B));
        Q_GetNoOfBitsToBeFlippedToConvertAToB test = new Q_GetNoOfBitsToBeFlippedToConvertAToB();
        System.out.println("No of bits required to be fliped to convert : "+A+" into "+B+" : "+test.getNoOfBitsToBeFlippedToConvertAToB(A,B));
    }

    public int getNoOfBitsToBeFlippedToConvertAToB(int A,int B){
        int x = A^B;
        int count = 0;
        while(x>0){
            if((x&1) > 0)
                count++;
            x = x>>1;

        }
        return count;
    }
}
