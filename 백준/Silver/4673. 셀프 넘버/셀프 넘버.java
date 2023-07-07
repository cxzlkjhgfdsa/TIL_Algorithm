public class Main {

    static boolean[] selfNum;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        selfNum = new boolean[10001];
        for(int i=1; i<=10000; i++){
            checkSelfNum(i);
        }

        for(int i=1; i<=10000; i++){
            if(!selfNum[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);


    }

    static void checkSelfNum(int n){
        String s = "";
        s+=n;

        int size = s.length();
        int sum = n;

        for(int i=0 ;i<size; i++){
            sum += s.charAt(i) - '0';
        }

        if(sum > 10000){
            return;
        }
        selfNum[sum] = true;
    }
}
