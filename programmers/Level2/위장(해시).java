import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 같은 종류인 의상 개수 저장 map
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        //각 행에 접근
        for (int i = 0; i < clothes.length; i++) {
            //map에 포함되어있는 종류가 아니면
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 2);
            }else { //이미 포함된 종류
                map.replace(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }

        //각 값에 접근
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String i = it.next();
            answer = answer * map.get(i);
        }
        //종류별 의상을 (어떤걸 입거나, 안입거나) - 모든 걸 안입는 경우     
        answer--;
        return answer;
    }
}