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
				System.out.print("숫자를 입력해주세요.: ");
				String input  = scanner.next();
				char[] inputArr = input.toCharArray();
			
				correct = checkAns(inputArr, ansArr);
			}
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			int startQuit = scanner.nextInt();
			
			if(startQuit == 1) {
				correct = false;
			}
			else{
				scanner.close();
				setGame = false;
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

	public static boolean checkAns(char[] inputArr, char[] ansArr) { //3개의 입력과 3개의 답 비교
		int[][] hint = new int[3][2];
		int ball = 0;
		int strike = 0;
		
		for(int i = 0; i < ansArr.length; i++)  {
			hint[i] = checkNum(inputArr, ansArr[i], i);
			if(hint[i][0] == 1) {
				strike+=1;
			}
			else if(hint[i][1] == 1) {
				ball+=1;
			}
		}
		
		if(ball > 0) {
			System.out.print(ball + "볼 ");
		}
		if(strike > 0) {
			System.out.print(strike + "스트라이크");
		}
		if(ball == 0 & strike == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
		
		if(strike == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int[] checkNum(char[] inputArr, char ansChar, int ansIndex ) { //정답의 하나를 3개의 입력과 비교
		int[] strikeBall = new int[2];
		for(int i = 0; i < inputArr.length; i++) {
			if(i == ansIndex && inputArr[i] == ansChar) {
				strikeBall[0] = 1;
			}
			else if(i != ansIndex && inputArr[i] == ansChar) {
				strikeBall[1] = 1;
			}
		}
		
		return strikeBall;
	}
}
