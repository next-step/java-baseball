# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구조
src
 - main
  - java
   - domain
    Check.java : Com 클래스에서 받아 온 값과 사용자 값을 받아서 처리
    Com.java : Computer의 랜덤 값을 처장하는 클래스
   - service
    BaseService.java
    1) resultCheck : 스트라이크와 볼의 갯수로 출력할 방식을 결정하는 매서드
    2) playChoice : 계속 진행할 것인지, 종료할 것인지 결정하는 매서드
    3) getUserNum : 사용자 번호를 입력받는 매서드
   function.java