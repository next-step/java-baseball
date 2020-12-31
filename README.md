# 숫자 야구 게임
## Baseball 클래스 메서드 구현 목록 

1. 생성자 및 난수생성
생성자를 통해서 클래스를 생성하고, 컴퓨터가 게임에서 사용할 난수를 생성하도록 합니다.
Baseball, makeNumber

2. 입출력 및 스코어 확인
사용자를 통해서 게임에 참여할 값을 입력 받고,
생성된 난수를 통해 스코어를 계산한 뒤 스코어를 출력하도록 합니다.
scanNumber, checkScore, checkNumber, sameNumber, equalCheck, printScore, printStrikeBall

3. 재시작 
3스트라이크일 시에 재시작 문구를 출력하고 재시작 여부를 확인 할 수 있는 메서드를 생성합니다.
3스트라이크가 아닐 시에 1~2의 과정을 반복할 수 있도록 합니다.
checkRestart,restartSwitch,restart

4. Baseball class 내 테스트를 위한 메서드 목록
testNumber,testScore

### 각 메서드에 대한 설명은 코드 내 주석으로 달려있습니다.


## Main 클래스

Baseball 클래스로부터 객체를 생성해 게임을 진행합니다.

## BaseballTest 클래스

Baseball 클래스 메서드중 큰 구분인 1,2,3번을 4번을 포함해 활용하면서 테스트했습니다.

