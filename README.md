# 숫자 야구 게임
___
## 구현할 기능 목록
___
1. 컴퓨터가 타겟이 될 야구번호 생성
   * 1~9 서로 다른 수로 이루어진 세자리 수의 번호 생성
   * 매번 랜덤하게 생성

2. 사용자가 야구번호 입력
   * 사용자가 1~9 서로 다른 수로 이루어진 세자리 수의 번호 입력  
   * 입력 값에 대한 예외 처리
     * 사용자가 문자를 입력한 경우
     * 사용자가 입력한 숫자가 중복되는 경우
     * 사용자가 입력한 숫자가 3자리가 아닌 경우
    
3. 번호 처리
   * 컴퓨터 처리값과 사용자의 입력값을 확인하여 스트라이크, 볼 여부 확인
4. 결과 출력
   * 쓰리 스트라이크일 경우
     * 새로운 게임을 시작할 지, 종료할 지 선택
   * 쓰리 스트라이크가 아닐 경우
     * 스트라이크와 볼 값을 출력
     * 둘 다 아닌 경우 낫을 출력
 