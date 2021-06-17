class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 0;
        int height = 0;
        int all = brown + yellow;
        int cnt = 3;
        // brown은 8이상, yellow는 1이상이므로 전체 9(3x3)이상이어야 함
        // width, height는 총 격자 개수의 약수여야 함
        // width >= height여야 함
        
        for(; cnt <= all; cnt++){
            //약수일 경우
            if(all % cnt == 0){
                //큰 값을 width로
                int max = cnt;
                int min = all / cnt;
                
                if(max < min){
                    int temp = min;
                    min = max;
                    max = temp;
                }
                
                width = max;
                height = min;
                
                // 예시 : 4*3 이면, 4+4+3+3 - 4(모서리 중복) = 10(갈색), [4*3 - 갈색] = 노란색
                // 전체를 구할려면, 갈색은 a*2+b*2 - 4, a*b - 갈색이 노란색 -> 공식
                if((brown == width*2+height*2 - 4) && (yellow == width*height - brown)){
                    break;
                }
            }
        }        
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}