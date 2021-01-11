class Solution {
    public int[] solution(int[] prices) {
        int time =0;
        int pl = prices.length;
        int[] answer = new int[pl];
        for(int i =0; i<pl; i++){
            for(int j=i+1; j<pl; j++){
                if(prices[i] <= prices[j]) //가격이 떨어지지 않으면
                    time++;
                else { //가격이 떨어지면
                    time++;
                    break;
                }
            } 
            answer[i]=time; 
            time =0;
        }
        return answer;
    }
}