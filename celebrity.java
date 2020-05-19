// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int possible=0;
        for(int i = 1 ; i<n;i++){
            if(knows(possible,i)){
                possible = i;
            }
        }
        for(int i=0;i<n;i++){
            if(i==possible) continue;
            if(knows(possible,i)) return -1;
            if(!knows(i,possible)) return -1;
        }
        return possible;
        
        
    }
}