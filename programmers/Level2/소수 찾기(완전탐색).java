import java.util.*;

class Solution {
	HashSet<Integer> hs = new HashSet<>();

	public int solution(String numbers) {
		int answer = 0;
		String[] ex = numbers.split("");
		int[] number = new int[ex.length];

		for (int i = 0; i < ex.length; i++) {
			number[i] = Integer.parseInt(ex[i]);
			// System.out.print(number[i] + ",");
		}

		for (int i = 1; i <= number.length; i++) {
			for(int j=1; j<= number.length; j++)
				johab(number, 0, i, j);
		}

		//System.out.println(hs);

		// 소수 찾기
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			int num = (int) it.next();
			// 소수 판별
			boolean isSosu = false;

			for (int i = 2; i < num; i++) {
				if (num % i == 0) { // 나눠지면
					isSosu = false;
					break;
				} else
					isSosu = true;
			}

            if(num == 2)
				isSosu = true;
			
			if (isSosu)
				answer++;
			//System.out.println(num);
		}

		return answer;
	}

	// number를 가지고 조합짜기
	public void johab(int[] arr, int depth, int n, int k) {
		if (depth == k) { // 맨 밑까지 돌았을 경우
			// 조합 출력
			String temp = "";
			for (int i = 0; i < k; i++) {
				temp += arr[i];
			}
			int num = Integer.parseInt(temp);
			hs.add(num);
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			johab(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}

	}

	// 배열값 교환
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}