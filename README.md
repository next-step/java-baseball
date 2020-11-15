# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항 정의
* 1~9까지 서로 다른 수로 이루어진 임의의 3자리 수를 상대방(컴퓨터)이 생성한다.
    * 상대방이 생성한 수가 서로 다른 수로 이루어진 3자리 인지 확인 필요
* 게임 플레이어로부터 컴퓨터가 생각하고 있을 것 같은 3자리 숫자를 입력받는다.
    * 게임 플레이어가 입력한 숫자가 1~9까지의 3자리 숫자인지 확인 필요
* 3개의 숫자를 맞추는 게임을 수행하고, 3개의 숫자가 모두 맞은 경우에는 종료 또는 재시작을 할 수 있다.
    * 3개의 숫자를 모두 맞출 때까지 입력과 확인을 반복
    * 게임 종료 여부를 입력 받고, 입력에 맞는 결과를 수행