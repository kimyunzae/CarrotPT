# 💪 당신 근처의 PT쌤, 당근PT

<details>
    <summary>Table of Contents</summary>
    <br>
    1. <a href='#about'>About</a><br>
    2. <a href='#tech'>Tech</a><br>
    3. <a href='#features'>Features</a><br>
    4. <a href='#troubleshooting'>TroubleShooting</a><br>
    5. <a href='#lessons'>Lessons & Reviews</a>
    </details>

<br>

##  <span id="about">1. About </span>

당근PT는 지역별 트레이너 및 운동 시설 정보를 확인하고, 개인에게 꼭 맞는 트레이너를 찾을 수 있는 반응형 웹사이트입니다. 팬데믹을 거치며 건강 관리의 중요성이 증대되고 많은 사람들이 운동을 취미로 갖게 된 상황에서, <b>'운동을 배우고 싶은 사람'과 '운동을 가르칠 수 있는 트레이너' 사이 매칭이 이루어질 수 있는 공간</b>의 필요성을 느끼고 제작하게 되었습니다. 



### Overview

- 프로젝트 진행: 2022. 6. 28. - 2022. 8. 19.

- 제작: Team First

  - [@kimyunzae](https://github.com/kimyunzae), [@larkmoon](https://github.com/larkmoon), [@sangeun100](https://github.com/sangeun100), [@hongjihu](https://github.com/hongjihu)

  - 팀원별 역할, 회고 확인하기:  [📓Notion(Click!)](https://www.notion.so/sargassosea/Personal-Trainer-PT-3b2086e394c8412395c225d3beaa4d6c)

- 시연 영상: <a href="https://www.youtube.com/watch?v=fMG2Zown4Uk" target="blank">🎞Youtube(Click!)</a>

<br>


## <span id="tech">2. Tech</span>

### Built With
- Back-end: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

- Front-end: ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)


- Frameworks & Libraries: Spring Boot, jQuery, MyBatis, BootStrap

<br>


- 데이터베이스: MySQL
- 의존성 관리: Maven
- 템플릿 엔진: Thymeleaf
- 서버: Apache Tomcat, Naver Cloud Platform
- 형상 관리: Git(GitHub)
- 협업 도구: Notion, Trello, ERDCloud, Moqups, Zoom

<br>

### Architecture

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/spring_mvc.png?raw=true" max-width="600px" alt="Spring MVC">

## <span id="features">3. Features</span>

### 1) USER

#### (1) 회원가입, 로그인

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/join.gif?raw=true" max-width="600px" alt="Sign Up">


- 일반회원/트레이너 구분해서 가입


  - ajax를 이용한 폼 유효성 검사 및 로그인/로그아웃

<br>

#### (2) 마이페이지
<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/mypage.gif?raw=true" max-width="600px" alt="mypage">

- 정보 조회 및 수정

<br>

#### (3) 아이디/비밀번호 찾기
<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/findid.gif?raw=true" max-width="600px" alt="Find ID and Password">

- 난수 비밀번호 생성 후 Google SMTP 이용해 이메일로 전송

<br>

### 2) Find Trainers

#### (1) 트레이너 목록 조회, 맞춤 트레이너 찾기

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/findtrainers.gif?raw=true" max-width="600px" alt="Get trainer list">

- 페이지별, 운동 종류별, 지역별 조회
- 최신순/리뷰 많은 순/이름순 정렬

- 트레이너 성별, 운동 종류, 운동 요일, 지역 입력 후, 응답과 일치율이 가장 높은 트레이너 목록 조회

<br>

#### (2) 상담 신청, 후기 작성

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/csl.gif?raw=true" max-width="600px" alt="trainer detail page">

- 트레이너 정보 상세 조회
- 매칭 완료된 트레이너에 대해 후기 작성 및 신고 접수

<br>

### 3) Match
<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/matching.gif?raw=true" max-width="600px" alt="Find fitness centers on map">

- 상담 신청 내역 조회 및 수락/거절
- 일반회원-트레이너 채팅

<br>

### 4) Map

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/map.gif?raw=true" max-width="600px" alt="Find fitness centers on map">

- 내 위치로 찾기: 사용자 위치에 기반하여 웹사이트에 등록된 운동 시설 조회
- 검색해서 찾기: 지역, 시설 종류(e.g. '성북구', '요가') 입력 후 운동 시설 조회

<br>

### 5) Chatbot

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/chatbot_exported.gif?raw=true" max-width="300px" alt="ask and get reponse with chatbot">

- Naver CLOVA Chatbot을 이용한 회원 문의 응답

<br>

### 6) Admin

#### (1) 회원 관리

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/admintrainers.gif?raw=true" max-width="600px" alt="Manage members">

- 회원 상태 변경: 수락/거절/정지/탈퇴

- 페이지별, 회원 상태별 조회

<br>

(2) 신고 처리

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/adminreports.gif?raw=true" max-width="600px" alt="Manage reports">

- 신고 상세 내역 조회
- 신고 처리 상태별 조회
- 신고 대상 회원에 대한 조치

<br>

## <span id="troubleshooting">4. Troubleshooting</span>

| Issues                                                       | Problem solving                                              |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| 페이지네이션을 위해 전체 데이터의 수가 필요한 상황. 조회 조건이 바뀔 때, console에는 조회 조건에 따른 데이터 수가 정상 출력되나 Model에는 조건 변경 전 데이터 수가 계속해서 붙어 있음. | ajax 실행 결과 return되는 html 파일 내에 변수를 담기. html 파일에 `<input type:hidden>`으로 변수를 넣고, 상위 html 파일에서 (전체 데이터 수) = (해당 요소의 value)로 선언하여 해결. |
| 쿼리에 #{} 대신 ${}를 사용해야 하는 경우 SQL Injection이 발생할 수 있음. | ${orderby}를 CONCAT('',#{orderby},'')로 변경함.              |
| ajax로 페이지네이션 처리했을 때 페이지 이동 제어 필요.       | pushstate로 url 지정.Popstate로 뒤로 가기 활성화.            |
| ajax로 페이지네이션 처리 중, Controller에서 html 파일을 return하려고 하는데 String = (html 파일의 이름)이 return됨. | Data가 아니라 View를 반환해야 하므로 `@ResponseBody` annotation 삭제. |
| 아이디/비밀번호 찾기 페이지에서 로그인 Modal을 띄우면 Modal 내 form에 `display:none` 속성이 붙음. | 아이디찾기/비밀번호 찾기 전환 때 `$(‘form’).not().hide()`를 사용해서 Modal form도 함께 숨겨짐. 선택자를 class로 수정하여 해결. |
| list를 이름 순으로 정렬할 때 한글 이름이 우선하게 하고 싶음. | Pattern이 [가-힣]일 때 `stringBuilder.append((char)(c-44050))` |
| `Collections.sort`와 `subList()`를 이용해서 페이지 처리할 때 Out of bounds Exception 발생. | 한 페이지에 들어가는 데이터의 수를 amount, 데이터 목록을 `list = subList(startIndex, endIndex)`라고 할 때, 마지막 페이지 전까지는 `endIndex = startIndex + amount`지만 마지막 페이지에 들어갈 데이터의 개수가 amount보다 작아서 발생.(총 데이터 개수) - startIndex가 amount보다 작을 경우 `endIndex = {startIndex + (총 데이터 개수 % amount)}`로 선언하여 해결. |
| 페이지 처리를 위해 조건에 해당하는 데이터의 개수를 가져올 때, 매번 쿼리문을 이용하는 방식이 비효율적인 것 같음. | 쿼리문으로 데이터 개수를 재조회하지 않고 sort한 list를 이용해서 데이터 개수를 구함. `int cnt = list.size();` |
| 선호도 계산이 너무 느림.                                     | 쿼리 SELECT할 때 `WHERE=트레이너 우편번호 - (사용자 입력 우편번호) < 10000` 조건 추가해서 데이터 개수 줄이기. 요일별로 Workday를 따로 조회하지 않고 TrainerVO를 SELECT할 때 join해서 함께 조회하기. |
| 작업 중 팀원 IP가 변경됨.                                    | ACG 설정에서 해당 접근 소스에 대해 허용 포트(22, 8080, 3306)를 설정하여 서버 접속 허용. |
| GitHub에 패키지가 업로드되지 않음.                           | 비어 있는 패키지는 업로드되지 않으므로 Dummy 파일을 넣음.    |
| 트레이너 상세 페이지에서 상담 신청/리뷰 작성/신고 접수 후 메인 페이지로 되돌아가면 사용자 경험에 마이너스 요소인 것 같음. | Modal 내에 입력한 데이터를 Ajax로 전송하도록 리팩토링하고, 해당 메소드 실행 후 기존 페이지에서 새로고침되게 하여 작성한 댓글을 확인할 수 있게 함. |
| Form 내부 요소들의 value를 따로 변수로 지정하지 않고 Ajax로 한 번에 전송하고 싶음. | form을 변수로 설정한 다음, 해당 변수를 `serialize()`해서 전송. MultipartFile이 포함된 경우 enctype, processData, contentType 지정함. |
| 카카오맵 API 사용 시 좌표 위치를 하나씩 지정하는 방식이 비효율적임. | 데이터베이스에 (id, 좌표 이름, 위도, 경도) COLUMN을 가진 좌표 TABLE을 생성하고, 해당 TABLE의 정보를 SELECT해서 JSONArray로 넘겨줌. 프론트에서 JSON을 필요한 형태로 파싱해서 사용해서 해결. |
| 트레이너 정렬 중 특정 항목에서 Collections.Sort Comparison method violates its general contract Error 발생 | 이름순, 최근 가입 순으로 정렬할 때는 에러 발생하지 않음. 리뷰 많은 순서대로 정렬할 때도, 특정 조건(이미 지역, 운동 종류 필터링이 추가되어 데이터가 적은 상태)에서는 에러 발생하지 않음. 전체 트레이너를 조회하는 상황에서 리뷰 순서대로 조회할 때 해당 에러 발생→ 리뷰 개수가 같은 데이터가 많아서 값이 모호하기 때문. 기존 코드에 `else if(~){return}` 조건 추가해서 해결. |

<br>

## <span id="lessons">5. Lessons & Reviews</span>

### Reviews

- 설계
  - 데이터베이스
  - Nice to Have, Must Have

- 구현
  - 테스트 코드 작성
  - 
- 마무리
  - 문서화: 시연 영상의 경우, IT에 

<Br>


### Lessons Learned

- 설계: 다양한 설계 방식이 존재하므로, 현업에서 어떤 설계 방식이 어떤 목적으로 사용되는지 알아볼 것.
- 구현:
- 기타: 

