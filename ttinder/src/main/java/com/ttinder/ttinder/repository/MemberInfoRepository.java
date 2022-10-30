package com.ttinder.ttinder.repository;

import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberInfo,Long> {
    Optional<MemberInfo> findByMember(Member member);
//    Optional<MemberInfo> findByMemberInfoId(MemberInfo memberInfo);
}
