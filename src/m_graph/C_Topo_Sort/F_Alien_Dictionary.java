package m_graph.C_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F_Alien_Dictionary {

    public static void main(String[] args) {
        String [] dictionary = {"baa", "abcd", "abca", "cab", "cad"};
         //b -> d ->  a -> c
        System.out.println(getAlienLanguage(dictionary,5,4)); // bdac
    }

    public static String getAlienLanguage(String []dictionary, int N, int k) {



        //1. Create Adj list

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int i = 0; i < N-1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];
            int len = Math.min(s1.length(),s2.length());

            for (int j = 0; j < len; j++) {
                if(s1.charAt(j) != s2.charAt(j)){
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        List<Integer> topoSort = getTopoSort(k,adjList);
        StringBuilder result = new StringBuilder();
        for (int i : topoSort){
            result.append((char)('a' + i));
        }

        //This is success case and this code will not work in case of below scenario
        //1 : when l1 is length of str1 and l2 is length of str2 and l1 < l2 and first l1 characters of both string are same(i.e. str1 = abc, str2 = abcd)
        //2 : when there is a cyclic dependency
        return result.toString();
    }

    private static List<Integer> getTopoSort(int k, List<List<Integer>> adjList) {
        List<Integer> topoSort = new ArrayList<>();
        int [] indegree = new int[k];

        for (int i = 0; i < k; i++) {
            for(int node : adjList.get(i)){
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }


        while(!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);

            for(int neighNode : adjList.get(node)){
                indegree[neighNode]--;
                if(indegree[neighNode] == 0)
                    queue.offer(neighNode);
            }
        }

        return topoSort;
    }
}
