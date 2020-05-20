// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    int[] rep;
    int[] rank;
    private void makeSet(int size){
        rep = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++){
            rep[i]=i;
        }
    }
    
     private int find(int x){
        if(rep[x]!=x){
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }
    
    private boolean union(int x,int y){
        int repX = find(x);
        int repY = find(y);
        if(repX == repY){
            return false;
        }
        else if (rank[repX] < rank[repY]) {
            rep[repX] = repY;
        } 
        else if (rank[repY] < rank[repX]) {
            rep[repY] = repX;
        } 
        else {
            rep[repY] = repX;
            rank[repX]++;
        }
        return true;
    }
    
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(new int[]{0,i+1,wells[i]});
        }
        
        for(int[] pipe:pipes){
            edges.add(pipe);
        }
        
        Collections.sort(edges,(a,b)->a[2]-b[2]);
        makeSet(n+1);
        int cost=0;
        for(int[] edge: edges){
            if(union(edge[0],edge[1])){
                cost+=edge[2];
            }
        }
        return cost;
    }
}

