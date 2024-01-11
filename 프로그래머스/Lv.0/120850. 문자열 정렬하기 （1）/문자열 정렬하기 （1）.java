import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < my_string.length(); i++){
            int k = my_string.charAt(i) - '0';  // 숫자임을 판별
            if(k <= 9){  // 숫자라면 리스트에 추가 
                list.add(k);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);  // 오름차순 정렬
        return answer;
    }
}