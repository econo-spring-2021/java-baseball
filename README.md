# 숫자 야구 게임

## 구현할 기능 목록

* [x] Main 함수 구체화 - 반복 제어 코드 작성, 필요한 함수 선언
* [x] 야구 게임 함수 ``playGame()`` 구현
    * [x] 기본 입력 및 출력
    * [x] 공 판정 함수 ``returnBallAvailability()`` 구현
      * [x] BallAvailibilty DO 생성
      * [x] 정답 생성 및 유효성 판단
    * [x] 결과 출력 함수 ``printResult()`` 구현
    * [x] 플레이어 경기 결과 반환 함 ``returnIsPlayerWin()`` 구현
    * [x] 탈출 조건 
* [x] 반복 제어 함수 ``askRetry()`` 구현
* [ ] 리펙토링
    * [x] ``BallAvailability`` 클래스 분리
    * [x] 메소드 이름 리펙토링
    * [ ] 규칙에 맞게 공 생성 규칙 변경