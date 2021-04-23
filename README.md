# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
## TODO
- [X] Computer choose 3 different numbers <br/>
  > [BaseballNumber (Builder Pattern)](./src/main/java/baseball/model/BaseballNumber.java)
  ```java
  public class Main {
    public static void main(String[] args) {
      BaseballNumber answer = BaseballNumber.builder()
                .size(size)
                .radix(radix)
                .build();
    }
  }
  ```
- [ ] Handling Exception BaseballNumberFormatException  
- [ ] Segregation Random Interface from BaseballNumber class (Strategy Pattern)

- [X] Tell the baseBallResult of trial
  > [BaseballResult (Factory Pattern)](./src/main/java/baseball/model/BaseballResult.java)
  ```java
  public class Main {
    public static void main(String[] args) {
      BaseballResult trialResult = BaseballResult.calcResult(answer, trialBaseballNumber);
    }
  }
  ```
- [X] If completed, ask "Restart: 1, Exit: 2"
- [X] Logic Layer / UI Layer Separation
  - [BaseballApplication](./src/main/java/baseball/BaseballApplication.java)
    ```java
    public class BaseballApplication {
    private static BaseballView baseballView = new BaseballViewImpl();
    private static BaseballControllerTemplate baseballControllerTemplate = new BaseballController(baseballView);
    private static BaseballConfig config = new BaseballConfig(3, 10, 0);    // size, radix, tryCount
    
        public static void main(String[] args) {
            BaseballApplication.run(BaseballApplication.class, args);
        }
    
        static public <T> void run(Class<T> clazz, String[] args) {
            baseballControllerTemplate.run(config);
        }
    }
    ```
  - [BaseballControllerTemplate](./src/main/java/baseball/controller/BaseballControllerTemplate.java)
    > Logical Controller (Template Pattern)
  - [BaseballView](./src/main/java/baseball/view/BaseballView.java)
    > View & I/O Component (Interface)
  - [BaseballConfig](./src/main/java/baseball/config/BaseballConfig.java)
    > Config Bean
- [X] Bridge Pattern in View (InputStream, OutputStream)
- [ ] Message Properties (View)  
- [ ] JUnit5, AssertJ Unit Test


---
## Functionality Requirements
- [X] Computer choose 3 different numbers
- [X] Tell the baseBallResult of trial
- [X] If completed, ask "Restart: 1, Exit: 2"

## Programming Requirements
1. Interface Segregation Principle (Method Separation)
    - [https://naver.github.io/hackday-conventions-java/](https://naver.github.io/hackday-conventions-java/)
    - Indent depth max: 1
    - Don't use Stream API, but Lambda is allowed.
    - Don't use "else" and "switch/case".
    - Method Code Line max : 10
    - Method has only one responsibility. (SRP)

2. Unit Test
    - Implement unit test for logic. (But not need for UI Layer.)
    - Logic Layer, UI Layer
    - Using JUnit5, AssertJ

## Project Requirements
- [https://github.com/next-step/java-baseball-precourse](https://github.com/next-step/java-baseball-precourse)
- [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- [커밋 메시지 규약 정리 (the AngularJS commit conventions)](https://velog.io/@outstandingboy/Git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%EA%B7%9C%EC%95%BD-%EC%A0%95%EB%A6%AC-the-AngularJS-commit-conventions)

