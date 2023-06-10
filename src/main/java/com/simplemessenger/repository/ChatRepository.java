package com.simplemessenger.repository;

import com.simplemessenger.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findById(long id);
    /*@Query("select chat from Chat chat where chat.toAccount.id = %#{#toAccountId}%")
    Chat findBySenderId(@Param("toAccountId") long toAccount);*/
}
