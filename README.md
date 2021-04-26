# 숫자 야구 게임

## 게임 설명

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크,다른자리에 있으면 볼,같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고,그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다
    - 예시) 상대방(컴퓨터)의수가425일때,123을제시한경우:1스트라이크,456을제시한경우:1스트라이크1볼, 789를제시한경우:낫싱

## 게임 방법

* 입력: 1~9자리 숫자3개
* 출력: 스트라이크, 볼 개수 혹은 낫싱

## 기능 목록

1. 사용자 입/출력
    * 숫자 입력
    * 결과 출력
    * 게임 진행 여부 입력
2. 게임 core 로직 실행
    * 스트라이크, 볼 여부 확인 및 개수 계산
    * 랜덤 숫자 생성 
	
## 디렉토리 구조
```
  baseball-precourse
    │  .classpath
    │  .gitignore
    │  .project
    │  build.gradle
    │  gradlew
    │  gradlew.bat
    │  README.md
    │      
    ├─src
        ├─main
        │  └─java
        │      ├─common
        │      │  ├─code
        │      │  │      GameErrorCode.java    공통 에러 코드
        │      │  │      HintType.java         hint type 코드
        │      │  │      
        │      │  ├─exception
        │      │  │      GameException.java    공통 Exception
        │      │  │      
        │      │  └─models
        │      │          HintModel.java       hint type object
        │      │          ThreeNumbers.java    three number object
        │      │          
        │      └─game
        │          └─baseball
        │                  GameApp.java        output/input(view)
        │                  GameCore.java       game core logic
        │                  GamePlayer.java     game start/stop
        │                  
        └─test
            └─java
                ├─common
                │  └─models
                │          ThreeNumbersTest.java
                │          
                └─game
                    └─baseball
                            GameCoreTest.java
                            GamePlayerTest.java
```