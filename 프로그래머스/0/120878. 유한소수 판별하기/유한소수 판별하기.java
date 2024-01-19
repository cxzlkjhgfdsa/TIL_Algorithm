class Solution {
    public int solution(int a, int b) {
        int answer = 1;

        int[] bPrime = new int[1001];
        
        b = b / gcd(a, b);

        while(true){
                       
            if(b % 2 == 0){
                b /= 2;
            }else if(b % 5 == 0){
                b /= 5;
            }else{
                break;
            }
        }
        
        if(b != 1)
            answer = 2;
        
        return answer;
    }
    
    public int gcd(int a, int b){
        while(a != 0){
            int r = b%a;
            b = a;
            a = r;
        }
        return b;
    }
    
    public void prime(int n , int[] arr){
        
        while(n > 1){
            
            for(int i = 2; i <= n; i++){
                if(n % i == 0){
                    n /= i;
                    arr[i]++;
                }
            }
            
        }
        
    }
}