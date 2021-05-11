import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        //int -> string
        String[] numStr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            numStr[i] = String.valueOf(numbers[i]);
        }
        
        //정렬하기
        Arrays.sort(numStr, new Cp());
        
        //0으로만 이루어져 있는 경우 -> 0임
        if (numStr[0].equals("0")) return "0";
        
        //문자열로 합치기
        for(int i=0; i<numStr.length; i++){
            answer += numStr[i];
        }
        
        return answer;
    }
}

//정렬 기준 구현 Comparator
class Cp implements Comparator<String>{
    @Override
    public int compare(String st1, String st2){ 
        //610 106 큰 수가 더 앞에 나와야 함

        //o1 이 o2 보다 크면 양의 정수 반환
        //o1 이 o2 보다 작으면 음의 정수 반환
        //o1 이 o2 와 같으면 0 반환
        
        return (st1).compareTo(st2);
        
       // return (st2+st1).compareTo(st1+st2); 
    }
}