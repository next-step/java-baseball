# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


프리코스 숫자야구게임 정의서

[개요]
- 상대방(PC)와 사용자(본인)과 서로다른 수로 이루어진 3자리 수를 맞추는 게임

[기준 및 정책]
1. 숫자 생성 기준
    - 3자리수의 서로 다른 수가 되어야한다.
    - 세자리 중 한자리 숫자의 크고 낮음에 따라 위치변동하지 않고 램덤으로 한다.

2. 판정기준
    - 스트라이트 : 같은 수, 같은 자리가 맞는 경우
    - 볼 : 같은 수, 다른 자리가 맞는 경우
    - 낫싱 : 같은 수가 없는경우
    - 예시
        * 상대방이 제시한 수 : 478
        * 사용자가 입력한 수
            * 478 : 3 스트라이크
            * 487 : 1 스트라이크, 2볼
            * 754 : 2볼
            * 123 : 낫싱

[기능요구사항]
1. 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 판정기준에 맞춘다
2. 스트라이크 3개를 맞출때까지 맞춘다.
3. 스트라이크 3개를 맞추게 되면 사용자에게 게임시작여부를 묻는다
4. 게임시작여부는 1이면 게임을 새로 시작, 2이면 게임을 종료한다.


[변수 목록]

Integer digitNumber

    설명
        - 램덤 숫자 자리 수
Integer pitcherNumer

    설명
        - getRandomNumber함수에서 나온 digit_number를 받아와 변수에 담는다
Integer batterNumer

    설명
        - 사용자의 입력 값



[함수 기능 목록]
checkNumberIdentify(int checkNumber)

    - 변수 설명
        - checkNumber : 동일성을 체크하는 대상 숫자
    - 결과 값
        - boolean resultIdentify : 숫자의 동일성 여부
    - 기능 설명
        - checkNumber 받아 숫자 중 동일한 숫자가 있는지 확인한다.

getRandomNumber(int digitNumber)

    - 변수 설명
        - digitNumber : 램덤 숫자 생성 자리수
    - 결과 값
        - int resultNumger : 서로다른 램덤 숫자
    - 기능 설명
        - digitNumber 받아 해당 자리수 만큼 램던 숫자를 생성한다. 단 숫자는 서로 달라야 한다.

getBattingResult(int tagetNumber, int strikeNumber)

    -변수 설명
        - strikeNumber : getRandomNumber 함수의 결과 값
        - tagetNumber : strikeNumber 비교할 대상
    -결과 값
        - List<int>[2] resultList: (스트라이크 수, 볼 수)
    -기능 설명
        - tagetNumber 받아 strikeNumber와 동일성 여부를 체크하여 "기본 및 정책 - 판정기준"에 따라 결과 값을 표출한다.
              

		