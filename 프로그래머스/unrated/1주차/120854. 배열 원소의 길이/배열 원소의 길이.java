class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        
        for(int i = 0; i < strlist.length; i++){
            answer[i] = strlist[i].length();  // 문자열의 길이를 담음
        }
        return answer;
    }
}