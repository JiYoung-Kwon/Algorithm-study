class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 
        for(int i=0; i<commands.length; i++){ 
            int size = commands[i][1] - commands[i][0] + 1;          
            int[] sort = new int[size];

            for(int j=0; j<size; j++){
                sort[j] = array[j - 1 + commands[i][0]];
            }

            for(int m=0; m<size; m++){
                for(int n=1; n<size; n++){
                    if(sort[n-1]>sort[n]){
                        int tmp = sort[n];
                        sort[n] = sort[n-1];
                        sort[n-1] = tmp;
                    }
                }
            }
            answer[i] = sort[commands[i][2]-1]; 
        }    
    return answer;
    }
}