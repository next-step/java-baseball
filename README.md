# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

* BaseballGame : main 함수가 위치해있는 class로, 숫자 야구 게임이 시작되는데 필요한 함수들이 실행됨


* ConstantString : 숫자 야구 게임에서 사용되는 string을 모아놓은 class


* GameInfo : 숫자 야구 게임에서 필요한 정보를 저장해두는 VO class

    - String number ---> 게임에서 사용되는 숫자를 의미한다. 
    - String gameResult ---> 사용자가 숫자를 입력한 뒤, 그 숫자에 대한 결과값을 의미한다.
    - boolean gameResumption ---> 게임을 재개해야하는지에 대한 여부를 의미한다.


* InternalGame : 숫자 야구 게임 내부에서 진행되는 함수 위치된 class


* RequestUser : 숫자 야구 게임에서 사용자에게 값을 요청하는 함수가 위치된 class
