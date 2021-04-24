# 숫자 야구 게임
## 도메인 규칙
- [ ] 게임이 있다.
  - [ ] 게임이 생성과 동시에 Ball이 생성된다.
    - [ ] 공들을 생성하는 전략을 받을 수 있다.
        - [ ] 기본은 랜덤한 전략이다.
  - [ ] 공을 받아 게임결과를 볼 수 있다.
    - [ ] 정해진 개수가 아니면 Exception 이 발생한다.
- [X] 공이 있다. 
    - [X] 공은 숫자가 1~9까지 존재한다.
        - [X] 공에 미리 생성된 공은 불변 객체이다.
        - [X] 공은 생성이 불가능하며, static method로 객체를 전달해줄 수 있다.
            - [X] 이 뜻은 같은 공의 번호면은 같은 객체인 것이다.
- [X] 공들이 있다.
    - [X] 공들이라는 객체는 여러가지의 공을 갖는다.
    - [X] 공들안에는 같은 숫자가 존재해서는 안된다.
    - [X] 공들은 생성자를 가지고 있다.
        - [X] 공들을 생성할 때 공을 여러개 받을 수 있다.
    - [ ] 공들과 공들은 매칭하여, 결과를 도출 할 수 있다.
    - [X] 공들 안에 공의 위치를 알아 낼 수 있다.
        - [X] 찾지 못하면 Position.NOT_FOUND를 return 한다.
- [X] 매칭 결과가 있다.
    - [X] 스트라이크 개수를 갖는다.
    - [X] 볼 개수를 갖는다.
    - [ ] 포볼 또는 낫싱 개수를 갖는다.
- [X] 위치가 있다.
    - [X] 위치는 숫자를 갖고 있다.
        - [X] 위치는 양수만을 가질 수 있다.
    - [X] NOT_FOUND 라는 못찾았다는 의미의 상수가 정의가 되어있다.
- [X] 게임 룰이 있다.
    - [X] 같은 수가 같은 자리에 있으면 스트라이크
    - [X] 같은 수가 다른자리에 있으면 볼
    - [X] 같은 수가 전혀 없으면 포볼 또는 낫싱