# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

### Keywards
- Innings : 야구에서 한 라운드를 1이닝이라고 합니다.
- out, strike, ball, nothing 의 네가지 결과가 있습니다.

## 처음 생각한 구조

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
    InningsResult getInningsResult(String inningsResult); //1이닝이 들어오면, 결과를 돌려주는 함수입니다.
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

## 처음 생각한 것을 구현하면서 어려웠던 점
- 입력과 출력하는 하는 부분을 분리해서 별도의 클래스로 구분지었는데, 그러다보니 해당 로직이 깨끗하지 않았습니다.
- if, else 문을 어떻게 하면 단순하게 할 수 있을까? 특히, 조건에 따라서 게임이 종료되는 로직이 있는데, 해당 부분이 어려웠습니다.

## 나 혼자 리팩토링

### 관심사 분리
- 입력과 출력 (View)
- 게임의 로직처리 (Presenter) + 게임의 종료 조건 검사 (BaseballJudgment)
- 게임의 결과 모델 (Model)

### 게임의 주된 로직

- play 로직 : 새로운 게임 시작 -> 이닝 시작 -> 이닝 종료 -> 매치가 종료되었는 지 체크 -> 게임 종료 체
  
```java
    @Override
    public void play(){
        playNewGame();
        do {
            playInnings();
            playEndInnings();
            checkFinishGame(checkEndMatch());
        } while(isContinueGame());
    }
```

- BaseballNumber : 게임에서 숫자 야구의 난수를 만들고, 이닝을 입력시에 확인하는 역할을 담당
  
```java
    public interface BaseballNumber {
        void makeRandomAnswer();
        InningsResult solveAnswer(String oneInnings);
    }
```

- BaseballJudgment : BaseballNumber를 갖고 있어, 게임의 시작, 종료와 같은 상태를 체크하는 역할

```java
    public interface BaseballJudgment {
        void playNewGame();
        void putInningsResult(String oneInnings); //1이닝이 들어오면, 결과를 돌려주는 함수입니다.
        InningsResult getCurrentInnings();
        boolean isContinueGame();
        void nextMatch(boolean isFinishGame);
    }
```

- BaseballPresenter : 게임에서 로직을 처리하는 역할을 담당

```java
    public interface BaseballPresenter {
        void setBaseBallView(BaseballView baseBallView);
        void play();
    }
```

- BaseballView : 게임에서 뷰에 대한 역할을 담당
```java
    public interface BaseballView {
        void printStartInnings();
        String inputOneInnings();
        void printInningsResult(InningsResult inningsResult);
        void printFinishInnings();
        boolean inputIsFinishGame();
    }
```

### 혼자서 리팩토링을 하고 얻은 점
- 입출력을 하나의 뷰로 처리해서 로직의 깨끗함을 얻을 수 있었다.
- Judgment를 통해서만 BaseballNumber의 데이터를 관리할 수 있었다.

### 혼자서 리팩토링을 하고 아쉬운 점
- if문을 어떻게 하면 없앨 수 있을까에 대한 고민을 많이 했다.
- 리팩토링을 하면서 START, END와 같은 상태를 통해서 구현을 했는데, 상태와 함께 로직을 처리하는 것이 어려웠다. 숫자 야구에는 여러 가지 상태를 처리해야 할텐데, 이 때 쉽게 생각나는 것은 if문이나 switch문인데, 이러한 생각에서 벗어나는 방법이 궁금했고, 이러한 점을 객체로 처리할 수 있는 지 궁금했다.
- 어떠한 관점에서, 어느 크기로 기능을 나누는 지도 궁금했다.
- 코드를 예쁘게 짜는 다양한 방법들이 너무 궁금하다.

### 함께 리팩토링을 하면서 다양한 관점들을 배우고 싶다.