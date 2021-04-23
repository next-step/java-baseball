# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next*step/nextstep*docs/tree/master/precourse)

## 기능 요구 사항
**1~9 서로 다른 3자리 정수 맞추기**   

**판단 조건**   
* 같은수 같은자리 = 스트라이크
* 같은수 다른자리 = 볼
* 같은수 없을시 = 낫싱   

**진행 프로세스**
* 상대방(컴퓨터) 1~9 서로 다른 3자리 정수 생성
* 플레이어 3자리 수 입력
* 입력한 숫자에 대한 결과 출력
* 3자리수 모두 맞추면 게임 종료
* 게임 종료 후 종료/재시작 선택가능

## 프로그래밍 요구 사항

**메소드 분리**   
* 자바 코드 컨벤션 준수   
* indent 1까지 허용   
* Stream Api 사용 금지, 람다는 사용 가능   
* else 예약어 쓰지 않는다.   
* 메소드 길이 10라인 이내, 메소드 역할 분리   
   
**단위 테스트**   
* 로직에 단위테스트 구현 (UI 로직은 제외)   
* Junit5 사용   

## 사전 작업
* [x] IntelliJ에서 Junit test case 생성 
* [ ] String 클래스 연습
    * [x] split() 테스트
        * [x] assertj > contains()
        * [x] assertj > containsExactly()
    * [ ] substring() 테스트
    * [ ] charAt() 테스트
    * [ ] charAt() - OBE 테스트
    * [ ] @DisplayName 활용 - 메소드 의도
* [ ] SetCollection 테스트
    * [ ] size() 테스트
    * [ ] Junit ParameterizedTest 활용
    * [ ] 입력 값이 다른 경우의 테스트
    
## 구현 기능 목록   
* [ ] UI 시작
* [ ] 서로 다른 3자리 정수 생성
* [ ] 플레이어 3자리 정수 입력 받기
* [ ] 입력 값 유효성 검증
* [ ] 입력값 판단
    * [ ]  스트라이크 판단
    * [ ]  볼 판단
    * [ ]  나씽 판단 
* [ ]  정답여부 확인
* [ ]  게임 재개여부 확인
* [ ]  UI 종료

## 참조
* 코드 컨벤션 : <https://naver.github.io/hackday-conventions-java/>   
* .gitattribute : <https://velog.io/@pks787/GitHub-CRLF-%EC%98%A4%EB%A5%98-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95>
* AssertJ Exception : <https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html>
* Parameterized Tests : <https://www.baeldung.com/parameterized-tests-junit-5>
* AssertJ 활용: <https://www.baeldung.com/introduction-to-assertj>
* commit message convention : <https://gist.github.com/stephenparish/9941e89d80e2bc58a153>
