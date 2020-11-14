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
   메소드명 : createRandomValue
1. 서로 다른 숫자로 이루어진 3자리 난수를 반환한다.

1-1. 1~9까지의 숫자로 한정한다

     int nums[] = {1,2,3,4,5,6,7,8,9};
1-2. 서로다른 숫자로 이루어져 있다.

     Collections.shuffle 사용
     
1-3. 자리수는 3자리로 한정한다

     LIMIT_NUM_CNT = 3;   