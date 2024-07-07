package d_string;

public class PerformStringShifts {
    public static void main(String[] args) {
        String str = "abcdefg";
        int arr [][] = {{1,1},{1,1},{0,2},{1,3}};
        PerformStringShifts sol = new PerformStringShifts();
        System.out.println(sol.shift(str,arr)) ;  //abc cab bca
    }

    public String shift(String str, int [][] arr){
        int leftShift = 0;
        int rightShift = 0;
        for(int [] arr2 : arr){
            if(arr2[0] == 0)
                leftShift += arr2[1];
            else
                rightShift += arr2[1];
        }

        if(leftShift > rightShift) {
            return leftShift(str, leftShift - rightShift);
        }else if (leftShift < rightShift) {
            return rightShift(str, rightShift - leftShift);
        }else
            return str;
    }

    public String rightShift(String str, int shift){
        if(shift > str.length())
            shift = shift%str.length();

        if(shift  == str.length() )
                return str;

        str = reverse(str,0, str.length()-1);
        str = reverse(str, 0, shift-1);
       str = reverse(str, shift, str.length()-1);

        return str;
    }

    public String leftShift(String str, int shift){

        if(shift  == str.length() )
            return str;
        str = reverse(str, 0, str.length()-1);
        str = reverse(str, 0, str.length()-shift-1);
        str = reverse(str,str.length()-shift, str.length()-1);
        return str;
    }


    public String reverse(String str, int startIndex, int endIndex){
        char [] chars = str.toCharArray();
        while(startIndex < endIndex){
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return new String(chars);
    }
}
