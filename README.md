# 자동차 경주 게임

## 요구사항 분석

***italic***: Clean Code 구현에 더 초점을 맞추기 위해 ***요구사항*** 을 추가한다.

- 문자열 입력
  - 구분: 쉼표
  - 이름: 최대 5글자
    - ***영어 소문자*** : *문자 종류를 제한하여 경우의 수를 줄인다.*
    - ***2 ~ 20개*** 
      - *자동차 1대로 경주를 할 필요는 없다.*
      - *자동차 2대 경주와 N대 경주의 알고리즘은 같다.*
      - *입력 문자열 최대 길이는 `Integer.MAX_VALUE`다. 21억 자리 문자열을 테스트할 수는 없다.*
- 숫자 입력
  - ***1 ~ 99***
    - *0 보다 작은 수는 의미 없다.*
    - *입력값이 `Integer.MAX_VALUE`를 넘어가면 `NumberFormatException`이 발생하는 것과 같다.*
- 무작위 한 자리 숫자 생성
  - 4 이상: 이동
  - 3 이하: 정지
- 우승자 선정

## 도메인

***Immutable*** 객체를 사용한다.
예: `이동 거리` + `이동 거리` = 새로운 `이동 거리`

 - **자동차** (`이름`)
    - *Pitstop*: 참가 가능한 자동차 수 2 ~ 20
- **이동 거리** (`숫자`): 0과 자연수
- **라운드** (`숫자`): 경주 N회 진행
  - *Round*: 1 ~ 99
- **랩** (`{자동차: 이동 거리, ...}`): 한 회마다 자동차들이 이동한 거리
- **주사위**: 무작위 한 자리 숫자 생성 → `0` 또는 `1` 반환
  - *Engine*: 무작위 숫자 생성 조건 정의

게임 관련 객체는 속성 변화에 주의한다.

- **게임** (`진행 상태`, `데이터`)
  - **진행 상태**: `자동차 목록 입력` → `라운드 입력` → `경주` → `게임 종료`
  - **데이터** (`라운드`, `자동차`, `랩 기록`): 게임 내 공유 데이터를 한 객체에 저장
    - 데이터는 한 번만 Write가 가능하도록 한다: 요구사항에 의해 여러 번 Write하지 않아도 된다.

## 게임 단반향 흐름

- **State** 패턴
- 요구사항에 따라 이전 상태로 돌아가는 경우는 없다.
- **장점**
  1. 게임의 상태 변화를 조작하기 쉽다.
     - 조건문이 반복문에서 객체 안으로 이동한다.
  1. 상태마다 정확한 역할을 지시할 수 있다.

1. **RegisterState**: 자동차 이름 이름 등록
1. **ReadyState**: 라운드 수 등록
1. **RaceState**: 경주
1. **PodiumState**: 최종 우승 발표
1. **EndState**: 게임 종료

## 입력값 검증

### 자동차 이름

- **Decorator** 패턴
- 각 계층마다 검증 역할을 하나씩 맡는다.
- **장점**
  1. **분할-정복**.
  1. 검증 실패 이유를 찾기 쉽다.
  1. 검증 실패한 곳에서 이유를 반환하기 쉽다.

1. **StandingsValidator**: 참가 자동차 목록 확인. 영어 소문자 + 쉼표
1. **PitstopValidator**: 참가 팀 수 확인. 2 ~ 10
1. **DuplicationValidator**: 자동차 이름 중복 확인
1. **NamesValidator**: 자동차 목록 이름 확인
   - **NameValidator**: 이름 글자 수. 1 ~ 5 

### 라운드

- **Rounds**: 경주 N회 진행 확인. 1 ~ 99

## 예외 처리

**RuntimeException**: 개발자가 주의하여 처리한다.

- 클래스 생성: `IllegalArgumentException`(→ `RuntimeException`) 상속
  - `InvalidCarNameException`: 자동차 이름은 5개 이하의 영어 소문자로 구성된다.
  - `RoundsOutOfBoundsException`: 라운드 범위는 1 ~ 99이다.
  - `DistanceOutOfBoundsException`: 이동 거리 범위는 0 또는 자연수다.
- 객체 저장: `RuntimeException` 상속
  - `RoundsSaveException`, `CarsSaveException`, `LapsSaveException`
  - 요구사항의 단반향 흐름 때문에 객체는 한 번만 저장하면 된다.

## 입출력

- **경주할 자동차 이름을 입력하세요.**
  - 입력: 문자열
  - 변환: 문자열 리스트
- **시도할 회수는 몇 회인가요?**
  - 입력: 문자열
  - 변환: 숫자
- **실행 결과**
- N번 반복
  - **자동차1 : ----**
  - **자동차2 : --**
- **자동차1, 자동차2가 최종 우승했습니다.**

---

## 결과

![](result.png)
