package com.ttinder.ttinder.repository;

import com.ttinder.ttinder.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo,Long> {
}
