# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
- BallCount Class
  - 멤버변수
    - private int strike: 스트라이크 수
    - private int ball: 볼 수
  - 메소드
    - public BallCount(): 디폴트 생성자
    - public BallCount(int strike, int ball): strike, ball을 파라미터로 전달받는 생성자
    - public void setStrike(int strike): strike 멤버 변수의 setter
    - public int getStrike(): strike 멤버 변수의 getter
    - public void setBall(int ball): ball 멤버 변수의 setter
    - public int getBall(): : ball 멤버 변수의 getter
    - public void add(BallCount ballCount): BallCount 인스턴스를 파라미터로 받아 스트라이크, 볼 수를 더함
- Baseball Class 
  - 멤버변수
    - List<Integer> answerNumbers: 정답 숫자 리스트
  - 메소드
    - public void Baseball(): 생성자, 1부터 9까지 서로 다른 임의의 수 3개를 생성하고 BallCount를 리셋
    - private void makeUniqueAnswerNumber(): 다른 숫자와 겹치지 않는 정답 숫자 1개를 생성
    - void setAnswerNumbers(List<Integer> value): 정답을 임의로 설정 (default 제한자로 동일 페키지 내에서만 허용, For Test)
    - public boolean checkAnswer(List<Integer> numbers): 세자리 수를 입력받아 정답과 비교하여 스트라이크와 볼 개수를 출력
    - private BallCount getBallCountFromNumber(int number, int idx): 숫자와 인덱스를 입력받아 스트라이크, 볼을 판정하여 생성한 BallCount 인스턴스를 리턴
    - public void printBallCount(): 현재 BallCount를 System.out으로 출력
    - public static void main(String[] args): 숫자야구게임 대화영 입/출력
- Utils Class
  - public static List<Integer> stringToIntegerListWithDelimiter(String input): delimiter 가 포함된 String 형태의 숫자를 입력받아 Integer List 로 변환하여 리턴 (default delimiter: ",")
  - public static List<Integer> stringToIntegerListWithDelimiter(String input, String delimiter) delimiter가 포함된 String 형태의 숫자를 입력받아 Integer List 로 변환하여 리턴

