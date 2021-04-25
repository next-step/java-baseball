# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 요구 사항 정리

### 진행 방식
* 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항 세 가지로 구성
* 기능 구현 전, 기능 목록 생성
* 기능 단위로 commit

### 기능 요구 사항
* 1-9까지의 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
* 입력 값에 대해 힌트를 얻고 그 힌트를 이용하여 수를 맞추면 승리
* 힌트 조건 
  + 같은 수, 같은 자리 : 스크라이크
  + 다른 자리 : 볼
  + 전혀 없다면 : 낫싱
* 플레이어는 3자리 수 입력, 컴퓨터는 입력 숫자에 대한 결과 출력
* 플레이어가 3자리를 모두 맞히면 게임 종료
* 게임 종료 후 다시 시작/종료 

### 프로그래밍 요구 사항
* 메소드 분리
  + 코딩 컨벤션 https://naver.github.io/hackday-conventions-java/
  + indent는 depth 1까지 허용 (whiled 안의 if는 2)
  + JAVA 8 stream X , 람다 O
  + else는 사용 X
  + 메소드 길이 10라인 넘어가지 않도록   
    
* 단위 테스트
 + ui 로직 제외한 로직에 단위 테스트 구현(핵심 로직,ui 담당 로직 구분)
+ JUnit5, AssertJ 익혀 JUnit5 기반 단위 테스트 구현


### 구현 목록
* BaseballGameApplication : 숫자 야구 게임이 실행되는 main 메소드가 있는 클래스
* baseball.view.BaseballClient : 숫자 야구 게임의 화면 입/출력을 담당하는 클래스
  + 게임 옵션 출력 메소드
  + 사용자 인풋 입력 메소드
  + 게임 결과 메세지 출력 메소드
  + 게임 종료 메세지 출력 메소드
* baseball.common.BaseballGame : 게임 로직 및 상태 값 저장하는 클래스
  + 게임 상태 상수
  + 게임 시작 메소드
  + 사용자 입력 바탕으로 랜덤 숫자 추측 메소드
  + 힌트 값 초기화 메소드
  + 게임 종료 조건 판정 메소드
  + 결과 메세지 생성 메소드
* baseball.util.BaseballUtil : 난수 생성, 난수 validation 체크 등 유틸성 메소드 클래스
  + 난수 생성 메소드
  + 생성된 난수 중복 값 validation 체크 메소드
  