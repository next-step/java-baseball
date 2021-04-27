# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능
![baseball-classdiagram](https://github.com/mettlekc/woocamp-resources/blob/main/woocamp-baseball-precourse_20210426.jpg)

### 기능
* baseball.service.Console
    * start : 게임 시작/플레이/종료. 플레이어의 숫자 입력 처리
* baseball.service.Game
    * create : 게임을 생성하면 적 숫자(임의 세자리 난수)를 생성
    * play : 플레이어의 숫자와 생성된 숫자 비교하여 Score(결과) 반환
    * print : Score(결과)를 스트라이크/볼/낫싱으로 변환하여 화면에 출력

### 모델
* baseball.domain.Score
    * strike : 같은 자리에 수가 같은 경우 카운트 결과
    * ball : 수가 다른 자리에 포함된 경우 카운트 결과
        * 단, 4볼인 경우 낫싱으로 처리 (어떤 수도 맞지 않은 경우)