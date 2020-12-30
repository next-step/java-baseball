# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
* main process
> 1. 랜덤으로 컴퓨터ID 를 생성한다.     ::  ID.genByRandom( )
> 2. 컴퓨터ID 를 유추하기 위한 proces진행.      ::   processToFindComputerID( )
> 3. 계속할 것인지 묻는다.       ::    askForContinue( ) 
> 4. no 이면 exit; yes이면 2로 돌아간다.

* 컴퓨터ID 를 유추하기위한 process        :: processToFindComputerID()
> 1. 유저의 ID를 생성한다.      ::   ID.genByTyping()
> 2. userID와 computerID를 비교한다.      ::  ID.compare()
> 3. 같으면 exit; 다르면 fail message (x스트라이크, y볼 메시지) 를 출력하고 1로 되돌아간다.

* UserID와 computerID를 비교하는 process      ::  ID.compare()
> 1. strike 갯수를 구한다.        ::  getStrikeCnt()
> 2. ball 갯수를 구한다.      ::  getBallCnt()
> 3. strike 갯수가 3과 같은지 비교한다. 
> 4. 3 이면 "same" return; 아니면 fail message return

