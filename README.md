# 숫자 야구 게임
## 게임 내용
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  * [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱

* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.
  * 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
  * 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.

* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 구현할 기능 목록

* 문제(Question) 객체
  * 1과 9 사이의 정수를 임의로 생성하는 메소드
  * N자리의 문제를 생성하는 메소드
  
* 정답(Answer) 객체

* 체점(Score) 객체
  * 문제와 정답 객체를 활용하여, 스트라이크를 세는 메소드
  * 문제와 정답 객체를 활용하여, 볼을 세는 메소드
  * 문제와 정답 객체를 활용하여, 결과 객체를 리턴하는 메소드

* 결과(Result) 객체

* 게임 실행(GameApplication) 객체
  * 게임 시작 전 세팅 메소드
  * 게임 시작 메소드
  * 게임 재시작 메소드
