# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 과제 진행 요구사항 정리
1. 기능 요구사항
    1. 숫자 야구게임 구현 (3자리)
1. 프로그래밍 요구사항
    1. 코드 컨벤션 지키기
    1. 인덴트 1depth 까지 허용.
    1. stream api 사용, else 사용, 함수 라인 10라인 넘어가기 금지.
    1. 단위 테스트 구현. (Junit5, AssertJ)
1. 과제 진행 요구사항
    1. 기능 목록을 만들기.
    1. 만든 기능 목록 단위로 commit.
    1. commit log는 [AngularJS Commit message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 대로 진행한다.

## 구현 Task 목록 설계
### 기본 프로그램 구조
- 게임 시작
    - Console 입력
    - 입력 데이터 Validation (3자리, 모두 숫자)
- 게임 진행
    - 게임 준비 (랜덤 3자리 숫자)
    - 스트라이크 체크
    - 볼 체크 
- 게임 종료 조건
    - 3 스트라이크
- 게임 종료 이후
	- 게임 재 시작
	- 프로그램 종료

### 기타
- 게임 종료하고 싶을 때 종료하기
