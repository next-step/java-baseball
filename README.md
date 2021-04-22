# 숫자 야구 게임

## 기능 구현 목록
### 1. 게임 머신(=컴퓨터)
게임을 수행하는 컴퓨터 역할을 하는 머신을 `게임 머신` 이라 명명한다.   
`게임 머신`은 다음 기능을 가진다.

#### 1.1 게임 랜덤값 설정
새 게임이 시작할 때 3개의 랜덤 숫자를 가진다.
* 랜덤 숫자는 1~9까지 각각 서로 다른 수여야 한다. 
* 테스트 편의성을 위해 생성자로 지정된 숫자를 받을 수 있고, 세팅 된 값을 전달 할 수 있다.

#### 1.2 유효성 검사 
사용자가 전달한 3자리 값(=길이가 3인 문자열 배열)이 올바른지 확인 한다.  
확인 기준은 다음과 같다.
    * 배열의 길이는 3이어야 한다.
    * 숫자 이외에 어떠한 문자도 허용되지 않는다.
    * 동일 한 수 가 포함 되서는 안된다.
     
#### 1.3 매칭 
전달 받은 값을 토대로 생성된 랜덤 숫자 3개와 비교하여 `스트라이크`, `볼` `낫싱` 의 상태를 배열로 전달한다.  
* `스트라이크`, `볼`, `낫싱` 의 상태 규칙은 다음과 같다.
    * 같은 수, 같은 자리에는 `스트라이크`이다
    * 같은 수, 다른 자리에는 `볼`이다.
    * 전체가 다른 수 일 경우 `낫싱`이다.
* 결과 출력은 길이가 2인 배열로 전달 한다. 예시는 다음과 같다.
    * 예1) 1스트라이크 1볼 : [1,1]
    * 예2) 1스트라이크 : [1,0]
    * 예3) 2볼 : [0,2]
    * 예4) 낫싱 : [0,0]
    
#### 1.4 결과값 문자열 출력
게임머신은 결과 값(=길이가 2인 int 배열)을 토대로 출력문을 전달 할 수 있다.
* 예1) [1,1] : "1스트라이크 1볼"
* 예2) [0,2] : "2볼"
* 예3) [0,0] : "낫싱"

### 2. Main
게임머신을 생성하여 게임을 시작, 재시작, 종료한다.

#### 2.1 게임 실행, 종료
* 게임은 게임머신이 생성되고 게임이 바로 시작된다
* 사용자가 숫자를 맞출 경우(=3 스타라이크) 게임은 종료 된다.

#### 2.2 게임 재시작, 종료
게임 종료 후, 특정 입력 값을 통해 새 게임 시작, 종료를 선택 할 수 있다.  
입력 값은 다음과 같다. (특정 입력 값을 제외한 값이 들어올 경우 값을 재입력 받는다)
* `1` : 게임 재시작
* `2` : 종료 
