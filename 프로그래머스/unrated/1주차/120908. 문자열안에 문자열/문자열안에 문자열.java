class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        
        for(int i = 0; i <= str1.length() - str2.length(); i++){
            if(str1.substring(i, i+str2.length()).equals(str2)) // str2 길이만큼 문자열 잘라서 비교
                answer = 1;
        }
        
        return answer;
    }
}