# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 필수 요구사항
### 기능 요구사항
* 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

### 프로그래밍 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * https://naver.github.io/hackday-conventions-java/
* indent depth를 2가 넘지 않도록 구현한다.
* 자바8의 stream api를 사용하지 않고 구현 해야 한다. 람다는 사용 가능하다.
* else 예약어를 사용하지 않는다.,
* 함수 또는 메소드의 길이가 10라인을 넘어가지 않도록 구현한다.

## 기능 구현목록
- [x] 1.게임이 시작된다.
    - [x] 야구 게임에서 정답이 될 숫자를 생성한다.
        - [x] 숫자는 1부터 9까지 서로 다른 양수로 이루어진 3자리의 수가 무작위로 생성된다.

- [ ] 2.'숫자를 입력해주세요 : ' 란 메시지가 콘솔에 출력되고, 플레이어에게 숫자를 입력받는다.
    - [X] 1부터 9까지 입력할 수 있다.
    - [X] 서로 다른 수만 입력할 수 있다.
    - [X] 3자리의 수만 입력할 수 있다.
    - [X] **(그 외 입력 예외처리) 위 조건에 부합하지 않는 숫자를 입력할 경우 입력 가능한 조건을 출력한다.**

- [ ] 3.컴퓨터가 정답과 플레이어가 입력한 수로 결과를 판단한다.
    - [ ] 정답과 플레이어가 입력한 수를 비교하며 점수를 측정한다.
        - [ ] 특정 수가 같은 자리에 있으면 **스트라이크** 로 카운팅 한다.
        - [ ] 특정 수가 다른 자리에 있으면 **볼** 로 카운팅 한다.
    - [ ] 측정된 점수로 결과를 출력한다.
        - [ ] 3 스트라이크(모든 수가 같은 자리에 있음)면 게임 종료 메시지를 출력한다.
            - [ ] 게임종료 메시지 : **'N개의 숫자를 모두 맞히셨습니다! 게임 종료\n '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요'**
        - [ ] 0 스트라이크, 0 볼이면 **낫싱** 을 출력하고 플레이어에게 다시 숫자 입력을 요청한다.
        - [ ] 그 외에 '${스트라이크 수} 스트라이크 ${볼 수} 볼'란 메시지를 출력하고 플레이어에게 다시 숫자 입력을 요청한다.
    
- [ ] 4.게임이 끝나면 플레이어가 1(시작) 또는 2(종료)를 입력한다.
    - [ ] **1(게임 시작)** 을 누를 경우 게임을 다시 시작된다.
    - [ ] **2(종료)** 를 누를 경우 프로그램이 종료된다.
    - [ ] **(그 외 입력 예외처리) 플레이어에게 1 또는 2를 입력 해줄 것을 요청한다.**