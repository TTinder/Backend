package com.ttinder.ttinder.service.member;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.ttinder.ttinder.S3.CommonUtils;
import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.MemberInfoResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.Img;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.repository.ImgRepository;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import com.ttinder.ttinder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberInfoRepository memberInfoRepository;

    private final MemberRepository memberRepository;

    private final AmazonS3Client amazonS3Client;

    private final ImgRepository imgRepository;


    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public ResponseDto<?> saveInfo(List<MultipartFile> multipartFile, MemberInfoReqDto memberInfoReqDto, Member member) throws IOException {

        // JSON으로 넘어온 데이터 + User객체 Post객체로 만들기
        MemberInfo memberInfo = new MemberInfo(memberInfoReqDto, member);
        // DB에 저장
        memberInfoRepository.save(memberInfo);

        // 넘어온 multipartFile이 있는지 확인하고 img 객체에 담고 저장하기
        // 저장할때 imgurl 이랑 postId 같이 저장하기
        // 그러려면 Img 객체에 Post를 ManyToOne 해두어야함
        // 그런 다음 상세보기에서 ImgRepository.findByPostId
        String imgUrl = "";

        for (MultipartFile file : multipartFile) {
            if(!file.isEmpty()) {
                String fileName = CommonUtils.buildFileName(file.getOriginalFilename());
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentType(file.getContentType());

                byte[] bytes = IOUtils.toByteArray(file.getInputStream());
                objectMetadata.setContentLength(bytes.length);
                ByteArrayInputStream byteArrayIs = new ByteArrayInputStream(bytes);

                amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, byteArrayIs, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                imgUrl = amazonS3Client.getUrl(bucketName, fileName).toString();

                Img img = new Img(imgUrl, memberInfo);

                imgRepository.save(img);
            }
        }

        return ResponseDto.success(
                "success : true"
        );
    }

//    private final AmazonS3ResourceStorage amazonS3ResourceStorage;

//    private Member getMember(String email) {
//        Member member = memberRepository.findByEmail(email)
//                .orElseThrow();
//        return member;
//    }
    
//    public ResponseDto<?> saveInfo (List<MultipartFile> multipartFile,
//                                    MemberInfoReqDto memberInfoReqDto, Member member
//    ) {
//        MemberInfo memberInfo = new MemberInfo(memberInfoReqDto,member);
//        memberInfoRepository.save(memberInfo);
//        return ResponseDto.success("success : true");
//    }

//    @Transactional
//    public ResponseDto<?> saveInfo(Member member, MemberInfoReqDto memberInfoReqDto, MultipartFile multipartFile) {
//        log.info("=====================");
//        log.info("member.getEmail() = {}", member.getEmail());
//        log.info("=====================");
//
//        //        //가입한 회원인지 확인
////        if (null == check.isPresentMember(member.getEmail())) {
////            throw new GlobalException(ErrorCode.MEMBER_NOT_FOUND);
////        }
//
////        //제목 작성 확인
////        check.checkTitle(productRequestPostDto.getTitle());
////        //최저가 작성 확인
////        check.checkLowPrice(productRequestPostDto.getLowPrice());
////        //내용 작성 확인
////        check.checkContent(productRequestPostDto.getContent());
//
//        // photo : 이미지 경로
//        String photo = createPath(multipartFile);
//        log.info("path = {}", photo);
//        log.info("=====================");
//        amazonS3ResourceStorage.store(photo, multipartFile);
//
//        MemberInfo memberInfo = new MemberInfo(memberInfoReqDto, member, photo);
//
//        //String -> LocalDate 변환 로직 필요
////        String strDate1 = "202201061515";
////        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
////        LocalDate strToLocalDateTime1 = LocalDate.parse(strDate1, format1);
////        System.out.println("strToLocalDateTime1 : " + strToLocalDateTime1);
////
////        String date = memberInfoReqDto.getBirthDate();
//        memberInfoRepository.save(memberInfo);
//        return ResponseDto.success("success : true");
////        return new CommonProductResponseDto(savedProduct);
//    }
//
//
//    // 파일을 받아서 경로 생성
//    private String createPath(MultipartFile multipartFile) {
//        final String fileId = MultipartUtil.createFileId();
//        final String format = MultipartUtil.getFormat(multipartFile.getContentType());
//
//        return MultipartUtil.createPath(fileId, format);
//
//    }
}
