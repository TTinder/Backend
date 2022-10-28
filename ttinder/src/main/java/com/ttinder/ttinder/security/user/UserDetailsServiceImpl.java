package com.ttinder.ttinder.security.user;

import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member account = memberRepository.findByEmail(email).orElseThrow(
                () -> new RequestException(ErrorCode.USER_NOT_FOUND_404)
        );

        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setAccount(account);

        return userDetails;
    }
}
