# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

* #### BaseballGame: main 함수가 위치해있는 class로, 숫자 야구 게임이 시작되는데 필요한 함수들이 실행됨
      - main: 실제로 숫자 야구 게임이 실행되는 function


* #### ConstantString: 숫자 야구 게임에서 사용되는 string을 모아놓은 class


* #### GameInfo: 숫자 야구 게임에서 필요한 정보를 저장해두는 VO class

      - String number ---> 게임에서 사용되는 숫자를 의미한다.
      - String gameResult ---> 사용자가 숫자를 입력한 뒤, 그 숫자에 대한 결과값을 의미한다.
      - boolean gameResumption ---> 게임을 재개해야하는지에 대한 여부를 의미한다.


* #### InternalGame: 숫자 야구 게임 내부에서 진행되는 함수 위치된 class

       - int getStrikeCount(GameInfo realGameInfo, GameInfo userGameInfo)
       : 스트라이크의 갯수를 리턴
       
      - int getBallCount(GameInfo realGameInfo, GameInfo userGameInfo)
       : 볼의 갯수를 리턴
       
      - String concatCountAndUnit(int strikeCount, int ballCount)
       : 스트라이크와 볼의 갯수와 그 단위를 합친 String을 리턴
       
      - GameInfo getGameResultInfo(int strikeCount, int ballCount)
       : 스트라이크와 볼의 갯수를 판단하여 게임 결과 리턴
       
      - GameInfo getRealRandomNumInfo()
       : 숫자 야구 게임에 사용되는 랜덤 숫자 정보 리턴
       
      - GameInfo GameInfo startBaseBallGame(GameInfo realGameInfo)
       : 숫자 야구 게임 시작 후, 결과 리턴
       
      - Boolean isGameRenew(String userAnswer)
       : 게임 다시 시작하는지 여부 리턴


* #### NumberUtil: 숫자 야구 게임에서 숫자와 관련된 유틸이 위치한 class

        - boolean isInteger(String str)
        : 정수 여부 리턴
        
        - boolean isSuitableNumber(String number)
        : 숫자 야구 게임 규칙에 알맞은 수인지 여부 리턴
        
        숫자 야구 게임 규칙
        1. 3자리 수
        2. 각각 서로 다른 수
        3. 1~9에 해당하는 수

* #### RequestUser: 숫자 야구 게임에서 사용자에게 값을 요청하는 함수가 위치된 class

        - GameInfo askUserForSuitableNum()
        : 적합한 수가 나올 때까지 사용자에게 수 입력 요청, 그 수 리턴
        
        - Boolean askUserForRenewGame()
        : 사용자에게 게임 새롭게 시작할지 문의, 여부 리턴
        