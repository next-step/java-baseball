# 숫자 야구 게임

## **진행 방법**
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## **과제 제출 과정**
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## **구현 기능 목록**
  - 게임의 전체 횟수에 따라 제어한다.
  - 게임이 시작되면 1~9에 해당되고 서로 다른 3개의 수를 랜덤으로 뽑는다.
  - 사용자가 입력한 수가 3자리인지 검증해야 한다.
  - 정답(random값) 수의 위치와 사용자가 입력한 수의 위치가 같은 경우, 스트라이크 횟수로 매긴다.
  - 3개의 수 모두 스트라이크인 경우, 정답을 맞춘 것이므로 게임을 끝낸다.
  - 스트라이크에 해당되는 수를 제외한 수가 정답 수에 포함되는 경우, 볼 횟수로 매긴다.
  - 스트라이크/볼이 0이 아닌 경우, 각각 그 횟수와 스트라이크/볼 문자를 붙인다.
  - 스트라이크 수와 볼 수가 모두 0인 경우, 낫싱을 출력한다.
  - 게임이 끝난 후, 명령어가 1일 경우에는 재개하고 2일 경우에는 끝낸다.