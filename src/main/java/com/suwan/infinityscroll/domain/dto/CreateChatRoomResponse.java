package com.suwan.infinityscroll.domain.dto;

import lombok.Getter;

/**
 * 채팅방 개설 성공시 응답 dto
 */
@Getter
public class CreateChatRoomResponse {

  private String roomMakerId;
  private String guestId;
  private String chatRoomId;

  //  Entity -> dto
  public CreateChatRoomResponse(String roomMakerId, String guestId, String chatRoomId) {
    this.roomMakerId = roomMakerId;
    this.guestId = guestId;
    this.chatRoomId = chatRoomId;
  }

}
