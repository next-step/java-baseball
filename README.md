# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

##프로그래밍 요구사항 - 메소드 분리
* 자바 코드 컨벤션을 지키면서 프로그래밍 - [자바코드컨벤션](https://naver.github.io/hackday-conventions-java/)
* 들여쓰기 depth가 2가 넘지않도록, 1만 허용
* java8에 추가된 stream api를 사용하지 않을 것
* else, switch/case 예약어를 사용하지 않을 것
* 함수(또는 메소드) 길이가 10라인을 넘지 않을 것

## 프로그래밍 요구사항 - 단위 테스트
* 로직에 단위 테스트를 구현한다. 단, UI(System.out,System.in,Scanner) 로직은 제외
* JUnit5 기반 단위 테스트를 구현한다.

## 과제 진행 요구사항
* README.md 파일에 구현할 기능 목록 정리
* git의 commit 단위는 앞 단계에서 정리한 목록 단위로 추가 - [커밋로그참고](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## 구현할 기능 목록 단위
### GameLauncher
* launch - 게임실행

### BaseballGame
* excute - 게임 프로세스 관여
* makeQuiz - Quiz생성(중복되지않는 3개의 숫자 생성)
* receiveInput - 사용자Input받기(사용자에게 3자리의 수 입력받기)
* compareQuizAndInput - 사용자Input,Quiz 값비교(입력받은 3자리의 수와 생성된 3자리의 수 비교)
* printCompareResult - 비교 결과 출력(스트라이크,볼,낫싱 구분 출력)
* checkRetry - 재시작여부 확인(사용자 입력값을 통해 재시작 여부 확인)

### RandomNumberGenerator
* getRandomNumber - 랜덤 숫자 생성(1~9까지의 랜덤 숫자 생성)
* getRandomNumberArray - 사이즈에 맞는 랜덤 숫자 배열 생성
* checkDuplication - 중복 체크
