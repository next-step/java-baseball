# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

### Keywards
- Innings : 야구에서 한 라운드를 1이닝이라고 합니다.

### InputBehavior : 숫자 야구에서 입력을 관리하는 인터페이스

``` java

public interface InputBehavior {
    String inputOneInnings(); //야구의 1이닝의 3개의 카운트를 입력하는 함수입니다.
    boolean inputIsFinishGame(); //야구 게임을 끝낼 지, 물어보는 입력 함수입니다.
}

```

- JudgmentBehavior : 이닝에 대한 결과를 판단하는 인터페이스

``` java

interface JudgmentBehavior {
    InningsResult getInningsResult(String oneInnings); //1이닝이 들어오면, 결과를 돌려주는 함수입니다.
}


``` 

- PrintBehavior : 숫자 야구에 대한 게임 진행애서 출력을 관리하는 인터페이스

``` java

interface PrintBehavior {
    void printStartInnings(); //이닝이 시작할 때, 이닝 시작의 멘트를 보여주는 함수입니다.
    void printInningsResult(InningsResult inningsResult); //이닝 결과를 보여주는 함수입니다.
    void printIsFinishGame(); // 게임이 끝났을 때, 더 할 지 묻는 함수입니다.
}

```

- GameHost : 숫자 야구를 플레이를 관리하는 함수입니다.

``` Java

interface GameHost {
    void playGame();
}

```
