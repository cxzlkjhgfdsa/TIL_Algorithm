import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length/2;
        
        Set<Integer> pokemon = new TreeSet<Integer>();
        for(int n : nums){
            pokemon.add(n);
        }
        
        if(pokemon.size() >= size){
            answer = size;
        }else{
            answer = pokemon.size();
        }
        
        return answer;
    }
}