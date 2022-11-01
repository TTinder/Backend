package com.ttinder.ttinder.repository;

import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberInfo,Long>, MemberInfoQueryRepository{
    Optional<MemberInfo> findByMember(Member member);

//    List<MemberInfo> findAllByMember(Member member);
}
