# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 학습 테스트 Todo-list
- 모든 단위 테스트 메서드는 DisplayName 어노테이션으로 `의도`를 드러낸다.
- String 클래스
    - [X] "1,2"를 ,로 split 했을 때 분리 여부를 확인한다.
    - [X] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.
    - [X] "(1,2)" 값이 주어졌을 때 substring으로 "1,2"를 반환하는 학습을 진행한다.
    - [X] "abc" 값이 주어졌을 때 charAt 메서드를 활용해서 특정 위치의 문자를 가져오는 학습을 진행한다.
    - [X] charAt 메서드가 찾는 문자가 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인한다.
- Set Collection
    - [X] Set의 size 메서드를 활용해 Set의 크기를 확인하는 학습을 진행한다.
    - [X] contains 메서드를 통해 Set 안에 1,2,3의 값이 존재하는지 확인하는 학습을 진행한다
        - 제약조건: 반복문 없이 진행한다.
    - [X] contains 메서드를 통해 true인 경우와 false인 경우를 모두 확인하는 학습을 진행한다.

## 야구게임 Todo-list
- 도메인
    - [X] 야구게임숫자 구현
        - [X] 1 ~ 9 사이의 숫자를 입력받아서 객체를 생성할 수 있다.
        - [X] 범위를 벗어난 숫자로 객체 생성 시도 시 에러가 발생한다.
        - [X] 객체간 값 비교가 가능하다.
    - [X] 야구게임숫자 생성기 구현
        - [X] 중복이 없는 야구게임숫자 세개로 구성된 컬렉션을 반환한다.
        - [X] 숫자를 지정해서 생성할 수 있다.
        - [X] 숫자를 랜덤으로 생성할 수 있다.
        - 랜덤 여부는 향후 인수테스트에서 같은 숫자로 모든 게임을 클리어 하는지 확인할 예정
    - [X] 야구게임숫자 일급컬렉션 구현
        - [X] 일급컬렉션끼리 비교하여 index와 관계 없이 일치하는 야구게임숫자가 몇개인지 계산할 수 있다.
        - [X] 일급컬렉션끼리 비교하여 index까지 일치하는 야구게임숫자가 몇개인지 계산할 수 있다.
    - [X] 야구게임 구현
        - [X] 야구게임숫자 생성기를 주입받아서 게임을 초기화 할 수 있다.
        - [X] 야구게임숫자 컬렉션을 받아서 게임을 진행할 수 있다.
            - [X] 야구게임의 야구게임숫자 컬렉션과 인자로 전달된 야구게임숫자 컬렉션 중 몇개가 일치하는지 계산한다.
            - [X] 일치하는 공이 아예 없으면 포볼 결과를 반환한다.
            - [X] 일치하는 공 중 볼이 몇개인지 계산한다.
            - [X] 일치하는 공 중 스트라이크가 몇개인지 계산한다.
            - [X] 최종 결과값을 야구게임결과로 반환한다.
            - 각 공의 상태 정의
                - 볼: 일치하는 야구게임숫자의 개수
                - 스트라이크: 볼 중 index까지 일치하는 야구게임숫자의 개수
                - 포볼(or 낫싱): 일치하는 숫자가 아예 없는 경우
    - [X] 야구게임결과 구현
        - [X] 볼, 스트라이크, 포볼(or 낫싱)을 인자로 받아 객체를 생성할 수 있다.
        - [X] 포볼(or 낫싱)이 있는 경우 볼이나 스트라이크는 발생할 수 없다.
        - [X] 음수로 볼이나 스트라이크를 발생시킬 수 없다.
        - [X] 볼과 스트라이크의 총합은 최대 3을 넘을 수 없다.
- UI
    - [X] 사용자로부터 세자리의 숫자를 입력받는다.
        - [X] 입력값이 크기가 `중복없이` 3이 아닐 경우 예외를 발생시킨다.
        - [X] 입력값을 1자리씩 나눈다.
        - [X] 각 입력값을 야구게임숫자 컬렉션으로 변환한다.
        - [X] 입력값 전체를 야구게임숫자 일급 컬렉션으로 변환한다.
        - [X] 야구게임숫자로 유효하지 않은 입력값의 경우 예외를 발생시킨다.
            - 숫자가 아닌 값
            - 야구게임 숫자를 벗어난 값
    - [X] 야구게임을 1회 진행 후 사용자에게 결과를 보여준다.
        - [X] 야구게임을 1회 진행후 결과를 야구게임결과를 전달받는다.
        - [X] 야구게임결과를 사용자에게 보여주기 위해 String으로 파싱한다.
        - [X] 해당 결과값을 사용자에게 출력한다.
    - [X] 3스트라이크가 나올 때까지 게임을 진행한다.
    - [ ] 3스트라이크(사용자가 숫자를 모두 맞춘 경우) 시 추가 게임 진행 여부를 물어본다.
        - [ ] 추가 게임 진행 시 새로운 게임을 진행한다.
        - [ ] 게임 종료 시 프로그램이 종료된다.
