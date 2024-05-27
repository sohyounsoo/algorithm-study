package kim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PM_로또의최고순위와최저순위 {


    static int lotto_rank(int count){
        switch (count){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    static List<Integer> solution(int[] lottos, int[] win_nums) {
        List<Integer> answer= new ArrayList<>();

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int remove_count = (int)Arrays.stream(lottos).filter(n-> n == 0).count();
        int collect_count = (int)Arrays.stream(lottos).filter(n->Arrays.binarySearch(win_nums,n) > -1).count();

        answer.add(0,lotto_rank(collect_count + remove_count)); answer.add(1,lotto_rank(collect_count));

        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(solution(lottos,win_nums));
    }
}
