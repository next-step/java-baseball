# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 목록 
* 공통 사용 볼 객체 생성
  - /domain/Ball.java
* 컴퓨터 랜덤생성하는 볼 class 생성
  - /domain/ComNumber.java
* 사용자가 입력하는 볼 class 생성
  - /domain/UserNumber.java
* 야구게임 시작하는 서비스/어플리케이션 class 생성
  - /service/GameService.java
  - BaseballApplication.java
* 게임판별 class 생성
  - /domain/JudgeGame.java 
  - 스트라이크 카운트
  - 볼 카운트
  - 결과 메세지 출력
* 게임판별에 따른 서비스단 기능 추가 (새로운 게임시작 or 종료) 
* 유효성 검사 로직 생성
  - Exception 파일 생성
  - /exception/BallException.java
  - /exception/InputException.java
* 테스트코드 생성
  - /test/java/domain/BallTest.java 생성
  - /test/java/domain/JudgeGame.java 생성
  - 테스트코드 생성에 따른 유지보수 
* 최종 코드 정리
  

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
