package com.ttinder.ttinder.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttinder.ttinder.entity.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.ttinder.ttinder.entity.QMemberInfo.memberInfo;

public interface MemberInfoQueryRepository {
    Page<MemberInfo> findFilter(Pageable pageable, List<String> gender, List<LocalDate> birthDate, List<String> mbti, List<String> location) ;
}

