# π TTinder 

λ€λ λ°±μλ λ νμ§ν λ¦¬μλλ€.


## νλ‘μ νΈ μ€λͺ

ν΄λλ₯Ό λͺ¨λ°©ν λ°μ΄ν μ΄ν


## π μ£ΌμκΈ°λ₯

**1. μ΄λ©μΌ νμΈ μ½λ λ°μ‘**

νμκ°μ μ μ€λ³΅ κ°μ, μ ν¨νμ§ μμ μ΄λ©μΌλ‘ κ°μνλ κ²μ λ°©μ§νκ³ μ
μ΄λ©μΌ μ½λ λ°μ‘ ν νμΈνλ μ μ°¨ μΆκ°


**2. νμ μ λ³΄ νν°λ§, νμ΄μ§**

κ²μνκ³  μΆμ μ±λ³, μ°λ Ήλ, MBTI, μ§μ­μΌλ‘ νμμ λ³΄ μ€λ³΅ νν°λ§ κ°λ₯
5κ° νμ νλ‘ν λ¨μλ‘ νμ΄μ§ μ²λ¦¬ (λ¬΄ν μ€ν¬λ‘€)


**3. λ©μμ§ λ³΄λ΄κΈ°**

ν νμ λΉ μ΅λ 3λ² λ€λ₯Έ νμμκ² λ©μμ§ μ μ‘ κ°λ₯
λ©μμ§λ₯Ό λ°μ νμμ λ©μΈ νμ΄μ§μμ λ©μμ§ νμΈ κ°λ₯

<br>
 

## β API μ€κ³

![2022-11-03](https://user-images.githubusercontent.com/87157566/199628322-e250706a-9b4f-4b1b-b903-d31a01ae019d.png)
![2022-11-03 (1)](https://user-images.githubusercontent.com/87157566/199628329-16ca829e-9840-4503-ab6d-3f2949e1ff8a.png)
![2022-11-03 (2)](https://user-images.githubusercontent.com/87157566/199628337-49393ee8-683d-41dc-9a98-4e9691c4c406.png)


## π ERD
![2022-11-03 (3)](https://user-images.githubusercontent.com/87157566/199629463-13c89c04-025f-48ea-aaaf-6d3509352a68.png)


## π νΈλ¬λΈμν

**1. μ΄λ©μΌ νμΈ μ½λ λ°μ‘ κ΄λ ¨**

- λ°°ν¬ν μλ²μμ μ΄λ©μΌ νμΈ μ½λ λ°μ‘ μ€ν¨<br>
-> EC2 μΈμ€ν΄μ€ ν¬νΈ 25λ² μ΄μ΄μ€μΌ μ΄λ©μΌ μ½λ λ°μ‘ κ°λ₯
<br><br>
- μΈμ¦μ½λλ₯Ό λ°μ‘νλ Admin λ©μΌμ Google μ΄λ©μΌλ‘ μ¬μ©νλ € νμΌλ, μ΅κ·Ό Google λ΄λΆ λ³΄μμ μ±λ³κ²½μΌλ‘ λΆκ°<br>
-> λ€μ΄λ² λ©μΌλ‘ λ³κ²½<br><br>
- λ°°ν¬νκ²½μμ μ΄λ©μΌμ½λ λ°μμ μΌμ ν μ½λλ§ λ°μ‘<br>
-> AWS SESλ‘ λμ²΄ν΄μ ν΄κ²°κ°λ₯ν  κ² κ°μΌλ λ―Έμ μ©

**2. νμμ λ³΄μ λμ΄ μλ ₯μ LocalDateλ‘ μ μ₯**

ν΄κ° λ°λλλ§λ€ λμ΄κ° λ¬λΌμ Έ DBμ νμμ λ³΄ μλ ₯μ μΆμλμλ‘ μλ ₯νκ³ ,
μΆλ ₯μ λμ΄λ‘ νμ°ν΄μ νλ‘ νΈμ μ λ¬


**3. PostmanμΌλ‘ νν°λ§ μ²λ¦¬API GET μμ²­μ bodyλΆλΆμ μλ ₯λ κ°μ΄ @RequestParamμΌλ‘ Queryλ κ°μ΄ μ€λ³΅λμ΄ μ λ¬**

Paramκ°μ΄ μ€λ³΅μΌλ‘ μλ ₯λμ΄, bodyλΆλΆ μλ ₯κ°μ μ§μμ ν΄κ²°


**4. Query DSL**

Query DSLλ‘ νμ΄μ§ μ²λ¦¬μ Listνμμ PageνμμΌλ‘ λ°κΎΈκΈ° μν΄ QueryResults, PageImplλ₯Ό μ¬μ©

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
                .limit(pageable.getPageSize()) // νμ¬ μ νν κ°―μ
                .offset(pageable.getOffset())
                .orderBy(memberInfo.id.desc())
                .fetchResults();
            return new PageImpl<>(result.getResults(),pageable,result.getTotal());

    }
```

<br>


**5. /logout URLμ /login URL μμ΄ μ¬μ©λΆκ°**

/logout URLμ /signout URLλ‘ μ΄λ¦μ λ³κ²½νμ¬ ν΄κ²°



### BackEnd νμ κΉνλΈ
π©βπ» [μ€μμ](https://github.com/Suyoung225) π§βπ» [νμμ§](https://github.com/soojin-dev) π¨βπ» [μ νμ¬](https://github.com/tmpanmitw)
