#####  AI 플랫폼을 활용한 웹 서비스 개발 14회차
# 💪  당신 근처의 PT쌤, 당근PT
[✔Notion](https://billy-k.notion.site/billy-k/Final-Project-PT-8af304225ca246baaec8d884904b2b98)
[✔Trello](https://trello.com/b/WfKksU70/%ED%8C%8C%EC%9D%B4%EB%84%90%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-1%EC%A1%B0)

## 👀 목차
-----------
- 개발 환경
- 기술 스텍
- 시스템 구조
- 프로젝트 주제 및 목적
- 프로젝트 내용
    -  데이터베이스 설계
    - 기능 구현 화면


### 📋 개발환경
--------------
- DB : MySQL
- Application:JDK
- IDE : ECLIPSE
- 협업 도구 : Notion, Trello, ERDCloud, Moqups
- 의존성 관리 도구 : Maven
- 형상 관리 Git(GitHub)

### 📋 기술 스텍
- Back-end: Java
- Front-end: HTML/CSS, JavaScript
- Framework: Spring Boot, jQuery, Bootstrap, - - MyBatis, ajax

-------
[참고용]백엔드
Spring boot
JAVA 8
Spring MVC
Spring Boot Security
Spring Boot Actuator
Spring Data JPA
Spring Boot Batch
Spring AOP
spring cloud stream
Build tool
Gradle
Database
Mysql
Redis
AWS
EC2
S3
Message Queue
Kafka
CI
Travis CI

프론트엔드
Javascript
Thymeleaf
jQuery


### 📋 시스템 구조
-----
(그래픽, img)

### 😃 프로젝트 주제 및 목적
-----
건강 관리의 필요성이 증대되면서 운동에 관심을 가진 인구가 증가함에 따라, 지역별 트레이너 및 운동 시설 정보를 확인할 수 있는 웹사이트가 필요함.

### 😃 프로젝트 내용
-----

##### 데이터베이스 설계
[erdcloud](https://www.erdcloud.com/d/hneAS2LK8mg7K2jLi)

##### 기능구현 화면




### 🔗 API 서버 (Producer)(참고용)

### 🔗 ERD 설계

### 😃 팀명, 팀원
##### TeamFirst
###### 김현재, 문설연, 백상은, 홍지훈




환경
JDK 1.8
TOMCAT 9.0
STS TOOL
MYSQL 8.0
POSTMAN
LOMBOK
인코딩(utf-8)
git

🥈MYSQL 데이터베이스 생성 및 사용자 생성
bloguser 사용자 생성
use blog 데이터 베이스 선택
create user 'bloguser'@'%' identified by 'bitc5600';
grant all privileges on *.* to 'bloguser'@'%';
create database blog;
use blog;

🥈MYSQL 테이블 생성
user2 테이블 생성
CREATE TABLE user2(
	id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
	nameval varchar(100),
	age int(20),
    address varchar(100),
    residentnumber int(20),
    userRole varchar(20),
    createDate timestamp
) engine=InnoDB default charset=utf8;
commit;

🥈기능 구현(화면)
첫화면에는 데이터베이스에 있는 모든 유저리스트가 나온다. 1  첫화면 유저리스트

user권한 회원가입 후 로그인 시 자신의 정보만 삭제할 수 있다. 6  유저 로그인 자기것만 삭제가능

admin권한 회원가입 후 로그인 시 모두의 게시물을 삭제할 수 있다. 8  관리자 로그인 후 유저리스트 전부다 삭제가능


🥈기능 구현(로그인)
회원가입 시 아이디를 중복체크 해야한다. 2  아이디 중복체크 후 회원가입

회원가입 시 권한으로 user, admin 나눠서 가입할 수 있다.
4  user, admin 고르기

회원가입 시 주소 API를 이용해서 주소를 입력할 수 있다. 3  회원가입 주소찾기


🥈기능 구현(데이터베이스)
회원가입, 삭제시 모두 데이터베이스와 연동되어있다. 5-1 회원가입 후 데이터베이스 10  관리자가 삭제 후 데이터 베이스


🥈피피티
김정현.pptx

🥈블로그
https://blog.naver.com/rlawjdgus051



