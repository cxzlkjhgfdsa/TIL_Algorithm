class Solution {
    public int solution(String before, String after) {
        
        int[] bf = new int[27];
        int[] af = new int[27];
        
        for(int i = 0; i < before.length(); i++){
            bf[before.charAt(i)-'a']++;
            af[after.charAt(i)-'a']++;
            // System.out.println("before == " + (before.charAt(i) - 'a'));
            // System.out.println("after == " + (after.charAt(i) - 'a'));
        }
        
        int answer = 1;
        
        for(int i = 0; i < 27; i++){
            if(bf[i] != af[i])
                answer = 0;
        }
        
        return answer;
    }
}