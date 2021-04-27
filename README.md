# 숫자 야구 게임

## 기능 요구사항

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
  

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 나으신이란힌트를
얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  


- [예] 상대방(컴퓨터) 의수가 425일 때, 123을 제시한 경우:1스트라이크, 456을 제시한 경우:1스트라이크 1볼, 789를 제시한 경우: 낫싱



- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개 를 선택한다.  
  게임플레어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.



- 이런 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다



- 게임을 종료한 후계임을 다시 시작하거나 완전히 종료할 수 있다.

## 구현 기능 목록
1. READEME.md 파일 구현 기능 목록 작성
2. 숫자야구 게임 시작 하기 위한 1 ~ 9까지 숫자 중에 중복하지 않는 3개의 숫자를 배열로 생성하는 기능
3. 게임 플레이어에게 입력 받은 숫자의 중복 여부와 길이를 확인하여 오류를 처리하는 기능
4. 게임 플레이어에게 입력 받은 숫자를 배열로 생성 하는 기능
5. 컴퓨터가 생성한 배열과 게임 플레이어가 입력한 배열을 비교하여 스트라이크, 볼, 낫싱을 리턴하는 기능
6. 2 ~ 6의 기능을 활용하여 숫자 야구게임의 입력, 출력, 반복을 제어하는 기능


