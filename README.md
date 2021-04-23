# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 과제 진행 요구사항
* commit 단위는 기능 목록 단위로 추가
  * [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#examples)
    참고해 commit log 작성

---

## 기능 요구사항
* 서로 다른 수로 이루어진 3자리 수 맞추는 게임
* 게임 로직
  * 같은 수 / 같은 자리 = 스트라이크
  * 같은 수 / 다른 자리 = 볼
  * 조건 해당 X = 포볼 or 낫싱
* 컴퓨터가 문제를 내고 사용자가 숫자를 맞추는 방식
* 게임 종료한 후 게임을 다시 시작 or 완전히 종료 선택

## 기능 목록
* 3자리수 생성 기능
* 3자리수 입력 기능
* 스트라이크, 볼 판별 기능
* 게임 결과 안내 기능
* 게임 종료 & 재시작 기능

## 프로그래밍 요구사항 - 메소드 분리
* 자바 코드 컨벤션 준수
* indent depth 1까지만 허용
* stream api 사용 불가
* 람다 사용 가능
* else 사용 불가
* switch/case 사용 불가
* 함수 길이 10라인 이하 구현
  * 한가지 작업만 잘 하도록 구현

## 프로그래밍 요구사항 - 단위 테스트
* 로직에 단위 테스트 구현 단, UI(System.out, System.in, Scanner) 로직 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직 구분
* JUnit5 기반 단위 테스트 구현
