import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);  // 오름차순 정렬
        return sides[0] + sides[1] > sides[2] ? 1 : 2;  //  가장큰수는 배열 마지막에있음 
    }
}