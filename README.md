# 숫자 야구 게임

## 진행 방법

1. `1`부터 `9`까지 서로 다른 수로 이루어진 3자리의 수를 입력합니다.
2. 숫자와 위치가 모두 일치하는 경우 `스트라이크`,  
   숫자는 맞았으나 위치가 다를 경우 `볼`,  
   같은 수가 전혀 없으면 `낫싱`이 출력됩니다.
3. 숫자와 위치를 완벽하게 맞춘 경우 게임을 새로 시작하려면 `1`, 종료하려면 `2`를 입력합니다.

## 구현할 기능 목록

### NumberBaseball (UI)

```java
// 유저가 정답을 맞출 때까지 게임을 진행합니다.
void playGame();

// 유저가 입력한 답안을 채점하고 결과를 출력합니다.
boolean scoreInput();

// 유저에게 출력할 result string을 만들어 반환합니다.
String buildResultString(int strikeCount, int ballCount);

// 유저에게 게임을 새로 시작할지 묻고, 결과를 반환합니다.
boolean askReplay();
```

### BaseballCalculator (Game Logic)

```java
// 유저가 맞춰야할 정답을 랜덤으로 생성해 반환합니다.
String getRandomAnswer();

// 기선정된 숫자로 이루어진 문자열을 입력받고 겹치지 않는 숫자를 랜덤으로 생성해 반환합니다.
String getRandomNumber(String existingNumber);

// 정답과 유저 인풋을 입력받아 strike 개수를 반환합니다.
int getStrikeCount(String answer, String input);

// 정답 문자와 유저 인풋 문자를 입력받아 strike 여부를 반환합니다.
int isStrike(char answer, char input);

// 정답과 유저 인풋을 입력받아 ball 개수를 반환합니다.
int getBallCount(String answer, String input)

// 정답 문자와 유저 인풋 문자, 위치를 입력받아 ball 여부를 반환합니다.
int isBall(String answer, char input, int position)
```
