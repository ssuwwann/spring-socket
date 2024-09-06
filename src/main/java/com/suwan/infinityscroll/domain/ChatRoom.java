package com.suwan.infinityscroll.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(value = {AuditingEntityListener.class})
public class ChatRoom {

  @EqualsAndHashCode.Include
  @Id
  private String id;

  // 단방향
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "lastChatMessageId")
  private ChatMessage lastChatMessage;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "ChatRoom_Members",
          joinColumns = @JoinColumn(name = "chatRoomId"),
          inverseJoinColumns = @JoinColumn(name = "userId"))
  private Set<User> chatRoomMembers = new HashSet<>();

  @Column(updatable = false)
  @CreationTimestamp
  private Timestamp createdAt;

  public static ChatRoom create() {
    ChatRoom room = new ChatRoom();
    room.setId(UUID.randomUUID().toString());

    return room;
  }

  public void addMembers(User roomMaker, User guest) {
    this.chatRoomMembers.add(roomMaker);
    this.chatRoomMembers.add(guest);
  }
}
