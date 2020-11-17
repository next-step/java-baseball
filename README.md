# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현 목록
- [X] 히든숫자생성
    - [X] 1~9까지 서로 다른 3자리수 생성
    - [X] 히든 숫자 초기화

- [X] 데이터 유효성 확인
    - [X] 숫자가 중복되었는지 확인
    - [X] 숫자 범위가 1-9 확인
    - [X] 3자리 수 확인

- [X] 게임판정
	- [X] 같은자리에 있으면 스트라이크
	- [X] 다른자리에 있으면 볼
	- [X] 동일한 숫자 없으면 포볼
	- [X] 3자리가 모두 스트라이크 게임 종료
	
- [X] 플레이어 
    - [X] 요청 숫자 유효성 확인
    - [X] 계속 할 지 여부 확인

- [X] 게임결과
    - [X] 포볼
    - [X] 스트라이크 아웃
    - [X] 1 스트라이트 2볼
    - [X] 1 스트라이크
    - [X] 2 볼
    - [X] 피칭 계속
    - [X] 피칭 종료
    - [X] 결과메시지 확인
    
- [X] 디스플레이 생성
    - [X] 숫자 요청 메시지
    - [X] 결과 메시지
    - [X] 재실행 메시지
    - [X] 에러 메시지

- [X] 경기진행
    - [X] 스트라이크 아웃
    - [X] 경기 재시작
    - [X] 경기 연장 안함
