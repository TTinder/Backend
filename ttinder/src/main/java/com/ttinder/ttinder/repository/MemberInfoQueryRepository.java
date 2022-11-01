package com.ttinder.ttinder.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttinder.ttinder.entity.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ttinder.ttinder.entity.QMemberInfo.memberInfo;

@RequiredArgsConstructor
@Repository
public class MemberInfoQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<MemberInfo> findByGender(String gender, String location, String mbti) {
        return queryFactory
                .from(memberInfo)
                .select(memberInfo)
                .where(memberInfo.gender.eq(gender))
                .where(memberInfo.mbti.eq(mbti))
                .where(memberInfo.location.eq(location))
                .limit(1) // 현재 제한한 갯수
                .offset(0) // 조회 시작위치
//                .where(memberInfo.mbti.eq(age))
                .fetch();
    }
}

