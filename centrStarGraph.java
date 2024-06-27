import java.io.*;
import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }else {
            return edges[0][1];
        }
    }
}

class centrStarGraph{

    public static void main(String args[]){
        int[][]  e1 = {{1,2},{2,3},{4,2}};
        int[][] e2 = {{1,2},{5,1},{1,3},{1,4}};
        Solution a = new Solution();
        System.out.println("centre of E1 STARGRAPH:"+ a.findCenter(e1));
        System.out.println("centre of E2 STARGRAPH:"+ a.findCenter(e2));

    } 
}