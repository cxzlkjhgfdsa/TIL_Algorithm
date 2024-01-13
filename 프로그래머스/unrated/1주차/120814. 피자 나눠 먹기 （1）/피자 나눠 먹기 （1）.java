class Solution {
    public int solution(int n) {
        
        return n%7 == 0 ? n/7 : n/7+1; // 7로 나눠떨어진다면 묷 , 나눠떨어지지 않는다면 묷 + 1
    }
}