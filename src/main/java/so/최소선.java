package so;

public class 최소선 {
    public static void main(String[] args) {
        int[] dots1 = {1, 5, 8};
        int[] lines1 = {1, 3, 4, 6};
        System.out.println("기댓값: 2");
        System.out.println("solution1= " + solution(dots1, lines1)); // 예시 1: 2
        System.out.println("solution2= " + solution2(dots1, lines1)); // 예시 1: 2
        System.out.println("solution3= " + solution3(dots1, lines1));
        System.out.println();

        int[] dots2 = {1, 3, 4, 6, 7, 10};
        int[] lines2 = {2, 2, 2, 2};
        System.out.println("기댓값: 4");
        System.out.println("solution1= " + solution(dots2, lines2)); // 예시 2: 4
        System.out.println("solution2= " + solution2(dots2, lines2)); // 예시 2: 4
        System.out.println("solution3= " + solution3(dots2, lines2));
        System.out.println();

        int[] dots3 = {1, 5, 10};
        int[] lines3 = {1, 9};
        System.out.println("기댓값: 1");
        System.out.println("solution1= " + solution(dots3, lines3));
        System.out.println("solution2= " + solution2(dots3, lines3));
        System.out.println("solution3= " + solution3(dots3, lines3));
        System.out.println();

        int[] dots4 = {1, 8, 9, 11};
        int[] lines4 = {3};
        System.out.println("기댓값: -1");
        System.out.println("solution1= " + solution(dots4, lines4));
        System.out.println("solution2= " + solution2(dots4, lines4));
        System.out.println("solution3= " + solution3(dots4, lines4));
        System.out.println();

        int[] dots5 = {1, 3, 7, 10};
        int[] lines5 = {2, 3};
        System.out.println("기댓값: 2");
        System.out.println("solution1= " + solution(dots5, lines5));
        System.out.println("solution2= " + solution2(dots5, lines5));
        System.out.println("solution3= " + solution3(dots5, lines5));
    }

    public static int solution(int[] dots, int[] lines) {
        int count = 0; // 사용한 선분의 개수를 저장합니다.
        int dotIdx = 0; // 현재 덮을 점의 인덱스입니다.
        int dotLen = dots.length; // 점의 개수입니다.
        int lineLen = lines.length; // 선분의 개수입니다

        // 점을 모두 커버할 때까지 반복합니다.
        while (dotIdx < dotLen) {
            int currDot = dots[dotIdx]; // 현재 덮을 점의 위치입니다.
            boolean covered = false;

            // 가장 긴 선분부터 시도하여 현재 점을 덮을 수 있는 선분을 찾습니다.
            for (int i = lineLen - 1; i >= 0; i--) {
                int maxCover = currDot + lines[i] - 1; // 현재 선분으로 덮을 수 있는 최대 범위입니다.

                // 현재 선분으로 덮을 수 있는 점들 건너뜁니다.
                int tempDotIdx = dotIdx;
                while (tempDotIdx < dotLen && dots[tempDotIdx] <= maxCover) {
                    tempDotIdx++;
                }

                // 현재 점을 덮을 수 있는 선분을 찾은 경우
                if (tempDotIdx > dotIdx) {
                    count++; // 사용한 선분의 개수를 증가시킵니다.
                    dotIdx = tempDotIdx; // 다음 점으로 이동합니다.
                    covered = true;
                    break; // 더 이상 다른 선분을 검사할 필요가 없습니다.
                }
            }

            // 현재 점을 덮을 수 있는 선분을 찾지 못한 경우
            if (!covered) {
                return -1;
            }
        }

        return count;
    }

    public static int solution2(int[] dots, int[] lines) {
        int count = 0;
        int dotIdx = 0;
        int dotLen = dots.length;
        int lineLen = lines.length -1;


        // 점을 모두 커버할 때까지 반복
        while (dotIdx < dotLen) {
            int currDot = dots[dotIdx];
            int maxCover = currDot + lines[lineLen]; // 현재 점에서 커버할 수 있는 최대 범위

            // 현재 점을 커버할 수 있는 가장 짧은 선분을 찾음
//            int minLineIdx = lineLen - 1;
//            for (int i = lineLen - 1; i >= 0; i--) {
//                if (currDot - lines[i] <= 0) {
//                    minLineIdx = i;
//                } else {
//                    break;
//                }
//            }

            count++; // 사용한 선분 개수 증가
            dotIdx++; // 다음 점으로 이동

            // 다음 점부터 커버 가능한 범위에 속하지 않는 점들을 건너뜁니다.
            while (dotIdx < dotLen && dots[dotIdx] <= maxCover) {
                dotIdx++;
            }
        }

        // 모든 점을 커버할 수 없는 경우
        if (dotIdx < dotLen || count > lineLen) {
            return -1;
        }

        return count;
    }

    public static int solution3(int[] dots, int[] lines) {
        int minCount = backtrack(dots, lines, 0, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private static int backtrack(int[] dots, int[] lines, int dotIndex, int count) {
        if (dotIndex >= dots.length) {
            return count; // 모든 점을 덮었으면 현재 사용한 선분의 개수를 반환합니다.
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < lines.length; i++) {
            int coverLength = dots[dotIndex] + lines[i] - 1; // 현재 선분으로 덮을 수 있는 최대 범위

            int nextDotIndex = dotIndex;
            while (nextDotIndex < dots.length && dots[nextDotIndex] <= coverLength) {
                nextDotIndex++; // 현재 선분으로 덮을 수 있는 점의 개수 계산
            }

            if (nextDotIndex > dotIndex) { // 유효한 덮음
                minCount = Math.min(minCount, backtrack(dots, lines, nextDotIndex, count + 1));
            }
        }

        return minCount;
    }
}
