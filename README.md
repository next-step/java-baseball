# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 기능 요구사항
- 3개의 숫자를 맞추는 게임이다. 각 숫자는 1 ~ 9 사이의 서로 다른 임의의 숫자로 구성된다.
- 숫자와 자리를 함께 맞추면 strike, 숫자만 맞추고 자리는 틀렸으면 ball, 다 틀렸으면 nothing이라는 힌트를 얻는다.
- 힌트를 이용하여 상대방(컴퓨터)의 수를 맞추면 승리한다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

### 예시
- 상대방(컴퓨터)의 수가 425
  ```plain text
  123을 제시한 경우: 1 strike
  456을 제시한 경우: 1 strike 1 ball
  798를 제시한 경우: nothing
  ```

### 프로그램 실행 결과
```plain text
숫자를 입력해주세요: 123
1 strike 1 ball
숫자를 입력해주세요: 145
1 ball
숫자를 입력해주세요: 671
2 ball
숫자를 입력해주세요: 216
1 strike
숫자를 입력해주세요: 713
3 strike
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요: 123
1 strike 1 ball
...
```

---

## 프로그래밍 요구사항

### 메소드 분리
- 자바 코드 컨벤션 준수
  - https://naver.github.io/hackday-conventions-java
- indent depth는 1까지만 허용
- stream 비허용, lambda 허용
- else 비허용
- 메소드의 길이는 최대 10줄까지만 허용

### 단위 테스트
- 단위 테스트 구현할 것
  - UI 로직 제외
  - 핵심 로직과 UI 로직 구분

---

## 과제 진행 요구사항
- commit log 참고사항
  - https://gist.github.com/stephenparish/9941e89d80e2bc58a153

--- 

## 기능 분석
- TBD