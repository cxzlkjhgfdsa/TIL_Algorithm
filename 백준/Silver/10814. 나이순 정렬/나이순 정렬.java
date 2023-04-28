import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class User implements Comparable<User>{
        int idx, age;
        String name;
        public User(int idx, int age, String name){
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o){
            if(this.age == o.age)
                return this.idx - o.idx;
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] input;

        int N = Integer.parseInt(br.readLine());
        User[] users = new User[N];

        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            users[i] = new User(i, Integer.parseInt(input[0]), input[1]);

        }
        Arrays.sort(users);

        for(int i=0; i<N; i++){
            User u = users[i];
            sb.append(u.age).append(" ").append(u.name).append("\n");
        }

        System.out.println(sb);

    }
}
