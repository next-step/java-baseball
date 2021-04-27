package home.work.baseball;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Player {
	
	private String name;
	private List<Integer> nums;
	private boolean cpu;

	public Answer question(List<Integer> tryNums) {
		if (tryNums == null) throw new IllegalArgumentException("질문한 숫자가 없습니다."); 
		if (tryNums.size() != this.nums.size()) throw new IllegalArgumentException("질문한 숫자 개수가 잘못됐습니다."); 
		int numLength = tryNums.size();
		Answer answer = new Answer();
		for (int i = 0; i < numLength; i++) {
			this.check(i, tryNums.get(i), answer);
		}
		return answer;
	}
	
	private void check(int idx, int num, Answer answer) {
		if (! this.nums.contains(num)) return;
		if (this.nums.get(idx) == num) {
			answer.increaseStrike();
			return;
		}
		answer.increaseBall();
	}
	
}
