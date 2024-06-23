package z_hackerrank;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

 public class JumpingCloud {

    // Complete the jumpingOnClouds function below.
	 static long repeatedString(String s, long n) {
         
         int sLen = s.length();
         char [] sCharArray = s.toCharArray();
         int aOccurance = 0;
         for(int i = 0;i<sCharArray.length;i++){
             if(sCharArray[i] == 'a')
                     aOccurance++;
         }

         long totalCount =(n/sLen);
         BigDecimal bd = new BigDecimal(totalCount).setScale(0, RoundingMode.HALF_UP);
         totalCount = bd.longValue();
         totalCount *= aOccurance;
         long modulo = n % sLen;
         for(int i = 0;i<modulo;i++){
             if(sCharArray[i] == 'a')
                 totalCount++;
         }
         
         return totalCount;    
 }

   

    public static void main(String[] args) throws IOException {
       

        

        long result = repeatedString("cfimaakj",554045874191l);

       System.out.println(result);
    }
}
