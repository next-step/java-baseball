# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현계획 

1. 1-9로 이루어진 중복되지 않는 무작위 3자리 수 생성 
    1. random class 활용, 중복일 경우 재귀 처리 (x)
    2. 1-9 pool에서 뽑고 삭제 후 뽑기 반복 (v) 
2. 입력받은 숫자를 배열로 저장한다. 
3. 저장된 target 배열과 입력받은 answer 배열을 비교한다 
    1. strike check - strike 개수 체크 한 후 3개면 return 
    2. ball check - ball 이 3개면 return, strike/ball이 0개면 nothing  
4. while을 사용해 답이 나오기 전까지 로직을 반복한다 
