import java.util.ArrayList;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean setGame = true;
		boolean correct = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while(setGame) {
			char[] ansArr = selectRandNum();
			//System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
			while(!correct) {
				System.out.println("숫자를 입력해주세요.: ");
				String input  = scanner.next();
				char[] inputArr = input.toCharArray();
			}
		}
	}
	
	public static char[] selectRandNum() { //3개의 랜덤 넘버 생성
		char[] ans = new char[3];
		ArrayList<Character> list = initList();
		for(int i = 0; i < 3; i++) {
			ans[i] = chooseANumber(list);
		}
		return ans;
	}
	
	public static ArrayList<Character> initList() { //랜덤 넘버 뽑기를 위한 1~9까지의 묶음
		ArrayList<Character> arr = new ArrayList<Character>();
		for(int i = 0; i < 9; i++) {
			arr.add(Character.forDigit(i+1, 10));
		}
		
		return arr;
	}
	
	public static char chooseANumber(ArrayList<Character> arr) { //묶음에서 랜덤으로 하나를 뽑고 묶음에 해당 수를 삭제
		int index = (int) (Math.random() * arr.size());
		char choice = arr.get(index);
		
		arr.remove(index);
		
		return choice;
	}

}
