# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현
1. Main 클래스 - application 동작을 위한 클래스
   - main - application 실행

1. Answer 클래스 - 야구 게임 정답을 의미하는 클래스
   - equals - 입력으로 받은 정답이 자신과 동일한지 확인
   - printHint - 힌트를 출력
   - getBallCount - ball 개수 반환
   - getStrikeCount - strike 개수 반환
   - getHint - strike 개수와 ball 개수를 이용하여 힌트 문자열 생성 후 반환

1. ValidationChecker 클래스 - 사용자 입력에 대한 정합성 체크를 수행하는 클래스
   - isCorrectFormatForAnswer - 사용자가 정답이라고 입력한 값이 정상적인지 확인
   - isCorrectFormatForRetry - 사용자가 재시작 여부라고 입력한 값이 정상적인지 확인
   
1. BaseballGame 클래스 - 야구 게임의 전체적인 흐름을 제어하는 클래스
   - run - 게임 시작
   - getInitAnswer - 초기화 된 정답 객체를 반환
   - getNumber - 사용자 정답 입력
   - isRetryOrNot - 게임 재시작 여부 확인