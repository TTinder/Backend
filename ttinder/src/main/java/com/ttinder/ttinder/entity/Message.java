package com.ttinder.ttinder.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Message extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sendUser;

    private Long receiveUser;

    @Column(length = 60)
    private String message;

    public Message(Long sendUser, Long receiveUser, String message) {
        this.sendUser = sendUser;
        this.receiveUser = receiveUser;
        this.message = message;
    }
}