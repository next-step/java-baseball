# 숫자 야구 게임 (lsb156)
## 구현 기능 목록
- 3자리 난수 생성 (GameNumberGenerator)
  - 1에서 9까지 서로 다른 임의의 수 3개를 선택
  - Set 사용
- 사용자 입력부 구현
  - 게임 진행중 숫자 입력 받아 반환
  - 게임 종료 후 새로운 게임에 대한 입력 받아서 반환
- User Input Data Parser 구현
  - 입력에 대해 List 반환
- Input Value Validator 구현
  - 숫자 이외에 다른 값이 있는지 확인
  - 유요한 범위의 숫자인지 확인
  - 입력한 숫자에 같은 숫자가 겹치는지 확인
- Exception 정의 및 Exception 처리
  - 사용자 입력 오류
- 메시지 Output 전담 클래스 구현
- 게임 Rule에 대한 판정 클래스 구현
- Game LifeCycle 설정
  - 게임 시작시 3개의 난수 생성
  - (사용자 Input -> 판정 -> 다음 단계 진행) loop
  - 선택한 3개의 숫자를 모두 맞히면 게임이 종료
  - 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료 할 수 있다
