# 숫자 야구 게임
## 용어 정리
* 플레이어 : 게임에 참가하는 사람을 지칭한다. 현재 프로그램에서는 컴퓨터, 그리고 콘솔창(혹은 화면 Input)에 숫자를 입력하는 플레이어 단 두명으로 이루어져 있다.  
* 수비수(DefensePlayer) : 숫자를 결정하는 플레이어
* 공격수(OffensePlayer) : 수비수가 정한 숫자를 맞혀야 하는 플레이어 
  
* 정답 숫자 : 수비수가 결정하며, 현재 프로그램에서는 난수 생성을 통해 결정한다. 
* 후보 숫자 : 공격수가 입력하는 숫자. 

* 심판(Umpire) : 공격수가 입력하는 후보 숫자와 정답 숫자를 비교하여 정답임을 알려주거나 힌트(볼, 스트라이크, 포볼, 낫싱)를 제공한다.
    * 스트라이크 : 같은 수가 같은 자리에 있는 경우 (ex) (정답) 426  (후보) 123 
    * 볼 :  수가 다른 자리에 있는 경우 (ex) (정답) 426 (후보) 213
    * 포볼 or 낫싱 : 같은 수가 전혀 없는 경우 (ex) (정답) 426 (후보) 157

## 구현 기능 목록 
####*기능과 순서도가 혼재되어 있어서 차후에 정리 필요*
### 1. 숫자야구 게임 시작
* Game 객체의 start() 메소드 호출

### 2. 세 자리수 정답숫자 생성 (수비수 : 컴퓨터)
* Player - OffensePlayer
* Player - DefensePlayer 
* Umpire 
* 난수 생성기를 통해 생성
    * 숫자 범위 : 1~9
    * 숫자는 List<>를 통해 담을 건데, 하나라도 일치하는 게 있는 경우에는 다른 난수를 생성한다

### 3. 세 자리수 후보숫자 입력 (공격수)
* 세 자리수 숫자를 입력한다.
* 입력되어 들어온 세 자리 숫자를 마찬가지로 List<>에 담는다.   
* 입력으로 들어오는 값들에 대한 예외처리도 고려한다. -> 해당 역할은 누가? 
    * 숫자가 아닌 값이 들어오는 경우 
    * 세 자리 숫자 이상이 들어오는 경우
    * 빈 값이 들어오는 경우

### 4. 후보숫자와 정답 숫자 비교 
* 정답숫자와 후보숫자를 모두 List<>에 담았기 때문에 iterate하면서 숫자를 비교한다. 
    * JUnit 테스트할때에는 학습노트에 나와있듯이, containsExactly를 사용하면 될 것 같음.

### 5. 정답 맞출 때까지 3~4번 기능 반복 
* 비교해서 볼, 스트라이크, 낫싱을 판단한다. 
* 매 판단시마다 스트라이크, 볼, 낫싱은 초기화해야 한다. 
* 정답을 맞춘 경우에는 6번으로 넘어간다. 
 
### 6. 정답인 경우, 게임을 계속할지 종료할지 결정 
* 게임 지속여부를 질문하는 역할은 심판이, 하지만 실제로 이 질문을 화면에 뿌려주는 건 별개(View의 역할)

### 7. 계속한다고 했을 경우에는 1번으로 돌아가서 1~6번 반복 

### 8. 종료한다고 할 경우에는 게임 종료 
* Game 객체의 exit() 메소드 호출 

---
## 필요한 객체 
### 1. Game 
* start() 
  * createParticipants() 호출 : OffensePlayer와 DefensePlayer, 그리고 Umpire 객체가 생성된다. 
  * DefensePlayer는 decideAnswer()를 통해 난수를 생성한다. 
    * 그리고 그 결과는 자기 자신이 갖게 될테니까 private List< Integer > answer. 
      아니면 Integer는 좀 너무 기본적인 Integer니까 의미가 있는 Number Class를 따로 만들어야 하나 
  * OffensePlayer와 DefensePlayer는 따로 할 일 없을 것 같은데 
* end() : 얘는 정답을 맞힌 경우!!! 
  * 말 그대로 정답을 맞혔기 때문에 restart()을 할 지, 
    정말 말 그대로 quit()할지를 결정해야 한다.
* quit() : 프로그램을 완전히 종료 
* restart() 
  * start에서는 객체를 생성해야 했지만, restart()에서는 그럴 필요는 없다. 
    대신 정답숫자나 후보숫자를 clear()해주어야 할 것 같다. 

### 2. OffensePlayer (공격수)
* 공격수는 사실상...하는 행위가 없네...?
* 그냥 List<> 변수만 가지게 될 것 같은데 
* Strike랑 Ball 객체를 따로 만들어야 할까?
### 3. DefensePlayer (수비수) : 숫자만드는 사람
* decideAnswer()
    * 난수를 생성하여 List<>에 담는다. 
    * 난수 생성 방법 : Random 어쩌고 있을 것 같은데. 
    * 나온 난수가 기존 List에 있는 경우에는 다시 난수 생성 로직을 탈 것
    
### 4. Umpire
* 근데 일단 굳이 심판을 만드는 게 맞을까? 이걸 그냥 수비수한테 맡기면 되지 않을까? 
* 하지만 야구에서 수비수가 파울인지 홈런인지 결정하지는 않으니까. 
* 그러면 '숫자를 입력해주세요' 이런 거의 역할은 누가 맡지?
  Game 객체에서 진행하는 게 맞을까 아니면 Umpire가 진행하는 게 맞을까. 
* 하지만 실제 야구에서도 그냥..진행하는 룰은 암묵적인 거고, 심판은 정말 판정을 내리는 
  역할을 할 뿐인데... 
* compareAnswerWithInput(List Answer, List Input)

### 5. View? 
* Console 창에 찍히는 메세지들을 최대한 핵심로직과 분리하고 싶다. 

### 7. 숫자 List<> ?
* 중요한 부분이라 별도의 객체로 생성은 하고 싶은데, 어떠한 속성과 책임을 부여할 수 있을지 아직은 모르겠다.
