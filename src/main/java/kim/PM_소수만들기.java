package kim;


public class PM_소수만들기 {

    static boolean isPrime(int num){
        if(num <= 1) return false;

        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    static int solution(int[] nums){
        int answer = 0;

        for(int i= 0; i < nums.length -2; i++){
           for(int j = i + 1 ; j < nums.length-1; j++){
               for(int z = j + 1; z < nums.length; z++){
                   int sum = nums[i] + nums[j] + nums[z];
                   if (isPrime(sum)) answer++;
               }
           }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(solution(nums));
    }
}
