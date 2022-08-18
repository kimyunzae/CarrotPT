# 💪 당신 근처의 PT쌤, 당근PT

<details>
    <summary>Table of Contents</summary>
    <br>
    1. <a href='#about'>About</a><br>
    2. <a href='#tech'>Tech</a><br>
    3. <a href='#features'>Features</a>
    </details>


##  <span id="about">1. About </span>

당근PT는 지역별 트레이너 및 운동 시설 정보를 확인하고, 개인에게 꼭 맞는 트레이너를 찾을 수 있는 반응형 웹사이트입니다. 팬데믹을 거치며 건강 관리의 중요성이 증대되고 많은 사람들이 운동을 취미로 갖게 된 상황에서, <b>'운동을 배우고 싶은 사람'과 '운동을 가르칠 수 있는 트레이너' 사이 매칭이 이루어질 수 있는 공간</b>의 필요성을 느끼고 제작하게 되었습니다. 



### Overview

- 프로젝트 진행: 2022. 6. 28. - 2022. 8. 19.

- 제작: Team First

  [@kimyunzae](https://github.com/kimyunzae), [@larkmoon](https://github.com/larkmoon), [@sangeun100](https://github.com/sangeun100), [@hongjihu](https://github.com/hongjihu)

  (YouTube 링크 추가하기)



## <span id="tech">2. Tech</span>

### Built With
- Back-end: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)

- Front-end: ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)

- Frameworks & Libraries: Spring Boot, jQuery, MyBatis, BootStrap

  


- 데이터베이스: MySQL
- 의존성 관리: Maven
- 템플릿 엔진: Thymeleaf
- 서버: Apache Tomcat, Naver Cloud Platform
- 형상 관리: Git(GitHub)
- 협업 도구: Notion, Trello, ERDCloud, Moqups, Zoom



### Architecture

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/spring_mvc.png?raw=true" width="500px" alt="Spring MVC">

## <span id="features">3. Features</span>

### 1) USER

#### (1) 회원가입, 로그인

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/join.gif?raw=true" width="500px" alt="Sign Up">


- 일반회원/트레이너 구분해서 가입


  - ajax를 이용한 폼 유효성 검사 및 로그인/로그아웃



#### (2) 마이페이지

- 정보 조회 및 수정



#### (3) 아이디/비밀번호 찾기



### 2) Find Trainers

#### (1) 트레이너 목록 조회, 맞춤 트레이너 찾기

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/findtrainers.gif?raw=true" width="500px" alt="Get trainer list">

- 페이지별, 운동 종류별, 지역별 조회
- 최신순/리뷰 많은 순/이름순 정렬

- 트레이너 성별, 운동 종류, 운동 요일, 지역 입력 후, 응답과 일치율이 가장 높은 트레이너 목록 조회

  

#### (2) 상담 신청, 후기 작성



- 트레이너 정보 상세 조회
- 매칭 완료된 트레이너에 대해 후기 작성 및 신고 접수



### 3) Match

- 상담 신청 내역 조회 및 수락/거절
- 일반회원-트레이너 채팅



### 4) Map

<img src="https://github.com/larkmoon/CarrotPT/blob/master/main/resources/static/images/documentation/map.gif?raw=true" width="500px" alt="Find fitness centers on map">

- 내 위치로 찾기: 사용자 위치에 기반하여 웹사이트에 등록된 운동 시설 조회

- 검색해서 찾기: 지역, 시설 종류(e.g. '성북구', '요가') 입력 후 운동 시설 조회

  

### 5) Chatbot

- Naver CLOVA Chatbot을 이용한 회원 문의 응답



### 6) Admin

#### (1) 회원 관리

- 회원 상태 변경: 수락/거절/정지/탈퇴

- 페이지별, 회원 상태별 조회

  

#### (2) 신고 처리

- 신고 상세 내역 조회
- 신고 처리 상태별 조회
- 신고 대상 회원에 대한 조치





## 4. Troubleshooting

<<<<<<< HEAD
=======


### 
>>>>>>> 22bc40fd0b752749dd534d34319e75076a4d5622
