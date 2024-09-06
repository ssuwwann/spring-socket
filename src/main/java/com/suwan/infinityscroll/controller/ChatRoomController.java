package com.suwan.infinityscroll.controller;

import com.suwan.infinityscroll.domain.dto.CreateChatRoomRequest;
import com.suwan.infinityscroll.domain.dto.CreateChatRoomResponse;
import com.suwan.infinityscroll.exception.UserDoNotMatchException;
import com.suwan.infinityscroll.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cr")
@Slf4j
public class ChatRoomController {

  private final ChatRoomService chatRoomService;

  @PostMapping("/personal") // 개인 DM 챗방
  public CreateChatRoomResponse createPersonalChatRoom(@RequestBody CreateChatRoomRequest request) throws UserDoNotMatchException {
    return chatRoomService.createChatRoomForPersonal(request);
  }

}
