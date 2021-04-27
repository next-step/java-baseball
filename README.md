# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 설명
1. 랜덤값 생성
    - 1~9로 이루어진 수
    - 중복없는 수
    - 파라미터로 넘긴 수에 해당하는 길이의 값
2. 정답, 입력값 관련 유효성 검증
    - 3자리 이상일 경우 Exception
    - 첫자리가 0일경우 Exception
    - 중복된 수가 있을 경우 Exception
3. 게임 결과 비교
    - strike, ball 카운트
    - strike, ball 최대값 관련 validation
    - 게임결과 메세지 생성
4. 심판
    - 정답값과 입력값 strike, ball 판단
    - 결과를 담은 정보 return
5. 입출력
    - 숫자 입력
    - 결과를 담은 정보를 기준으로 message 출력
    - 게임 종료 message 출력
