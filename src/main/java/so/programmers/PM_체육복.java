package so.programmers;

import java.util.Arrays;

public class PM_체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int lozer = lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lozer; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = 31;
                    reserve[j] = 31;
                    count++;
                }
            }
        }

        for(int i=0; i<lozer; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                    lost[i] = 31;
                    reserve[j] = 31;
                    count ++;
                }
            }
        }

        return n - lozer + count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }
}
