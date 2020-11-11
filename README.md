# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 요구사항 분석  

1. 서로 다른 랜덤숫자 3자리를 만들어 제시한다.  
2. 숫자 3자리를 입력받는다.  
3. 스트라이크, 볼, 포볼/낫싱 여부를 판단하여 출력한다.  
4. 3자리 모두 스트라이크일 경우 게임이 종료된다.  

## 객체 도출  
* BallNumber
    * 제시한 단일 숫자  
    * 숫자와 위치 정보를 갖는다.  
    * 위치는 3을 넘어가면 안되고, 숫자는 1-9이여야 한다.  
* BallNumbers  
    * 제시한 단일 숫자 3개 1세트를 나타내는 객체  
    * 서로 다른 수로 이루어져 있어야 한다.  
    * List의 개수를 3개가 넘어가면 안된다. 
* Referee (Util성)
    * 숫자를 입력받아 결과를 리턴해주는 객체  
    * Util성 객체로 처리한다.  
* Result  
    * 결과 객체  
    * Strike, Ball 정보를 갖는다 . 
    * Strike, Ball 정보를 토대로 낫싱(볼넷) 여부를 판단한다.  
    * String으로 결과를 뱉어준다.  
* BaseballGame (Controller): 게임 진행 Controller  
    * RandomNumberGenerator를 이용해 랜덤 BallNumbers를 생성하여 출력한다.  
    * 사용자에게 입력받은 숫자를 토대로 BallNumbers 객체를 생성한다.  
    * Referee 객체를 
* RandomNumberGenerator: 랜덤 숫자 생성을 도와주는 클래스