package com.simplemessenger.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CHATS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Account fromAccount;
    @OneToOne
    private Account toAccount;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Message> messages;

    public void addMessage(Message message){
        this.messages.add(message);
    }

}
