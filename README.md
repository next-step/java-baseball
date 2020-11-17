# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    * ex. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 기능 목록
* 1-9 사이의 임의의 수 3개를 선정한다.  
단, 선정된 숫자 3개는 중복되지 않아야 하며, 중복되지 않는 임의의 수 3개를 찾기 위한 최대 시도 횟수는 30번으로 한다.  
최대 횟수를 넘길 경우 게임 생성 실패로 판단한다.
* 사용자로부터 1-9 사이의 숫자 세 개를 입력받는다.  
숫자가 아니거나, 범위를 벗어나면 에러를 발생시키고 다시 입력받는다.
* 입력받은 숫자(user)와 선정된 숫자(computer)에 대한 일치 여부를 숫자 야구 룰에 따라 판정하고 출력한다.
* 세 숫자를 모두 맞추면 게임이 종료되고, 사용자는 게임이 종료될 때마다 새 게임을 다시 시작하거나 완전히 종료할 수 있다.
