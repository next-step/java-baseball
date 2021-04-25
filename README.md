# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

- pitcher
    - 1~9 사이의 서로 다른 수로 구성된, 세자리 숫자를 random 하게 생성하는 클래스를 구현한다.
- hitter
    - 사용자에게 세 자리 숫자를 입력 받는 클래스를 구현한다.
- referee
    - 예상 숫자와 정답 숫자를 비교해서 Strike, Ball 을 카운트 하는 클래스를 구현한다.
    - 점수를 나타내는 Point 클래스를 구현한다.
    - Point 클래스를 상속하는 Ball 클래스를 구현한다.
    - Point 클래스를 상속하는 Strike 클래스를 구현한다.
- printer
    - 점수에 따라 다르게 출력되는 결과 메세지를 나타내는 ResultMessageCondition interface 를 추가한다.
    - ResultMessageCondition interface 를 구현하는 OnlyBall 클래스를 추가한다.
    - ResultMessageCondition interface 를 구현하는 OnlyStrike 클래스를 추가한다.
    - ResultMessageCondition interface 를 구현하는 StrikeAndBall 클래스를 추가한다.
    - ResultMessageCondition interface 를 구현하는 Nothing 클래스를 추가한다.
    - 출력 메세지가 정의된 PrintMessage Enum 을 추가한다.
    - PrintMessage 와 점수 결과를 출력하는 GamePrinter 구현한다.
- manager
    - 게임을 시작, 재시작시키는 GameManger 클래스를 구현한다.
- GameClient
    - 게임을 start 시키는 클라이언트 클래스인 GameClient 를 구현한다.
- 로직 단위 테스트 코드를 추가한다.
    - PitcherTest
        - 정답 숫자는 세자리 이어야한다.
        - 정답 세 숫자는 1~9 range 를 가진다.
    - RefereeTest
        - 정답 숫자와 기대 숫자의 결과 case 는 아래와 같다.
            - 0볼
                - 0 스트라이크
                - 1 스트라이크
                - 2 스트라이크
                - 3 스트라이크
            - 1볼
                - 0 스트라이크
                - 1 스트라이크
                - 2 스트라이크
            - 2볼
                - 0 스트라이크
                - 1 스트라이크
            - 3볼
                - 0 스트라이크
