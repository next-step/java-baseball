# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
### 기능 정의
* 초기화
  * 1~9 서로 다른 3자리 난수 생성
* 숫자 입력
  * 입력 양식에 대한 질의 메세지 출력
  * 사용자 숫자 입력
* 일치 수 체크
  * 입력 값 검증, 1~9 서로 다른 3자리 난수 여부
  * 잘못된 양식일 경우 "숫자 입력" 과정 반복
  * 스트라이크: 같은 수가 같은 자리에 있을 경우
  * 볼: 다른 자리에 있을 경우
* 일치 결과 출력
  * 스트라이크의 수, 볼의 수 또는 둘다 0 일 경우 낫싱 출력
  * 3 스트라이크가 아닐 경우 "숫자 입력" 과정 반복
* 재시작 여부 입력
  * 재시작 여부에 대한 질의 메세지 출력
  * 재시작 여부 입력
* 재시작 여부
  * 입력 값 검증, 1(재시작) 또는 2(종료) 여부
  * 잘못된 양식일 경우 "재시작 여부 입력" 과정 반복
  * 1 일 경우 "초기화" 과정부터 반복
  * 2 일 경우 종료

### 구현 목록
* Config
  * App Config: 난수 및 사용자 숫자 입력 관련 상수 관리
  * App Context: Application Context, Instance 관리
* Controller
  * Game Controller: 게임의 진행상태에 따라 관련된 domain, service, domain control
* Domain
  * Game Model: 난수, 진행상태 값 저장
  * BallCount Model: 스트라이크, 볼 횟수 저장
* Error
  * NonNumericCharacters: 1~9 사이 숫자가 아닐 경우 Exception
  * DuplicateCharacters: 중복된 번호가 있을 경우 Exception
  * NonRestartCharacters: 1(재시작), 2(종료)가 아닐 경우 Exception
* View
  * BallCount View: 사용자 숫자 입력, 결과 출력
  * Restart View: 재시작 입력, 결과 출력
* Service
  * BallCount Service: 난수 생성, 난수와 사용자 숫자 입력값 비교
  * Restart Service: 재시작 여부 반환
* App: Application 구동
