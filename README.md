# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 상대방(컴퓨터)의 정답 설정
* 사용자 정답 입력
  * 입력된 값에 중복된 숫자가 없는지 확인
  * 입력된 값이 3자리 숫자인지 확인
* 사용자 입력값이 정답인지 확인
  * 사용자가 입력한 값이 상대방(컴퓨터)의 정답 목록에 존재하는 경우
    * 사용자 입력값의 위치(Index)가 상대방(컴퓨터)의 정답 위치(Index)가 일치하면 Strike
    * 사용자 입력값의 위치(Index)가 상대방(컴퓨터)의 정답 위치(Index)가 일치하지 않으면 Ball
  * 사용자의 입력값과 상대방(컴퓨터)의 정답에 대한 일치여부(Strike, Ball) 화면 출력
  * Strike 갯수가 3이면 게임 종료
* 야구 게임을 계속 진행할 것인지 선택
  * Strike 갯수가 3일 때 게임을 계속 진행할 것인지 선택
  * 입력값이 1인 경우 첫번째 기능(상대방의 정답 설정)부터 다시 시작
  * 입력값이 2인 경우 게임 종료(프로그램 종료)