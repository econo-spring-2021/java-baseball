# 숫자 야구 게임
> 야구는 투수 놀음이란 말 들어 보았는가?
> 
> 이 게임을 플레이하는 당신은 감독의 기대를 등에 업고 첫 등판 기회를 얻은 신인 투수이다.
> 
> 그런데 이 야구는 일반적인 야구랑 규칙이 좀 다른 것 같다…

이 게임은 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 볼넷이란 힌트를 얻고, 그 힌트를 이용해서 상대방(컴퓨터)의 수를 맞추면 삼진 아웃시킬 수 있다.
> [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크
> 
> 456을 제시한 경우 : 1 스트라이크 1볼
> 
> 789를 제시한 경우 : 볼넷

* 타자의 역할은 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택해서 기억하고 있는다. 
  게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. 
  이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 타자가 삼진 아웃되어 플레이어가 승리한다.

* 그러나 감독은 신인 투수가 무리하게 너무 많은 투구수를 던지는 것을 원치 않는다.
아홉 번의 시도 동안 컴퓨터의 수를 맞히지 못하면 컴퓨터가 승리하게 된다.
  (시도 횟수는 표시해도 되고 안 해도 상관 없다. 잘못된 입력의 경우 무효로 하고 다시 입력하게 한다)
* 게임이 끝나면 게임을 다시 시작하거나 프로그램을 완전히 종료할 수 있다. 

## 실행 예시
```
숫자를 입력해주세요 : 123
1 스트라이크 1볼
숫자를 입력해주세요 : 145
1볼 
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1 스트라이크 
숫자를 입력해주세요 : 713
3 스트라이크 아웃
3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```

```
...
숫자를 입력해주세요 : 456
볼넷
숫자를 입력해주세요 : 154 
1볼 
숫자를 입력해주세요 : 571 
2볼
숫자를 입력해주세요 : 213
1 스트라이크 1 볼
숫자를 입력해주세요 : 217
1 스트라이크 1 볼
9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 1

숫자를 입력해주세요 : 573
1볼
...
```

## 프로그래밍 요구사항 (1주차)

* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * https://google.github.io/styleguide/javaguide.html 참고
  * https://myeonguni.tistory.com/1596 참고 
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하는 것이다. 
* 3항 연산자를 쓰지 않는다. (가독성에 있어서 좋지 않다)
* 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* `System.exit` 메소드를 사용하지 않는다.

## 미션 저장소 및 진행 요구 사항

* 미션은 https://github.com/econo-spring-2021/java-baseball 저장소를 fork 및 clone해 시작한다.
* **기능을 구현하기 전에 본 README 파일을 지우고, 구현할 기능 목록을 정리해 추가한다.**
* git의 commit 단위는 README.md 파일에 정리한 기능 목록 단위로 추가한다.
* 스프링 스터디 과제 제출 문서 절차를 따라 미션을 제출한다.
---
### 기능명세
-[x] 랜덤수를 생성하는 Computer 클래스 작성
-[x] 입력과 출력에 대한 문자열 상수를 관리하는 Constants 클래스 작성
-[x] 사용자에게 숫자 입력을 받는 InputView 클래스 작성
-[x] 사용자의 입력이 정확한지 판단하는 Validator 클래스 작성
  - 사용자의 입력이 1~9를 벗어나는 경우
-[x] 결과 출력에 대한 책임을 지는 OutputView 클래스 작성
-[x] 야구 룰(스트라이크, 볼)에 대해 관리하는 BaseballScore 클래스 작성
-[ ] 게임 클래스
  - 게임 클래스는 게임을 시작하는 기능을 가지고, 힌트 출력, 상대방 수와 플레이어 수를 비교하는 기능을 갖는다.
    - 상대방 수와 플레이어 수를 비교하는 기능은 게임 클래스가 책임을 질 필요는 없다(?) 차후 생
  - 또한 inputCount는 게임 설정에 관한 것이라 생각함으로 책임을 게임 클래스에 둔다.
-[x] 하나의 게임이 종료될 경우 반복, 또는 게임 완전 종료 여부를 묻고 실행하는 로직을 Main 클래스로 구현

* replaceAll("\\s", "") - 문자열 사이의 whitespace제거

### 설계 중 고민
* inputCount를 검사하는 책임을 inputView에 넣어야 할 것인가?
  *inputCount는 게임 설정에 관한 책임이므로 Game 클래스에 책임을 부여한다.
  
* 게임의 재시작과 종료에 대한 책임은 Main 클래스가 담당해야 한다.
* BaseballScore은 어떤 클래스에서 책임을 가지고 있어야 하는가?
* (이슈 - 아직 고민 못 해봄) InputView 클래스의 inputInputNumber 메서드에서 Scanner 객체를 매개변수로 넘길 경우 재시작 시 입력이 받아지지 않음. 메서드 내부에서 객체를 새로이 생성해서 문제를 해결


* 책임과 기능을 분리하는 연습을 해보자!