# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 구현할 기능 목록 :heart: 꺄
1. 입출력 Client 생성.
   - 작업 클래스 명 : NumberBaseBallGame.Client.class
   - 상세 : main 스레드와 입출력 프로그램 실행
        클라이언트와 대화를 위한 콘솔 입/출력 제어.
        a. 숫자 입력받기
        b. 결과 출력 (스트라이크 / 볼 / 낫싱)
        c. 모두 맞출때까지 a.b. 단계 반복
        d. 모두 맞춘경우. 축하 메세지와 '새로운 게임 시작' / '종료' 여부 출력
        e. '새로운 게임 시작 여부' 선택 시 a.부터 다시 시작
        f. '종료'시 프로세스 종료

2. 대결 준비
   - 작업 클래스 명 : NumberBaseBallGame.GenerateGameNumber.class
   - 상세 : 대결용 임의의 수 1 ~ 9 사이 서로다른 Random 수 3개 생성
          클라이언트와 대화할 DTO 인터페이스 생성
   
3. 게임
   - 작업 클래스 명 : NumberBaseBallGame.PlayGame.class
   - 상세 : 클라이언트 입력한 1 ~ 9 사이 서로다른 3자리의 수 비교.
        a. 결과값은 모두 맞춘 경우와 그렇지 못한 경우로 힌트 메세지와 모두 맞춘 여부가 반환된다.
    
4. 스트라이크
   - 작업 클래스 명 : NumberBaseBallGame.PlayGame.class
   - 상세 : 같은 수, 같은 자리 '스트라이크' 힌트 기능
    
5. 볼
    - 작업 클래스 명 : NumberBaseBallGame.PlayGame.class
    - 상세 : 같은 수, 다른 자리 '볼' 힌트 기능

6. 포볼 / 낫싱
    - 작업 클래스 명 : NumberBaseBallGame.PlayGame.class
    - 상세 : 같은 수 0 '포볼', '낫싱' 기능

인터페이스는 hint / finish 로 클라이언트와 대화한다.
- hint : 스트라이크 / 볼 / 나싱 갯수와 메세지
- finish : 종료여부 :: 숫자를 모두 맞췄을 경우 true / 아닐경우 false

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
