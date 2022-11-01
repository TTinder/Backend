package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.responsedto.MainpageResDto;
import com.ttinder.ttinder.dto.responsedto.MemberInfoResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MainpageService {

    private final MemberInfoRepository memberInfoRepository;

    // age list->  birthdate (localdate list)
    // 24,27  순서
    //List<LocalDate> birthDate = new Arraylsa

    //920829 30 880325 34  221102 30~34 871103(연도-만나이-1,날짜+1)~931102(연도-만나이+1,날짜)

    public List<LocalDate> getbirthDate(int ageMin, int ageMax) {
        LocalDate today = LocalDate.now(); // 현재 날짜 구하기
        LocalDate birthDateMin = today.minusYears(ageMax).minusYears(1).plusDays(1);
        LocalDate birthDateMax = today.minusYears(ageMin).plusYears(1);

        List<LocalDate> birthDate = new ArrayList<> (Arrays.asList(birthDateMin,birthDateMax));
        return birthDate;
    }


    //메인페이지
    public List<MainpageResDto> findAllMember(Pageable pageable) {
        Page<MemberInfo> allMember = memberInfoRepository.findAll(pageable);//다른 성별만 조회하기 추가해야함
        List<MainpageResDto> memberLists = allMember.stream()
                .map(MainpageResDto::new).collect(Collectors.toList());
        return memberLists;
    }




    //메인페이지 필터링
    public List<MainpageResDto> filter(Pageable pageable, List<String> gender, List<Integer> age, List<String> mbti, List<String> location){
        List<LocalDate> birthDate = getbirthDate(age.get(0),age.get(1));

        Page<MemberInfo> filteredMember = memberInfoRepository.findFilter(pageable, gender, birthDate, mbti, location);

        List<MainpageResDto> memberLists = filteredMember.stream()
                .map(MainpageResDto::new).collect(Collectors.toList());

        return memberLists;
    }


}
