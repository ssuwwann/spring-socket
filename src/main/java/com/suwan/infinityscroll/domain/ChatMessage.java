package com.suwan.infinityscroll.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(value = {AuditingEntityListener.class})
public class ChatMessage {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "roomId", insertable = false, updatable = false)
  private String roomId; // 단순한 id값만 필요 => 여기선 username인가?

  @JoinColumn(name = "authorId", insertable = false, updatable = false)
  private String authorId; // 단순한 id값만 필요 => 여기선 username인가?

  private String message;

  @CreationTimestamp
  private Timestamp createdAt;
}
