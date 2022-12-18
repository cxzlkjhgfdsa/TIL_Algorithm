import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_DNA비밀번호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input;
        input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);   // DNA 암호 길이
        int P = Integer.parseInt(input[1]);  // DNA 부분 암호 길이
        String DNA = br.readLine();   // DNA 암호문

        input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);  // 필요한 A의 개수
        int C = Integer.parseInt(input[1]);  // 필요한 C의 개수
        int G = Integer.parseInt(input[2]);  // 필요한 G의 개수
        int T = Integer.parseInt(input[3]);  // 필요한 T의 개수

        int ans = 0;   // 정답의 수

        String check = DNA.substring(0, P);   // 처음 탐색할 DNA부분 문자열
        int idxA =0;  // 부분문자열의 A 개수
        int idxC =0;  // 부분문자열의 A 개수
        int idxG =0;  // 부분문자열의 A 개수
        int idxT =0;  // 부분문자열의 A 개수
        for(int j=0; j<check.length(); j++){  // 문자열 탐색하면서 문자 개수 검색
            if(check.charAt(j)=='A'){
                idxA++;
            }else if(check.charAt(j)=='C'){
                idxC++;
            }else if(check.charAt(j)=='G'){
                idxG++;
            }else if(check.charAt(j)=='T'){
                idxT++;
            }
        }

        if(idxA>=A && idxC>=C && idxG >=G && idxT >=T){  // 조건을 만족하면 정답 +1
            ans++;
        }

        for(int i=0; i<=S-P-1; i++){   // 부분문자열을 오른쪽으로 1칸씩 밀면서 탐새갛면 맨위의 문자를 추가하고 맨 앞에 있던 문자을 빼주면 됨
            if(DNA.charAt(i)=='A'){
                idxA--;
            }else if(DNA.charAt(i)=='C'){
                idxC--;
            }else if(DNA.charAt(i)=='G'){
                idxG--;
            }else if(DNA.charAt(i)=='T'){
                idxT--;
            }

            if(DNA.charAt(i+P)=='A'){
                idxA++;
            }else if(DNA.charAt(i+P)=='C'){ 
                idxC++;
            }else if(DNA.charAt(i+P)=='G'){
                idxG++;
            }else if(DNA.charAt(i+P)=='T'){
                idxT++;
            }

            if(idxA>=A && idxC>=C && idxG >=G && idxT >=T){  // 조건에 맞으면 정답 +1
                ans++;
            }
        }
        System.out.println(ans);   // 정답 출력

    }
}
