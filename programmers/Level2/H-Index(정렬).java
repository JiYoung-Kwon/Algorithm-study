class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = 0;
        int min = 0;
        // �迭 �� �ִ�, �ּҰ�
        for(int i=0; i<citations.length; i++)
        {
            if(citations[i] > max)
                max = citations[i];
            else if(citations[i] < min)
                min = citations[i];
        }
        
        // H-Index ���ϱ�
        for(int i= min; i<=max; i++){ //min ~ max����
            int quotation = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= i) //i�� �̻� �ο�� �� ����
                    quotation++;
            }
            if(quotation >= i) //i�� �̻� �ο�� ���� i�� �̻��� ���
                if(i >= answer) //�ִ� ����
                    answer = i;
        }
        return answer;
    }
}