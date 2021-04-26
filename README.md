# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 단위 목록

- `볼(Ball)`: `선수(Player)`가 가진 하나의 숫자를 의미한다.
    - [x] 1 ~ 9 사이의 값만 허용한다.
    - [x] `볼(Ball)`이 일치하는지 비교할 수 있다.

- `볼들(Balls)`: 3개의 `볼(Ball)`들을 의미한다.
    - [x] 3개의 `볼(Ball)`을 가진다.
    - [x] `볼(Ball)`의 값이 중복될 수 없다.
    - [x] 특정 위치의 `볼(Ball)`을 비교할 수 있다.
    - [x] `볼(Ball)`을 포함하는지 확인할 수 있다.

- `볼들(Balls) 생성기`: `볼들(Balls)`을 만드는 역할을 한다.
    - [ ] 랜덤한 `볼들(Balls)`을 만든다.

- `투수(Pitcher)`: `볼들(Balls) 생성기`를 활용한 `볼들(Balls)`을 가진다. (컴퓨터)

- `타자(Batter)`: 시스템에서 입력받은 문자열을 활용한 `볼들(Balls)`을 가진다. (사용자)

- `심판(Referee)`: `선수(Player)`들의 `볼들(Balls)`을 비교하는 역할을 한다.
    - [ ] `판정(Judgment)`한 결과로 `판정 보고서(Judgment Report)`를 만든다.
    - [ ] 위치와 숫자가 같다면 `Strike`로 `판정(Judgment)`한다.
    - [ ] 위치가 다르고 숫자만 같다면 `Ball`로 `판정(Judgment)`한다.
    - [ ] 그 외에는 `Miss`로 `판정(Judgment)`한다.

- `판정 보고서(Judgment Report)`
    - `판정(Judgment)`에 대한 결과를 나타낸다.
    - [ ] 3 스트라이크인지 판단할 수 있다.
    - [ ] 힌트를 알 수 있다.