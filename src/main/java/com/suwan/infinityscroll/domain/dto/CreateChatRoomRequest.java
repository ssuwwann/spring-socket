package com.suwan.infinityscroll.domain.dto;

import lombok.Getter;

/**
 * 채팅방 개설 요청 dto
 */
@Getter
public class CreateChatRoomRequest {

  private String roomMakerId;
  private String guestId;

}
