package com.ttinder.ttinder.service.message;

import com.ttinder.ttinder.dto.requestdto.MessageReqDto;
import com.ttinder.ttinder.dto.responsedto.MessageResDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.entity.Message;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import com.ttinder.ttinder.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MemberInfoRepository memberInfoRepository;

    @Transactional
    public SuccessResDto sendMessage(Member member, MessageReqDto messageReqDto, Long id){
        MemberInfo memberInfo = memberInfoRepository.findByMember(member).orElse(null);
        if(memberInfo.getMessageNum()>=3){
            throw new RequestException(ErrorCode.MESSAGE_EXCEED_401);
        }
        messageRepository.save(new Message(memberInfo.getId(), id, messageReqDto.getMessage())); // 보낸 사람, 받는 사람, 메시지
        memberInfo.plusMessageNum();
        return new SuccessResDto(true);
    }

    public List<MessageResDto> myMessage(Member member){
        MemberInfo memberInfo = memberInfoRepository.findByMember(member).orElse(null);
        List<Message> messageList = messageRepository.findByReceiveUserOrderByCreatedAtDesc(memberInfo.getId());
        List<MessageResDto> messageResDtos = new ArrayList<>();
        for (Message message : messageList) {
            MemberInfo sendUserInfo = memberInfoRepository.findById(message.getSendUser()).orElse(null);
            messageResDtos.add(new MessageResDto(message.getSendUser(),
                    sendUserInfo.getPhoto(),
                    sendUserInfo.getUserName(),
                    message.getMessage()));
        }
        return messageResDtos;
    }

}
