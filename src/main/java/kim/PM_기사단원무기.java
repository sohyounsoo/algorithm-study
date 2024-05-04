package kim;

public class PM_기사단원무기 {

    static int solution(int number, int limit, int power){
        int answer = 0;

        for(int i = 1; i <= number ;i++){
            int decimal = (int) Math.sqrt(i);
            int count = 0;

            while(decimal >= 1){
                if(i % decimal == 0) {
                    if(decimal == i / decimal) count++;
                    else count += 2;
                }
                decimal--;
            }

            if (count > limit) answer += power;
            else answer += count;
        }
        return answer;
    }


    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power));

    }
}
