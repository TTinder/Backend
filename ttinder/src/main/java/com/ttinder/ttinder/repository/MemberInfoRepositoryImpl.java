package com.ttinder.ttinder.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.entity.QMemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Repository
public class MemberInfoRepositoryImpl implements MemberInfoQueryRepository{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<MemberInfo> findByGender(Pageable pageable, List<String> gender, List<LocalDate> birthDate, List<String> mbti, List<String> location) {

        QMemberInfo memberInfo = QMemberInfo.memberInfo;

        /*return queryFactory
                .from(memberInfo)
                .select(memberInfo)
                .where(memberInfo.gender.eq(gender))
                .where(memberInfo.mbti.eq(mbti))
                .where(memberInfo.location.eq(location))
                .limit(pageable.getPageSize()) // 현재 제한한 갯수
                .offset(pageable.getOffset()) // 조회 시작위치
//                .where(memberInfo.mbti.eq(age))
                .fetch();*/
    }
}
