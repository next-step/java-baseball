# 숫자 야구 게임
## 진행 방법
- 숫자 야구 게임 요구사항을 파악한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
- [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 학습 테스트
- [x] import한 저장소의 src/test/java 학습 테스트를 위한 패키지를 생성한다.
    - [x] 예를 들어 study 
- [x] 단위 테스트를 위한 클래스 명명 규칙("테스트 대상 클래스명 + Test")에 따라 클래스를 생성한다.
- [x] 예를 들어 String에 대한 학습 테스트 클래스는 StringTest 다음 요구사항을 구현하면서 JUnit과 AssertJ 사용법을 익힌다.

### String 클래스에 대한 학습 테스트
#### 요구사항 1
- [x] "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- [x] "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

##### 힌트
- [x] 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
- [x] 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다

#### 요구사항 2
- [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.

#### 요구사항 3
- [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
- [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 
StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

##### 힌트
- AssertJ Exception Assertions 문서 참고
```java
import static org.assertj.core.api.Assertions.*;

assertThatThrownBy(() -> {
...
}).isInstanceOf(IndexOutOfBoundsException.class)
.hasMessageContaining("Index: 2, Size: 2"); 
```

```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
.isThrownBy(() -> {
// ...
}).withMessageMatching("Index: \\d+, Size: \\d+");
```

- 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    - assertThatIllegalArgumentException()
    - assertThatIllegalStateException()
    - assertThatIOException()
    - assertThatNullPointerException()
    
### Set Collection에 대한 학습 테스트
- 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.

```java
public class SetTest {

    private Set<Integer> numbers;
    
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
}
```

#### 요구사항 1
- [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

#### 요구사항 2
- [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

```java
@Test
void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
}
```

##### 힌트
- [x] Guide to JUnit 5 Parameterized Tests
```java
@ParameterizedTest
@ValueSource(strings = {"", " "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```

#### 요구사항 3
- [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- [x] 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

##### 힌트
- [x] Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
```java
@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
    String actualValue = input.toLowerCase();
    assertEquals(expected, actualValue);
}
```

## 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우: 1 스트라이크, 456을 제시한 경우 : 1스트라이크 1볼, 789를 제시한 경우 : 낫싱
- 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료 된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

### 프로그램 실행 결과
```
숫자를 입력해주세요 : 123
1 스트라이크 1 볼
숫자를 입력해주세요 : 145
1 볼
숫자를 입력해주세요 : 671
2 볼
숫자를 입력해주세요 : 216
1 스트라이크
숫자를 입력해주세요 : 713
3 스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1 스트라이크 1 볼
```

### 프로그래밍 요구사항 - 메소드 분리
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
    - https://naver.github.io/hackday-conventions-java/
- indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단,람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는메소드)가 한 가지 일만 잘 하도록 구현한다.

### 프로그래밍 요구사항 - 단위 테스트
- 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in,Scanner) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- JUnit5 와AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습 테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 
사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

### 과제 진행 요구사항
- [x] 미션은 https://github.com/next-step/java-baseball 저장소를 fork/clone해 시작한다.
- [x] 기능을 구현하기 전에 java-baseball/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
- [x] AngularJS Commit Message Conventions 참고해 commit log를 남긴다.
- [x] 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

### 요구사항
- `야구 게임(Baseball Game)`
    - 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
    - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우: 1 스트라이크, 456을 제시한 경우 : 1스트라이크 1볼, 789를 제시한 경우 : 낫싱
    - 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    - 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료 된다.
    - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

- `심판(Referee)`
    - `볼들(Balls)`을 비교하는 역할을 한다.
    - [x] `판독기(Reader)`로 `판정(Judge)`한 결과로 `판정 보고서(Judge Report)`를 만든다.

- `판독기(Reader)`
    - [x] 위치와 숫자가 같다면 `Strike`로 `판정(Judge)`한다.
    - [x] 위치가 다르고 숫자만 같다면 `Ball`로 `판정(Judge)`한다.
    - [x] 위치와 숫자 모두 다르다면 `Miss`로 `판정(Judge)`한다.
    - [x] 모든 조건에 일치하지 않으면 예외처리 한다.

- `볼들(Balls)`
    - `투수(Pitcher)`가 던진 3개의 `볼(Ball)`들을 의미한다.
    - [x] 3개의 `볼(Ball)`을 가진다.
    - [x] `볼(Ball)`의 값이 중복될 수 없다.
    - [x] 특정 위치의 `볼(Ball)`을 비교할 수 있다. 
    - [x] `볼(Ball)`을 포함하는지 확인할 수 있다. 

- `볼(Ball)`
    - `투수(Pitcher)`가 던진 하나의 숫자를 의미한다.
    - [x] 1 ~ 9 사이의 값만 허용한다.
    - [x] `볼(Ball)`이 일치하는지 비교할 수 있다.

- `판정(Judge)`
    - `투수(Pitcher)`와 `포수(Catcher)`의 `볼(Ball)`을 비교한 결과를 나타낸다.
    - `Strike`, `Ball`, `Miss` 의 값을 나타낸다.

- `판정 보고서(Judge Report)`
    - `판정(Judge)`에 대한 통계를 나타낸다.
    - [x] 3 스트라이크인지 판단할 수 있다.
    - [x] 낫싱을 판단할 수 있다.
        - 낫싱은 모든 `판정(Judge)`이 `Miss`라는 의미를 나타낸다.
          
