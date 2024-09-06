package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.domain.dto.CreateChatRoomRequest;
import com.suwan.infinityscroll.domain.dto.CreateChatRoomResponse;
import com.suwan.infinityscroll.repository.ChatRoomRepository;
import com.suwan.infinityscroll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

  private final UserRepository userRepository;
  private final ChatRoomRepository chatRoomRepository;
  private final SecurityUtil securityUtil;

  // 개인 DM방 생성
  public CreateChatRoomResponse createChatRoomResponse(CreateChatRoomRequest chatRoomRequest) {
    securityUtil
  }

}
