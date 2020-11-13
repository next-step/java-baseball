# 커밋 메시지 규약 정리

### 포맷
~~~ text
    <type>(<scope>): <subject>
    <BLANK LINE>
    <body>
    <BLANK LINE>
    <footer>
~~~
- 세 영역으로 구성(각 영역은 빈 줄로 분리)
    - 제목 줄
    - 본문(제목 만으로 표현이 가능할 때에는 생략 가능)
    - 꼬리말(관련 이슈가 없으면 생략 가능)
- 예시) : feat: 숫자 야구 랜덤한 숫자 생성 기능 추가 

### 타입
- feat : 기능 추가, 삭제, 변경(제품 코드 수정 발생)
- fix : 버그 수정(제품 코드 수정 발생)
- docs : 문서 추가, 삭제, 변경(코드 수정 없음)
- style : 코드 형식, 정렬, 세미콜론 누락 된 것 추가 등의 변경(제품 코드 수정 발생. 하지만 동작에 영향을 주는 변경은 없음)
- refactor : 코드 리팩토링(제품 코드 수정 발생)
- test : 테스트 코드 추가, 삭제, 변경 등(제품 코드 수정 없음. 테스트 코드에 관련된 모든 변경에 해당)
- chore : 그 외에 사소한 수정 등

### 참고 사이트 
- [AngularJSCommitMessageConventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)