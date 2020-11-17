# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 과제 요구 사항
메소드 분리
* 자바코드컨벤션을 지키면서 프로그래밍
https://naver.github.io/hackday-conventions-java/
* indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현. 1까지만 허용.
예를 들어 while문안에 if문이 있으면 들여쓰기는 2.
힌트 : indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는메소드)를 분리하면 된다.
* 자바8에 추가된 stream api를 사용하지 않고 구현. 단, 람다는 사용가능.
* else 예약어를 쓰지 않는다.
힌트 : if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
else를 쓰지말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지않는다.
* 함수(또는메소드)의 길이가 10라인을 넘어가지 않도록 구현.
* 함수(또는메소드)가 한가지 일만 잘하도록 구현

단위 테스트
* 로직에 단위 테스트를 구현. 단,UI(System.out,System.in,Scanner)로직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를통해JUnit학습하기.pdf" 문서를 참고해 사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현

##구현할 기능 목록
* 초깃값 설정(컴퓨터 랜덤 숫자)
* 플레이어 숫자 입력
* 입력한 숫자와 컴퓨터 랜덤 숫자 비교
* 결과 출력
* 시작 또는 종료 입력
