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

**1. 이메일 확인 코드 발송 관련**

- 배포한 서버에서 이메일 확인 코드 발송 실패<br>
-> EC2 인스턴스 포트 25번 열어줘야 이메일 코드 발송 가능
<br><br>
- 인증코드를 발송하는 Admin 메일을 Google 이메일로 사용하려 했으나, 최근 Google 내부 보안정책변경으로 불가<br>
-> 네이버 메일로 변경<br><br>
- 배포환경에서 이메일코드 발생시 일정한 코드만 발송<br>
-> AWS SES로 대체해서 해결가능할 것 같으나 미적용

**2. 회원정보에 나이 입력시 LocalDate로 저장**

해가 바뀔때마다 나이가 달라져 DB에 회원정보 입력시 출생년월로 입력하고,
출력시 나이로 환산해서 프론트에 전달


**3. Postman으로 필터링 처리API GET 요청시 body부분에 입력된 값이 @RequestParam으로 Query랑 같이 중복되어 전달**

Param값이 중복으로 입력되어, body부분 입력값을 지워서 해결


**4. Query DSL**

Query DSL로 페이징 처리시 List타입을 Page타입으로 바꾸기 위해 QueryResults, PageImpl를 사용

```java
    public Page<MemberInfo> findFilter(Pageable pageable, List<String> gender, List<LocalDate> birthDate, List<String> mbti, List<String> location) {

        QMemberInfo memberInfo = QMemberInfo.memberInfo;

        QueryResults<MemberInfo> result = queryFactory
                .from(memberInfo)
                .select(memberInfo)
                .where(memberInfo.gender.in(gender))
                .where(memberInfo.mbti.in(mbti))
                .where(memberInfo.location.in(location))
                .where(memberInfo.birthDate.between(birthDate.get(0),birthDate.get(1)))
                .limit(pageable.getPageSize()) // 현재 제한한 갯수
                .offset(pageable.getOffset())
                .orderBy(memberInfo.id.desc())
                .fetchResults();
            return new PageImpl<>(result.getResults(),pageable,result.getTotal());

    }
```

<br>


**5. /logout URL을 /login URL 없이 사용불가**

/logout URL을 /signout URL로 이름을 변경하여 해결



### BackEnd 팀원 깃허브
👩‍💻 [윤수영](https://github.com/Suyoung225) 🧑‍💻 [한수진](https://github.com/soojin-dev) 👨‍💻 [신현재](https://github.com/tmpanmitw)
