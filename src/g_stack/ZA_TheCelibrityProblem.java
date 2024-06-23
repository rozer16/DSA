package g_stack;


/*
* https://youtu.be/Z5AEc12ieOs?list=PLDdcY4olLQk1bZS0OOFLAysk6keprt00U
*
In a party of N people, only one person is known to everyone. Such a person may be present at the party,.
 if yes, (s)he doesn’t know anyone at the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, and false otherwise. How can we solve the problem?

Examples:

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0}
         }


Output: id = 2
Explanation: The person with ID 2 does not know anyone but everyone knows him

Input:
MATRIX = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0}
         }

Output: No celebrity
Explanation: There is no celebrity.
*
*
* */
public class ZA_TheCelibrityProblem {

    /*
    * Bruteforce approach
    * TC : O(n^2)
    * SC : O(1)
    * */

    public static void main(String[] args) {
            ZA_TheCelibrityProblem test = new ZA_TheCelibrityProblem();
            int [][] MATRIX = {
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 0}
            };
            System.out.println(test.getCelebrity(MATRIX)); //2


        int [][] MATRIX1 = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(test.getCelebrity(MATRIX1)); //-1
    }
    public int getCelebrity(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[j][i] == 0){
                    if(i != j){
                        flag=false;
                        break;
                    }
                }

            }
            if(flag){
                for (int j = 0; j < matrix.length; j++) {
                    if(matrix[i][j] == 1){
                        flag = false;
                        break;
                    }

                }
                if(flag)
                    return i;
            }


        }
        return -1;
    }
}
