# 숫자 야구 게임

## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 목록
- [x] 프로그램 실행시 컴퓨터는 임의의 3자리 숫자를 정한다.
    - 1부터 9까지 서로 다른 수로 이루어져야 한다.
- [x] 사용자로부터 3자리 수를 입력받는다.
    - [x] 1부터 9까지 서로 다른 수로 이루어져야 한다.
    - [x] 3자리이어야 한다.
    - [x] 0을 포함하면 안된다.
    - [x] 잘못된 수를 입력했을 경우 안내후 다시 입력받는다.
- [x] 결과를 출력한다
    - 숫자와 자리가 모두 맞은 경우: 스트라이크
    - 숫자는 맞지만 자리가 틀린 경우: 볼
    - 3개 숫자 모두 틀린 경우: 낫싱
    - [x] count가 0이라면 표시하지 않는다
        - 2 스트라이크 0볼 -> 2 스트라이크
        - 0 스트라이크 3볼 -> 3 볼
- [x] 3개의 숫자가 모두 맞지 않으면 반복한다. (사용자 입력 부분으로)
- [x] 3개의 숫자가 모두 맞으면 게임이 종료된다.
- [x] 게임종료 후 게임을 다시 시작할 것인지 완전히 종료할 것인지 입력받는다.
    - 다시 시작을 선택한 경우 - 반복 (맨 처음으로)
    - 종료를 선택한 경우 - 종료

## 프로그래밍 요구사항
- [x] Indent 1을 넘지 않는다.
- [x] else를 사용하지 않는다.
- [x] 함수의 길이가 10을 넘을 수 없다.
- [x] 함수가 한가지 일만 하도록 한다.
- [x] Stream api를 사용하지 않는다.
- [x] 단위 테스트를 구현한다.
- [x] (추가) 재할당 불가인 곳에는 모두 final을 붙인다.
- [x] (추가) 의미에 맞는 접근 제한자를 사용한다.
- [x] (추가) 모든 숫자, 문자 리터럴을 래핑한다.
- [x] (추가) 일급컬렉션을 사용한다.
- [ ] (추가) 3개 이상 인스턴스 변수를 사용하지 않는다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
