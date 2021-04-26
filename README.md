# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 승리 조건 
    * 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추는 경우.
* 힌트 종류
    * 스트라이크 : 같은 수가 같은 자리에 있는 경우.
    * 볼 : 다른 자리에 있는 경우.
    * 포볼 또는 낫싱 : 같은 수가 전혀 없는 경우.
* 게임 진행 방법
    * 상대방의 역할을 컴퓨터가 한다.
    * 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    * 게임 플레이어는 컴퓨터가 선택한 3개의 숫자를 입력한다.
    * 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    * 위의 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    
## 프로그래밍 요구사항
* 메소드 분리
    * 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다.
    * 자바 8에 추가된 stream api를 사용하지 않고 구현한다. 단, 람다는 사용 가능하다.
    * else 예약어는 쓰지 않는다. switch/case도 허용하지 않는다.
    * 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한가지 일만 하도록 구현한다.
* 단위 테스트
    * 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
    * JUnit5와 AssertJ 사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

## 과제 진행 요구사항
* https://github.com/next-step/java-baseball-precourse 저장소를 fork/clone해 시작한다.
* 기능을 구현하기 전에 README.md파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit단위는 앞 단계에서 README.md파일에 정리한 기능 목록 단위로 추가한다.
* 과제 진행 및 제출 방법은 프리코스 과제 제출문서를 참고한다

## 기능 목록
* \#001 : 1~9까지 서로 다른 임의의 수 3개 선택 기능 구현
* \#002 : 3개의 숫자 입력 기능 구현
* \#003 : 힌트 반환 기능 구현
* \#004 : 게임 재시작/완전 종료 기능 구현
* \#005 : 게임 반복 기능 구현
