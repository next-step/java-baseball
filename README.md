# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
|Scope|기능 제목|기능 상세 설명|
|---|---|---|
|playground|starts new game|새 게임을 시작한다. (새 게임은 이전 게임의 상태를 초기화한다.)|
|util|generates random number|1부터 9까지의 서로 다른 임의의 숫자 3개를 생성한다.|
|game|sets computer's number|해당 숫자를 컴퓨터의 숫자로 설정한다.|
|ui|enters number from player|플레이어로부터 서로 다른 3개의 숫자를 입력받는다.|
|game|sets player's number|해당 숫자를 플레이어의 숫자로 설정한다.|
|game|plays game and calculate score|게임을 진행(컴퓨터의 숫자를 플레이어의 숫자와 비교)하여 점수를 계산한다.|
|ui|prints game score|게임의 점수를 출력한다.|
|game|judges whether to win the game|게임 승리 여부를 판단한다.|
|ui|prints victory of the game|게임 승리 문구를 출력한다.|
|playground|restarts game keeping computer's number|(패배한 경우에) 컴퓨터의 숫자를 유지한 채로 다시 게임을 시작한다.|
|ui|enters whether to start new game|(승리한 경우에) 새 게임을 시작할 지 여부를 입력받는다.|
|playground|decides whether to start new game|입력 결과를 통해 새 게임을 시작할 지 판단한다.|
|playground|exits the game completely|게임을 완전히 종료한다.|