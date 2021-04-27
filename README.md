## 주요 기능 목록
* java-baseball-precourse/src/main/java/
    - BaseballApplication.java : 숫자 야구 게임 main 메소드로 Game을 호출하여 게임을 시작한다.
    
* java-baseball-precourse/src/main/java/exception/
    - BallException.java : Ball.java에서 Exception이 발생할 시 사용
    
* java-baseball-precourse/src/main/java/util/
    - Util.java : 숫자 야구 게임에서 사용 할 util
    
* java-baseball-precourse/src/main/java/domain/
    - Catcher.java : 게임에서 컴퓨터로 컴퓨터 공을 생성한다.
    - Player.java : 게임에서 사용자로 사용자 공을 입력받는다.
    - Ball.java :  Catcher와 Player의 공을 저장하고 공 관련 validation 체크를 한다.
    - Game.java : Game의 게임 시작, 게임 종료 등 게임을 구성하고있다.
    - Judgment.java : Catcher와 Player의 Ball을 비교하여 STRIKE, BALL, NOTHING을 카운트하고 출력한다.
    


## 테스트 목록
* java-baseball-precourse/src/test/java/domain/
    - BallTest.java : ball 생성 성공, 실패에 대한 테스트 코드
    - JudgmentTest.java : 컴퓨터와 사용자 공 비교 판단에 대한 테스트코드
