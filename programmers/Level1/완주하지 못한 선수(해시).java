import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

		HashMap<Object, Object> map = new HashMap<>();

		for (String part : participant) {
			if (map.containsKey(part)) {
				map.put(part, (int)(map.get(part))+1);
			} else {
				map.put(part, 1);
			}
		}

		for (String comp : completion) {
			map.put(comp, (int)(map.get(comp))-1);		
		}
		
		for(String part : participant) {
			if((int)map.get(part) != 0)
				answer = part;
		}
		return answer;
    }
}