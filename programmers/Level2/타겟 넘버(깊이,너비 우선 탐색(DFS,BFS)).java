class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, numbers, 0, target);
        return answer;
    }

    public int dfs(int before, int[] numbers, int index, int target){

        //끝까지 다 돌았을 때 재귀 종료
        if(index == numbers.length){
            //값이 target과 동일하다면
            if(before == target){
                return 1;
            }
            return 0;
        }

        int answer = 0;
        int sum1, sum2;  

        //더하기, 빼기
        sum1 = before + numbers[index];
        sum2 = before - numbers[index];

        //각각의 덧셈/뺄셈 결과에 재귀
        answer = dfs(sum1, numbers, index+1, target);
        answer += dfs(sum2, numbers, index+1, target);

        return answer;
    }
}