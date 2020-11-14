# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
## 학습테스트
* [x] String 클래스에 대한 학습 테스트
* [x] Set Collection에 대한 학습 테스트

---
## 숫자야구 기능 요구사항 정리
* [x] 입력받은 숫자와 순서를 비교하여 결과를 알려준다. (strike = 1,  ball = 0, nothing = -1)
    * [x] 입력받은 숫자가 1-9 사이인지 확인한다.
    * [x] 입력받은 숫자의 위치가 0-2 사이인지 확인한다.

* [x] 컴퓨터용 3자리 숫자를 제공한다.

* [x] 입력받은 세자리 숫자를 비교하여 결과를 알려준다.
    * ball 객체들을 map( 숫자, ball객체) 로 관리
    * key를 통해 숫자를 비교하고, value의 위치 비교
    
* [x] 숫자야구 게임을 진행한다.
    * computer balls 생성
    * 입력받은 숫자 비교 및 결과 반환
    * 완료여부 판단 / 재시작
    
* [x] Main, UI 기능 추가