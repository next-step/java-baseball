# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

- 야구경기
    - [ ] 야구경기를 시작한다.
    - [ ] 판정 결과를 알린다.
    - [ ] 플레이어가 승리하면 경기를 종료한다.
    - [ ] 재시작 여부를 확인한다.

- 상대방 (컴퓨터)
    - [ ] 컴퓨터는 베이스볼 넘버를 랜덤한 수로 선택한다.
    - [ ] 플레이어의 공격을 판정하고 힌트를 알려준다.

- 베이스볼 넘버
    - [X] 베이스볼 넘버는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수이다.
    
- 플레이어
    - [ ] 플레이어는 베이스볼 넘버를 예측하여 컴퓨터에게 제출한다.

- 판정(힌트)
    - [ ] 같은 수가 같은 자리에 있으면 스트라이크
    - [ ] 같은 수가 다른 자리에 있으면 볼
    - [ ] 같은 수가 전혀 없으면 포볼 또는 낫싱
    - [ ] 예시 (수비자의 수가 425일 때, 공격자의 수가 123을 제시한 경우 : 1 스트라이크, 공격자의 수가 456을 제시한 경우 : 1볼, 공격자의 수가 789를 제시한 경우 낫싱)