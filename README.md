## 기능 목록  
> ### 0. ui
>  * 입력과 출력을 담당하는 패키지
>  ```  
>  ✔ <<interface>> InputManager
>    - ScannerInputManager ( Scanner의 nextInt()를 통해 정수 input을 입력받는 기능 )
>  
>  ✔ <<interface>> OutputManager
>   - PrintOutputManager ( System.out의 print()를 통해 문자열 output을 출력하는 기능 )
>  ```

> ### 1. number 
>  * 야구게임 숫자 관련 패키지
>  ```
>  ✔ BaseballNumbers ( 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 가지는 일급 컬렉션 )
>  
>  ✔ <<interface>> NumbersGenerationStrategy
>   - RandomNumbersGenerationStrategy ( 랜덤한 BaseballNumbers를 발생하는 전략 )
>   - UserInputNumbersGenerationStrategy ( 입력에 의한 BaseballNumbers를 발생하는 전략 )
>  ```

>### 2. player
>  * 참가자 관련 패키지
>  ```
>  ✔ <<abstract>> Player ( NumbersGenerationStrategy 소유, strategy에 따라 BaseBallNumbers 가짐 )
>   - Computer ( 랜덤한 BaseballNumbers 소유 )
>   - User ( 입력에 의한 BaseballNumbers 소유 )
>  ```

>### 3. game
>  * Computer vs User 게임 패키지
>  ```
>  ✔ Game ( Player를 각각 2명 소유, GameState 소유, state를 바꾸면서 게임 흐름 전개 )
>  
>  ✔ <<interface>> GameState 
>   - InitState ( 초기화: computer의 랜덤 BaseballNumbers 생성 )
>   - RunningState ( 실행: user의 입력 BaseballNumbers 생성 )
>   - ThreeStrikeState ( 삼진: threeStrike 체크 )
>   - StrikeAndBallState ( 스트라이크와 볼: strike와 ball 체크 )
>   - NothingState ( 낫싱: 낫싱 체크 )
>   - EndState ( 게임 종료: 새 게임 시작여부 체크 )
>   - ExitState ( 끝 )
>  ```


## 게임 흐름도
![image](https://user-images.githubusercontent.com/17541680/115879287-7295f280-a484-11eb-8eb2-6ccac4896d5a.png)

