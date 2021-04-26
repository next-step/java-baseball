# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
1.  1~9까지 서로 다른 수로 이루어진 3자리 숫자, 목표 숫자를 생성하는 기능<br>
    <br>
2.  사용자의 1~9까지 서로 다른 수로 이루어진 3자리 숫자를 입력받는 기능<br>
    <br>
3.  목표 숫자와 사용자가 입력한 숫자를 비교하여 스트라이크, 볼, 낫싱을 판별하는 기능<br>
    <br>
4.  게임을 종료할지, 다시 시작할지 결정하는 명령어 기능<br>
    <br>
5.  예외 처리


## 프로그램 부가설명
1.  BaseBallGame의 main method로 BaseBallGameManager를 실행
2.  BaseBallGameManager는 게임 데이터 초기화, 게임 플레이, 재시작 여부 확인의 전반적인 게임 흐름을 제어한다.
3.  BaseBallGamerAction를 통해 Console로부터 사용자의 입력값을 받고, 객체화시킨다.
4.  BaseBallGamePlayService를 통해 숫자 야구 게임을 진행한다.

## 작성자
email 주소: wnwlals22@naver.com
