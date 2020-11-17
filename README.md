# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)



기능 요구사항

class 명 : BaseBallGame

기능목록

•기본적으로1부터9까지서로다른수로이루어진3자리의수를맞추는게임이다.
   
   클래스명 : GeneratorRandomNumbers

1. 서로 다른 숫자로 이루어진 3자리 난수를 반환한다.

1-1. 1~9까지의 숫자로 한정한다

     int nums[] = {1,2,3,4,5,6,7,8,9};
     
1-2. 서로다른 숫자로 이루어져 있다.

     Collections.shuffle 사용
     
1-3. 자리수는 3자리로 한정한다

     LIMIT_NUM_CNT = 3;   
     
     
2. 사용자로부터 3자리 숫자의 정수를 입력받는다.
    
    클래스명 : Input
    
2.1 사용자로부터 입력받은 숫자가 3자리 이하거나 정수가 아닐경우 에러를 표시한다.

    메서드명 : validatorCheckNumber


3. 사용자로부터 입력받은 3자리 숫자와 컴퓨터가 만든 3자리 숫자와 비교한다.
   
    클래스명 : BaseBallGameUtil

3.1 스트라이크를 판단한다.(같은 자리에 있을경우 스트라이크)
    
    메서드명 : judgeStrike
    
    컴퓨터[i]와사용자[i] 과 같을 경우
    
3.2 볼을 판단한다. (컴퓨터가 만든 3자리 숫자에 자리수가 다르지만 존재할경우 볼)

    메서드명 : judgeBall
    
    컴퓨터[i] 와 사용자 가 존재할 경우

4. 입력받은 숫자와 비교하여 결과를 반환한다.

    클래스명 : Output
    
4.1 결과를 출력한다.
  
    메서드명 : printResultAndReturn        