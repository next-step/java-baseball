# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
- Baseball class 구현
  - 멤버변수
    - List<Integer> answerNumbers: 정답 숫자 리스트
  - 메소드
    - public void makeAnswerNumbers(): 1부터 9까지 서로 다른 임의의 수 3개를 생성하는 메소드
    - private void makeUniqueAnswerNumber(): 다른 숫자와 겹치지 않는 정답 숫자 1개를 생성하는 메소드
    - public boolean checkAnswer(): 세자리 수를 입력받아 정답과 비교하여 스트라이크와 볼 개수를 출력하는 메소드
- Main Class
  - 대화형 입출력 기능 구현

