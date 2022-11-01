package com.ttinder.ttinder.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.entity.QMemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Repository
public class MemberInfoRepositoryImpl implements MemberInfoQueryRepository{

    private final JPAQueryFactory queryFactory;


    @Override
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
}
