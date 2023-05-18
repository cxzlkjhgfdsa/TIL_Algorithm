import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		int[] yoon = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] Nyoon = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 4;
		int total = 0;

		for (int i = 2019; i <= N; i++) {
			if (i % 4 == 0 && i % 100 != 0) {
				for (int j = 0; j < 12; j++) {
					while (true) {
						if (cnt == 13) {
							total++;
						}
						cnt += 7;
						if (cnt > yoon[j])
							break;
					}
					cnt = cnt - yoon[j];
				}

			} else if(i%400 !=0 && i%100==0){
				for (int j = 0; j < 12; j++) {
					while (true) {
						if (cnt == 13) {
							total++;
						}
						cnt += 7;
						if (cnt > Nyoon[j])
							break;
					}
					cnt = cnt - Nyoon[j];
				}

			} else if (i%400==0) {
				for (int j = 0; j < 12; j++) {
					while (true) {
						if (cnt == 13) {
							total++;
						}
						cnt += 7;
						if (cnt > yoon[j])
							break;
					}
					cnt = cnt - yoon[j];
				}

			}else {
				for (int j = 0; j < 12; j++) {
					while (true) {
						if (cnt == 13) {
							total++;
						}
						cnt += 7;
						if (cnt > Nyoon[j])
							break;
					}
					cnt = cnt - Nyoon[j];
				}
			}

		}
		System.out.println(total);

	}

}
