package com.suwan.infinityscroll.repository;

import com.suwan.infinityscroll.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
