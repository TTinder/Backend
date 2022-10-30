package com.ttinder.ttinder.repository;

import com.ttinder.ttinder.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImgRepository extends JpaRepository<Img, Long> {
//    List<Img> findAllByMemberInfoId(Long memberInfoId);
    Optional<Img> findAllByMemberInfoId(Long memberInfoId);
}
