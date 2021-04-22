## 기능 목록  
>0. I/O Util
>  ```
>  입력과 출력을 담당하는 유틸리티
>  - InputUtil
>  - OutputUtil
>  ```

>1. Number (일급 컬렉션)
>  ```
>  1부터 9까지 서로 다른 수로 이루어진 3자리의 수
>  - BallNumber
>  - BallNumbers 
>  - Stragety ( 랜덤한 세자리 수 발생 / 입력에 의한 세자리 수 발생 )
>  ```

>2. Player
>  ```
>  참가자
>   - Computer (랜덤한 숫자 소유)
>   - Person (입력에 의한 숫자 소유)
>  ```

>3. Game
>  ```
>  Computer vs Person의 게임
>  - State (init -> process(threeStrike -> strikeOrBall -> nothing) -> finish -> exit)
>  ```
