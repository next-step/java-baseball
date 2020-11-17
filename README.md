# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

### 패키지 경로 
package me.rn00n.baseball

## 숫자 야구 게임(투수가 던진 볼을 추리하는 게임)
## 기능 목록
1. 투수역할(컴퓨터)에게 설정할 임의의 수 3자리를 생성하는 기능 - number.BaseballRandomNumber.class
2. 3자리 숫자를 가지고있는 투수 객체 정의 - pitcher.Pitcher.class
3. player 가 던진 숫자와 비교해 스트라이크, 볼, 낫싱 출력하는 기능 - pitcher.Pitcher.class
4. player 가 3자리 숫자 숫자 입력, 입력한 3개의 수 유효성검사(중복체크) 기능 - Baseball.class
5. 3번 기능에 따른 결과, 힌트 출력 기능 - Baseball.class
6. 숫자 야구 게임 시작, 진행, 종료 기능 - Baseball.class
7. 별도의 메인 클래스에 게임 생성 - Main.class

##### * 입력할 숫자 자릿수가 n자리 가능하도록 구현 (기본 3자리)