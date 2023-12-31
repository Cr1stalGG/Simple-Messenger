package com.simplemessenger.repository;

import com.simplemessenger.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findById(long id);
    @Query("select  message from Message message where message.message like %:#{#message}% order by message.date")
    List<Message> findAllByMessage(@Param("message") String message);
}
