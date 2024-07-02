package g_stack;

public class P_1_Count_NGE {

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        int count=0;
        int index=0;
        int ans[]=new int[queries];
        for(int num:indices)
        {
            count=0;
            for(int j=num;j<arr.length;j++)
            {
                if(arr[num]<arr[j])
                {
                    count++;
                }
            }
            ans[index++]=count;
        }
        return ans;

    }
}
