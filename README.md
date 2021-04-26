# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능
![baseball-classdiagram](https://github.com/mettlekc/woocamp-resources/blob/main/woocamp-baseball-precourse_20210426.jpg)

#### 기능
* start : 게임 시작/플레이/종료
* create : 임의의 세자리 숫자 생성
* play : 플레이어의 숫자와 생성된 숫자 비교하여 결과 반환
* print : 결과 표시

#### 모델
baseball.domain.Score
* strike : strike count
* ball : ball count