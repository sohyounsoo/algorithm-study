package so;

import java.util.Arrays;

public class 최소선2 {
    public int solution(int[] dots, int[] lines) {
        Arrays.sort(dots); // 점들을 오름차순으로 정렬합니다.
        Arrays.sort(lines); // 선분들을 오름차순으로 정렬합니다.

        int count = 0;
        int dotIdx = 0;
        int dotLen = dots.length;
        int lineLen = lines.length;

        while (dotIdx < dotLen) {
            boolean covered = false;
            for (int i = lineLen - 1; i >= 0; i--) {
                int maxCover = dots[dotIdx] + lines[i] - 1;

                int nextDotIdx = dotIdx;
                while (nextDotIdx < dotLen && dots[nextDotIdx] <= maxCover) {
                    nextDotIdx++;
                }

                if (nextDotIdx > dotIdx) {
                    dotIdx = nextDotIdx;
                    count++;
                    covered = true;
                    break;
                }
            }

            if (!covered) {
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        최소선2 sol = new 최소선2();

        int[] dots1 = {1, 5, 8};
        int[] lines1 = {1, 3, 4, 6};
        System.out.println(sol.solution(dots1, lines1)); // 예시 1: 2

        int[] dots2 = {1, 3, 4, 6, 7, 10};
        int[] lines2 = {2, 2, 2, 2};
        System.out.println(sol.solution(dots2, lines2)); // 예시 2: 4

        int[] dots3 = {1, 5, 10};
        int[] lines3 = {1, 9};
        System.out.println(sol.solution(dots3, lines3)); // 추가 예시: 1

        int[] dots4 = {1, 8, 9, 11};
        int[] lines4 = {3};
        System.out.println(sol.solution(dots4, lines4)); // 추가 예시: -1

        int[] dots5 = {1, 3, 7, 10};
        int[] lines5 = {2, 3};
        System.out.println(sol.solution(dots5, lines5)); // 추가 예시: 2
    }
}

