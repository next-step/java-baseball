# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현계획 

0. init 
    1. baseballGame Class 생성
        1. numberPool - 숫자를 뽑고 삭제할 pool
        2. targetNumberArray - 무작위 숫자를 생성후 저장
        3. 게임 종료 변수 - 0/1
        4. checkModel - 게임결과 내용 모델     
    2. 무작위 수 생성   
        1. 1-9 pool에서 뽑고 삭제 후 뽑기 반복 (v) 
            1. pool 생성 
            2. 뽑기 로직 작성 
1. Scanner를 통해 유저의 answer를 입력받는다 
2. 저장된 target 배열과 입력받은 answer 배열을 비교한다 
    1. strike check - strike 개수 체크 
    2. ball check - ball 개수 체크 
    3. end check - strike 개수가 3이면 게임 종료     
3. while을 사용해 게임종료 변수가 1이 나올 때까지 반복 
4. 게임종료 변수 1일 경우, 종료 여부 확인후 진행 
    1. 1 입력, 게임 재시작 
    2. 2 입력, 게임종료 
