# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능설계
* UI 설계
  - InputUI
    1. 숫자 입력 받기 문구 출력
    - '숫자를 입력해 주세요 :'
  - OutputUI
    1. 입력 받은 숫자에 대한 결과 출력 
    - 맞추지 못할 경우 
      - 하나도 맞추지 못한 경우 '낫싱'
      - 하나라도 존재하는 경우 'N스트라이크 N볼'
    - 모두 맞춘 경우 '3개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.'
   
* 기능 설계
  - [BaseballGame]: 전체적인 게임의 진행과 UI 출력을 관장한다. 
    - 게임을 시작하거나, 종료할 수 있다.
    - 베이스볼 게임은 [Opponent], [Player], [Referee] 로 구성되어 있다.
    - [Opponent]에게 세자리 숫자의 생성을 요청 한다.
    - [Player]에게 세자리 숫자의 입력을 요청 한다.
    - [Player]가 입력한 숫자와 [Opponent]에서 생성한 임의의 숫자를 [Referee]에게 전달 한다.
    - [Referee]에게 받은 숫자의 매칭 결과를 확인하여 해당 게임의 진행, 완료 여부를 확인한다.
    - 해당 게임이 완료 될 경우, [Player]에게 새게임 시작 여부를 확인하여 게임을 다시 시작 할 수 있다. 
  - [Opponent] aka.컴퓨터: [BaseballGame]에서 숫자 생성 요청 시 세자리의 모두 다른 임의의 숫자를 생성한 후 리턴한다.    
    - 세자리 숫자는 1~9 이내의 서로 다른 수여야 한다.
  - [Player]: [BaseballGame]에서 숫자 입력 요청 시 세자리의 숫자를 입력 하여 리턴 한다.    
    - 동일한 수가 입력 되었을 시 중복 제거를 하여 한개로 처리 한다. (ex 111 -> 1)
      - (요구사항이나 출력 결과에 중복으로 입력 시 다시 입력하게 한다 등의 해당하는 내용이 없음)
  - [Referee]: [BaseballGame]에게 전달받은 [Player]가 입력한 숫자와 [Opponent]가 지정한 숫자의 매칭여부를 확인 후 결과를 리턴 한다.  
  
  
## 기능목록
* UI 기능
  - InputUI
    - 숫자 입력 받기 문구 출력 기능   
  - OutputUI
    - 결과 출력
      - 스트라이크-볼 결과 출력 기능
      - 낫싱 결과 출력 기능
      - 게임 종료시 새게임-게임 종료 출력 기능
   
* 기능
  - [Opponent] : 
    - 임의의 서로 다른 3자리 숫자로 이루어진 Baseball Number 생성 기능
  - [Player]: 
    - 입력 받은 세자리의 숫자를 통해 Baseball Number 생성 기능               
  - [Referee]: 
    - 2개의 Baseball Number 간 matching check 기능       
  - [BaseballGame]:  
    - Baseball Game 비즈니스 로직: 기능 설계의 Basaball Game 부분
     

  
  
  
 

