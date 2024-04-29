package so.programmers;

public class PM_기사단원의무기 {

    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        int answer = solution(number, limit, power);
        System.out.println(answer);
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        int cnt = 0;
        int[] arr = new int[number];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                arr[i * j -1] += 1 ;
            }
        }

        for (int i: arr) {
            if(i > limit) answer += power;
            else answer += i;
        }



        return answer;

    }
}
