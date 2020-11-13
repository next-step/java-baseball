# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록 (계획)
1. 1~9까지 서로 다른 임의의 수 3개를 선택하는 기능
2. 3개의 숫자를 입력하는 기능
3. 스트라이크 개수를 판단하는 기능
4. 볼 개수를 판단하는 기능
5. 낫싱을 판단하는 기능

### 구현한 기능
1. RandomNumberGenerator : 1~9까지 서로 다른 임의의 수 3개를 생성해주는 클래스
2. BaseballCheckor : 입력받은 숫자에 대해 스트라이크, 볼, 낫싱을 판단해주는 클래스
3. CheckType : NOTHING, STRIKE, BALL 타입을 가진 이넘 클래스
4. BaseballMaster : 야구경기를 진행하는 클래스 (숫자를 받고, 결과를 리턴)
5. BaseballStadium (Main 클래스) : 야구경기가 진행되는 메인 클래스

