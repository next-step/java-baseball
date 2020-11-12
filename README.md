# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현 목록
1. 프로그램의 주요 골격 및 pseudo code 작성
    - BaseballGame 클래스 - 게임 실행 클래스
    - BaseBallNumber 클래스 - 개별 문자와 position 정보가 담김
    - GameResult 클래스 -  게임 결과 반환
2. 컴퓨터가 기억할 1부터 9까지 서로 다른 수로 이루어진 랜덤한 3자리의 수를 생성후 BaseballNumber 인스턴스화
3. 사용자 입력 Validation
4. 사용자 입력 BaseballNumber 클래스로 인스턴스화
5. 컴퓨터 BaseballNumber 객체와 사용자 입력 BaseballNumber 객체의 정보를 비교 후 스트라이크, 볼, 낫싱, 성공 판정
6. 비교 결과에 따른 메세지 처리
7. 재시도 또는 반복 게임 진행 처리
8. 단위 테스트 작성 및 리펙토링