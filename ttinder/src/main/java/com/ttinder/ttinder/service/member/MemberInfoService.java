package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.S3.S3Uploader;
import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberInfoRepository memberInfoRepository;
    private final S3Uploader s3Uploader;


    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public SuccessResDto saveInfo(MultipartFile file, MemberInfoReqDto memberInfoReqDto, Member member) throws IOException {
        if (memberInfoRepository.findByMember(member).isPresent()) {
            throw new RequestException(ErrorCode.MEMBER_BAD_REQUEST_400);
        }
            // 이미지 업로드 .upload(파일, 경로)
            String imgPath = s3Uploader.upload(file, "images");
            //  requestDto의 imgUrl을 imgPath의 값으로 설정
            //  equestDto의 imgUrl을 imgPath의 값으로 설정
            memberInfoReqDto.setPhoto(imgPath);

            MemberInfo memberInfo = new MemberInfo(memberInfoReqDto, member);

            // birthDate : String -> LocalDate 타입으로 변환
            String date = memberInfoReqDto.getBirthDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(date, formatter);
            memberInfo.setBirthDate(birthDate);

            memberInfoRepository.save(memberInfo);
            return new SuccessResDto(true);
    }
}