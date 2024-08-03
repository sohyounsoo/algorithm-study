package so;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class call {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(scanner.nextLine()); // 송수신 기록의 수
        System.out.println(n);
        String[] logs = new String[n]; // 송수신 기록
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine().trim();
        }

        List<String> summary = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (logs[i].equals(logs[i - 1])) {
                count++;
            } else {
                if (count > 1) {
                    summary.add(logs[i - 1] + " (" + count + ")");
                } else {
                    summary.add(logs[i - 1]);
                }
                count = 1;
            }
        }

        // 마지막 기록 처리
         if (count > 1) {
         		summary.add(logs[n - 1] + " (" + count + ")");
         } else {
         		summary.add(logs[n - 1]);
         }

        // 결과 출력
        System.out.print(summary.size());
        for (String record : summary) {
            System.out.println(record);
        }
    }
}
