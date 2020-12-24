# 숫자 야구 게임
## Computer
- nextTurn() : 컴퓨터의 다음 난수를 반환한다.

## User
- nextTurn() : 유저로부터 입력을 받고 반환한다.

## Result
- strikeCounts : 스트라이크 횟수를 저장한다.
- ballCounts : 볼 횟수를 저장한다.

## Judge
- getResults(userTurn, computerTurn) : 유저의 값과 컴퓨터의 값을 통해 결과를 반환한다.
- getStrikeCounts(userTurn, computerTurn) : 유저의 값과 컴퓨터의 값을 통해 스트라이크 횟수를 반환한다.
- getBallCounts(userTurn, computerTurn) : 유저의 값과 컴퓨터의 값을 통해 볼 횟수를 반환한다.

## BaseballSimulator
- doSimulation() : 숫자 야구 게임을 진행한다.