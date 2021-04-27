# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

# 기능 요구사항
•기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
•같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를
얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
•[예] 상대방(컴퓨터)의 수가 425일 때,
123을 제시한 경우 : 1 스트라이크,
456을 제시한 경우 : 1 스트라이크 1볼,
789를 제시한 경우 : 낫싱
•위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
•이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
•게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

# 실행결과
숫자를 입력해주세요 : 123
1 스트라이크 1 볼
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1 스트라이크
숫자를 입력해주세요 : 713
3 스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1 스트라이크 1 볼

# 구현 기능 목록

## 숫자 생성/비교 기능
1. [O] 중복되지 않은 임의의 3자리 숫자를 생성
2. [O] 3자리 숫자 2개를 비교해 자리와 숫자가 일치하는 갯수 반환 (Strike)
3. [O] 3자리 숫자 2개를 비교해 자리는 일치하지 않지만 숫자가 일치하는 갯수 반환 (Ball)
   
## 입출력 기능
1. 일치하는 숫자와 일치하지 않는 갯수를 입력받아 출력
    - 모두 일치할 경우, '3개의 숫자를 모두 맞히셨습니다! 게임 종료. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.'
    - 0개가 일치할 경우, '낫싱'
    - n개 자리수 일치, 'n 스트라이크'
    - m개 자리수 불일치, 'y 볼'
    - n개 자리수 일치, m개 자리수 불일치, 'n 스트라이크 y 볼'

## 게임 진행
1. 게임 시작
   - 컴퓨터의 숫자를 생성
2. 사용자의 입력 확인 후 출력
3. 모두 맞혔을 경우, 사용자의 입력 처리
    - 게임 새로 시작 1
    - 게임 종료 2

# 설계
## FBGame class
1. 게임을 초기화한다
2. 게임 상태를 관리한다.
3. 게임 상태에 따라 사용자에게 메시지를 출력한다.
4. 사용자의 입력을 받아서 상태를 업데이트하거나 알려준다.

## FBGameState enum
게임의 진행 상태
1. INITIATED
2. ON_GOING
3. ENDED
