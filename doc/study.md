# 프리코스 진행하면서 공부한 것들 정리 

### Junit 
- @ParameterizedTest 어노테이션을 통해 여러 값들로 테스트를 할 수 있다.
- @CsvSource 어노테이션을 통해 key , value 형태의 파라미터들을 테스트 할 수 있다. 
- @MethodSource 어노테이션을 통해 작성한 파라미터들로 테스트를 할 수 있다. 

### assertThat vs assertXXX 
- assertThat 은 Junit 4.4 부터 추가됐다. 
- assertThat 이 assertXXX 를 사용할 때 보다 더 읽기 쉽다. 
    ~~~ java
        assertEquals(expected, actual);
    ~~~
    ~~~ java
        assertThat(actual, is(equalTo(expected)));
    ~~~
- assertThat 은 더 나은 에러 메시지를 제공한다.
- assertThat 을 사용하면 Type 에 대한 안정성도 얻을 수 있다. 

### 기타 
- Set 은 중복을 허용하지 않고, 저장순서가 유지되지 않으며, 인덱스로 조회 할 수 없다. 
- 정해진 범위의 랜덤값을 구하는 경우
    ~~~ java
        Math.random() * (max - min)) + min
    ~~~
- 문자열의 숫자 형태 검사 
    - 구글링 해보면 문자열의 숫자 검사 하는 형태는 다음과 같다.
    ~~~ java
        try {
            String str = "123";
            Integer.parserInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    ~~~
    - 그런데 문자열을 확인하는 메소드를 빈번하게 사용하고, 예외가 많다면 많은 익셉션이 발생하므로 썩 좋아 보이지 않아서 이 프로젝트에서는 정규식으로 문자열의 숫자를 판별하였다. 
    ~~~ java
        String str = "123";
        String regExp = "^[0-9]+$";
        boolean result = input.matches(regExp)
    ~~~
  