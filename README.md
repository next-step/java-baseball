# 숫자 야구 게임

### 구현할 기능 목록
**기능 단위**
  - 사용자 값 입력, 현황(score) 출력
  - 스트라이크, 볼 판단
  - 임의의 3자리수 생성 (컴퓨터 역할)

**Class 단위**
  - Starter
    - 역할 : 야구 게임 시작과 사용자 입력 값을 받은 후 전달하는 역할
    - 기능 : 값 입력과 게임 재시작, 마감을 확인할 수 있는 기능 필요
  - BaseballGame
    - 역할 : 게임에 필요한 객체(역할)의 의존성을 가지고 있으며, 각 객체들과 협력
    - 기능 : Referee, QuestionNumber 각 클래스와 협력에 필요한 기능(QuestionNumber 생성, StringConverter, 등) 필요
  - Referee
    - 역할 : 사용자에게 입력 받은 값을 스트라이크와 볼을 판단하고 해당 상태를 보관
    - 기능 : 스트라이크, 볼 판단 및 출력 기능 필요
  - QuestionNumber
    - 역할 : 사용자가 맞혀야 되는 3자리의 수와 정책을 갖는 역할
    - 기능 : 3자리의 수를 생성할 때 필요한 정팩 제공
  - Computer
    - 역할 : 서로 다른 3자리의 수를 만드는 객체
    - 기능 : QuestionNumber Class 로 부터 정책을 받은 후 3자리의 수 생성
  - QuestionInterface
    - 역할 : 3자리의 수 생성할 때 확장성을 고려하여 생성한 인터페이스 (현재는 컴퓨터가 랜덤으로 3개의 숫자를 생성해주지만, 사용자가 직접 입력하여 숫자를 생성할 수 있음을 고려)

<img src="https://github.com/JungwooSim/java-baseball-precourse/blob/master/img/UML-class.png" width="500px;" />
