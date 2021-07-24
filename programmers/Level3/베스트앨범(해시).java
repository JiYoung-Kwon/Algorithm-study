import java.util.*;

class Solution {
	public ArrayList<Integer> solution(String[] genres, int[] plays) {

		ArrayList<Song> sList = new ArrayList<>(); // 모든 노래 리스트
		HashMap<String, Integer> total = new HashMap<>(); // 장르별 곡 재생 수
		ArrayList<Integer> answerList = new ArrayList<>(); //답
		
		for (int i = 0; i < genres.length; i++) {
			int index = i;
			int play = plays[i];
			String genre = genres[i];

			sList.add(new Song(index, play, genre)); //노래 리스트 추가

            //장르별 곡 재생 수 추가
			if (!total.containsKey(genre)) { //같은 장르가 없을 경우
				total.put(genre, play);
			} else { //같은 장르가 이미 존재할 경우
				total.put(genre, total.get(genre) + play);
			}
		}

        //내림차순 정렬(장르별 정렬 -> 곡 재생 수 별 정렬)
		Collections.sort(sList, new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				if (o1.genre.equals(o2.genre)) { // 같은 장르일 경우
					return o1.compareTo(o2); //재생 수 별 정렬
				}else { // 다른 장르일 경우, 총 재생 수가 높은 장르 순
					return total.get(o2.genre) - total.get(o1.genre);
				}
			}

		});
		
        //정렬된 장르별 중 곡 재생 수 top2(or 1) 뽑기
		int cnt = 1;
		for(int i = 0; i < sList.size(); i++) {
            
			if (i == 0) { //첫 번째는 무조건 포함
				answerList.add(sList.get(i).index);
				cnt++;
			} else { // 두 번째 부터
				if (!sList.get(i - 1).genre.equals(sList.get(i).genre)) { // 전 곡이랑 다른 장르일 경우
					answerList.add(sList.get(i).index);
					cnt=2;
				} else { // 전 곡이랑 같은 장르일 경우
					if (cnt <= 2) {
						answerList.add(sList.get(i).index);
						cnt++;
					} else {
						if (i + 1 != sList.size()) {
							if (!sList.get(i - 1).genre.equals(sList.get(i).genre)) {
								answerList.add(sList.get(i).index);
								cnt = 3;
							}
						}
					}
				}
			}
		}
		
		//System.out.println(answerList);
		return answerList;
	}
}


class Song {
	int index; //고유번호
	int play; //재생 횟수
	String genre; //장르

	Song(int index, int play, String genre) {
		this.index = index;
		this.play = play;
		this.genre = genre;
	}

    //같은 장르 내 정렬
	public int compareTo(Song o) {
		if (this.play == o.play) { //곡 재생 수가 같을 경우
			return this.index - o.index; //고유번호 낮은 순
		} else { //다를 경우
			return -(this.play - o.play); //재생 횟수 순
		}
	}

}