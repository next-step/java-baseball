# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

# 학습 테스트
## String 학습 테스트 요구사항
### 요구사항 1
* [X] "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
* [X] "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

### 요구사항 2
* [X] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
하도록 구현한다.

### 요구사항 3
* [X] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
* [X] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 
  StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* [X] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

## Set 학습 테스트 요구사항
### 요구사항 1
* [X] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

### 요구사항 2
* [ ] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현
* [ ] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다
