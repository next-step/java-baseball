# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
** UI
* 숫자 입력 요청을 노출하고 숫자를 입력받는다.
* 3 스트라이크면 종료할지 여부를 위한 입력값을 요청하고 값을 입력 받는다.

** 숫자 만들기
* 각 실행 마다 랜덤한 서로 다른 세자리 수를 만든다.
* 만들어진 수가 바로 직전에 사용한 수와 동일하면 다시 만든다.(추가 룰)

** 입력 값 벨리데이션
* 입력 값이 세자리인지 판단한다.
* 입력 값이 숫자로 이루어져 있는지 판단한다.
* 입력 값에 0이 포함되어 있는지 판단한다.

** 로직 처리
* 입력 받은 수와 랜덤한 숫자를 비교하여 스트라이크의 개수를 센다.
* 입력 받은 수와 랜덤한 숫자를 비교하여 볼의 개수를 센다.
* 스트라이크와 볼이 없으면 아웃으로 판단한다.
