package com.simplemessenger.repository;

import com.simplemessenger.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
    Account findByEmail(String email);
    @Query("select  account from Account account where account.username like %:#{#username}% order by account.username")
    List<Account> findAllByUsername(@Param("username") String username);
    @Query("select  account from Account account where account.email like %:#{#email}% order by account.email")
    List<Account> findAllByEmail(@Param("email") String email);
}
