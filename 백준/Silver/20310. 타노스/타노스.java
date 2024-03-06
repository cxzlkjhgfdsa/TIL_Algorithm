import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.next().split("");
        ArrayList<String> list = new ArrayList<>();

        int zero = 0;
        int one = 0;

        for(String s : str){
            if(s.equals("0"))
                zero++;
            else
                one++;
            list.add(s);
        }

        zero /= 2;
        one /= 2;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("1")){
                list.remove(i);
                one--;
            }
            if(one == 0)
                break;
        }

        for(int i = list.size() -1; i>= 0; i--){
            if(list.get(i).equals("0")){
                list.remove(i);
                zero--;
            }
            if(zero == 0)
                break;
        }

        String ans ="";
        for(String next : list){
            ans+= next;
        }

        System.out.println(ans);


    }
}
