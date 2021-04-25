# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
1. 3자리 숫자 생성 [generateThreeNumbers]
   * 1~9 사이의 서로 다른 수로 이루어진 3자리 숫자

2. 입력값 유효성 검증 [isValidInputValue]
   * 길이 검증 (세 자리) [isValidLength]
   * 형식 검증 (각 자리에 0이 없어야 하고 숫자이어야 함) [isValidFormat]

3. 스트라이크, 볼 계산 [calculate]
   * 스트라이크 갯수(X) 계산 [calculateStrike]
   * 볼 갯수(Y) 계산 [calculateBall]
   
4. 결과 출력 [printResult]
   * X 스트라이크 Y 볼
   * X 스트라이크
   * Y 볼
   * 낫싱

5. 종료 (3 스트라이크시, X == 3)
   * 입력 값 1: 게임 다시시작
   * 입력 값 2: 게임 종료