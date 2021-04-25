# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 요구 사항
1. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
2. 플레이어는 3개의 숫자를 입력한다.
   * 사용자 입력 유효성 체크 - 입력 개수가 3개가 아니면 다시 입력
3. 컴퓨터의 숫자와 플레이어의 숫자가 같은자리에 같은 숫자가 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트룰 출력한다.
   * 스트라이크가 3인경우 - 성공 메시지 출력
   * 스트라이크, 볼이 모두 없을경우 - 낫싱 메시지 출력
   * 스트라이크 갯수 + 볼 갯수 출력
4. 컴퓨터의 숫자를 모두 맞출때까지 이 과정을 반복한다.
5. 숫자를 맞춘다면 게임을 다시 시작하거나 종료할 수 있다.
   * 입력 유효 숫자 검증, 1과 2만 입력가능