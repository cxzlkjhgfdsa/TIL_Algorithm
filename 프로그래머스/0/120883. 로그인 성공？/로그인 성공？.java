class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        for(String[] next : db){
            if(id_pw[0].equals(next[0]))
                if(id_pw[1].equals(next[1]))
                    answer = "login";
                else
                    answer = "wrong pw";
        }
        
        return answer;
    }
}