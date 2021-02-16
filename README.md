# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현

* 숫자 야구를 시작하기 이전에 정답을 가져옵니다.
  - AnswerStrategy 클래스는 숫자를 랜덤으로 빼오는 전략 클래스 
  - AnswerNumbers 클래스는 숫자 야구의 정답을 들고 있는 일급 컬렉션 클래스

* 정답을 맞추기 위해서 숫자를 입력받습니다. 
  - InputView 클래스는 숫자를 입력받는 클래스

* 입력받은 숫자를 비교 합니다.
  - Matcher 클래스는 입력 받은 숫자를 파싱하고, Strike와 Ball로 매칭해주는 클래스 
  - Shot은 라운드가 진행 되었을 때, 어떤 숫자를 맞추고 있는가 보여주는 인터페이스
    
* 상태
    * Shot
        * 스트라이크(Strike 클래스)
          - 숫자가 같고, 자리까지 같으면 스트라이크 
        * 볼(Ball 클래스)
          - 숫자가 같고, 자리가 다르면 볼
    
    * Shots
      * Shot의 컬렉션 클래스, List<Shot>을 갖고, 기능을 제공하는 클래스로 사용
        
    * Finished는 라운드가 종료되었을 때 결과 값을 보여주는 클래스, notthing이거나  재진행, finish상태이면 게임 반복 종료 
      
    * Finished
        * Shots (Result 클래스)
        * 낫싱 (Notthing 클래스)
          - 같은 수가 전혀 없으면 낫싱
        * 게임 종료(Finish 클래스)
          - 3개의 숫자와 자리가 같으면 게임 종료

* OutputView는 Finished의 데이터를 받아서 출력하는 클래스    