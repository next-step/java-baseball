# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현대상 소스
### [UI]
* BaseballApplication : 숫자야구 게임 실행을 위한 UI APP
* InputView : 플레이어의 추정숫자 입력을 위한 입력기능 View
* OutputView : 플레이어의 추정숫자와 컴퓨터의 생성숫자 매칭 결과를 보여주는 출력기능 View
### [Presentation Layer]
* BaseballController : 숫자야구 게임 매칭처리 결과를 FrontEnd 에 제공하기 위한 API 진입소스
* BaseballGameRequest : 유저의 추정숫자 입력값을 Backend 로 전달하기 위한 input dto
* BaseballGameResponse : 숫자야구 매칭처리 결과를 Frontend 로 전달하기 위한 output dto
### [Service Layer]
* BaseballGameService : 숫자야구 매칭처리 및 결과 리턴을 위한 서비스 클래스
### [Persistence Layer]
* BaseballNumberRepository : 숫자야구 게임 생성숫자를 저장하고 조회하기 위한 리포지토리 클래스
### [Domain Layer]
* BaseballNumber : 숫자야구 게임의 숫자 한 자리를 표현하는 도메인 클래스
* BaseballNumbers : 숫자야구 게임의 숫자 묶음을 표현하기 위한 일급컬렉션 클래스
### [Infra]
* BaseballDatabase : 숫자야구 게임 생성내역을 저장하기 위한 데이터베이스

