# 숫자 야구 게임

## 진행 방법

- 숫자 야구 게임 요구사항을 파악한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

- [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Conventions

- language conventions은 [hackday-conventions-java](https://naver.github.io/hackday-conventions-java/#_%ED%8C%8C%EC%9D%BC_%EA%B3%B5%ED%86%B5_%EC%9A%94%EA%B1%B4)의 규칙을 따른다.
- commit conventions는 [angularJS-commit-conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)의 규칙을 따른다.

## 요구사항

### JUnit 학습

- 단위 테스트를 위한 클래스 명명 규칙("테스트 대상 클래스명 + Test")에 따라 클래스를 생성한다.
- JUnit의 `@DisplayName`을 활용해 테스트 메소드의 의도를 드러낸다.

- String 테스트
  - [x] "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
  - [x] "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
  - [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
        하도록 구현한다.
  - [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
        테스트를 구현한다.
  - [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
        StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- Set 테스트
  - [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
  - [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하
        려한다.
    - [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
  - [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과
        값이 다른 경우에 대한 테스트도 가능하도록 구현한다.

### 숫자 야구 게임 기능

- 투수(Pitcher)

  - [x] 1부터 9까지의 서로 다른 수로 이루어진 3자리수를 입력 받는다.
    - [x] Type은 Integer이다.
    - [x] 입력한 값은 3자리수이다.
    - [x] 각각 고유한 값이여야 한다.

- 타자(Hitter)

  - [x] 1부터 9까지의 서로 다른 수로 이루어진 3자리수를 만든다.
    - [x] 1부터 9까지의 숫자를 선택한다.
    - [x] 3번 뽑는다.
    - [x] 각각 고유한 값이여야 한다.

- 심판(Referee)

  - [ ] 투수와 타자의 값을 비교한다.
    - [ ] 수가 같고, 자리가 같으면 스트라이크 count를 `+1` 늘리고 count 출력
    - [ ] 수가 같고, 자리가 다르면 볼 count를 `+1` 늘리고 count 출력
    - [ ] 모든 수가 다르고, 자리도 다르면 `낫싱` 출력
    - [ ] 스트라이크의 count가 `3`이면 게임에서 승리

- 매니저(Game)
  - [ ] 승리 할 경우 게임 재시작 또는 프로세스를 종료 시킬 수 있다.
