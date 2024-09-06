package com.suwan.infinityscroll.service;

import com.suwan.infinityscroll.domain.ChatRoom;
import com.suwan.infinityscroll.domain.CustomUser;
import com.suwan.infinityscroll.domain.User;
import com.suwan.infinityscroll.domain.dto.CreateChatRoomRequest;
import com.suwan.infinityscroll.domain.dto.CreateChatRoomResponse;
import com.suwan.infinityscroll.exception.UserDoNotMatchException;
import com.suwan.infinityscroll.repository.ChatRoomRepository;
import com.suwan.infinityscroll.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService {

  private final UserRepository userRepository;
  private final ChatRoomRepository chatRoomRepository;

  // 개인 DM방 생성

  public CreateChatRoomResponse createChatRoomForPersonal(CreateChatRoomRequest chatRoomRequest) throws UserDoNotMatchException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    CustomUser user = (CustomUser) authentication.getPrincipal();
    if (!chatRoomRequest.getRoomMakerUsername().equals(user.getUsername())) {
      throw new UserDoNotMatchException("뭔디");
    }

    User roomMaker = userRepository.findByUsername(user.getUsername()).orElseThrow(IllegalArgumentException::new);
    User guest = userRepository.findByUsername(chatRoomRequest.getGuestUsername()).orElseThrow(IllegalArgumentException::new);

    ChatRoom newRoom = ChatRoom.create();
    newRoom.addMembers(roomMaker, guest);

    chatRoomRepository.save(newRoom);

    return new CreateChatRoomResponse(roomMaker.getUsername(), guest.getUsername(), newRoom.getId());
  }

}
