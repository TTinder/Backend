# 💘 TTinder 

띤더 백엔드 레파지토리입니다.


## 프로젝트 설명

틴더를 모방한 데이팅 어플


## 🌟 주요기능

**1. 이메일 확인 코드 발송**

회원가입 시 중복 가입, 유효하지 않은 이메일로 가입하는 것을 방지하고자
이메일 코드 발송 후 확인하는 절차 추가

**2. 회원 정보 필터링, 페이징**

검색하고 싶은 성별, 연령대, MBTI, 지역으로 회원정보 중복 필터링 가능
5개 회원 프로필 단위로 페이징 처리 (무한 스크롤)

**3. 메시지 보내기**

한 회원 당 최대 3번 다른 회원에게 메시지 전송 가능
메시지를 받은 회원은 메인 페이지에서 메시지 확인 가능

<br>
 

## ⚙ API 설계

![2022-11-03](https://user-images.githubusercontent.com/87157566/199628322-e250706a-9b4f-4b1b-b903-d31a01ae019d.png)
![2022-11-03 (1)](https://user-images.githubusercontent.com/87157566/199628329-16ca829e-9840-4503-ab6d-3f2949e1ff8a.png)
![2022-11-03 (2)](https://user-images.githubusercontent.com/87157566/199628337-49393ee8-683d-41dc-9a98-4e9691c4c406.png)


## 🔐 ERD
![2022-11-03 (3)](https://user-images.githubusercontent.com/87157566/199629463-13c89c04-025f-48ea-aaaf-6d3509352a68.png)


## 🚀 트러블슈팅

**1. 배포한 서버에서 이메일 확인 코드 발송 실패**

EC2 인스턴스 포트 25번 열어줘야 이메일 코드 발송 가능

**2. 회원정보에 나이 입력시 LocalDate로 저장**

해가 바뀔때마다 나이가 달라져 DB에 회원정보 입력시 출생년월로 입력해줘야 하는데,
출력시에는 나이로 환산해서 프론트에 전달해줘야 한다.

**3. Postman으로 필터링 처리 GET 요청시 body부분에 입력된 값이 @RequestParam으로 Query랑 같이 들어옴**

**4.  **


### BackEnd 팀원 깃허브
👩‍💻 [윤수영](https://github.com/Suyoung225) 🧑‍💻 [한수진](https://github.com/soojin-dev) 👨‍💻 [신현재](https://github.com/tmpanmitw)
