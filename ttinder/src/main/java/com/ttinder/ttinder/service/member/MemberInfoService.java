package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.MemberInfoResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import com.ttinder.ttinder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberInfoRepository memberInfoRepository;

    private final MemberRepository memberRepository;

    private Member getMember(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow();
        return member;
    }
    
    public ResponseDto<?> saveInfo (List<MultipartFile> multipartFile,
                                    MemberInfoReqDto memberInfoReqDto, Member member
    ) {
        MemberInfo memberInfo = new MemberInfo(memberInfoReqDto,member);
        memberInfoRepository.save(memberInfo);
        return ResponseDto.success(
                MemberInfoResDto.builder()
//                        .info
                        .email(member.getEmail())
//                        .logging
                        .photo(memberInfo.getPhoto())
                        .userName(memberInfo.getUserName())
                        .gender(memberInfo.getGender())
                        .birthDate(memberInfo.getBirthDate())
                        .mbti(memberInfo.getMbti())
                        .location(memberInfo.getLocation())
                        .introduce(memberInfo.getIntroduce())
                        .build()
        );
    }

}
