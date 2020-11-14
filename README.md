# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Junit 학습 테스트 요구사항
- ##### 공통
    - [x] `JUnit`의 `@DisplayName`을 활용해 테스트 메소드의 `의도`를 드러낸다.
- ##### String 클래스에 대한 학습 테스트
    - [x] "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인한다.
    - [x] "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.
    - [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 "1,2"를 반환할 수 있는지 확인한다.
    - [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있는지 확인한다.
    - [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
          StringIndexOutOfBoundsException이 발생하는지 확인한다.
- ##### Set Collection에 대한 학습 테스트
    - [x] Set의 size() 메소드를 활용해 Set의 크기를 확인한다.
    - [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.
        - 중복(반복) 코드를 제거
    - [x] Set의 contains() 메소드 실행결과 true 인 경우에, 입력 값에 따라 결과 값이 다른 경우에 대한 테스트를 하나의 Test Case에서 구현한다.