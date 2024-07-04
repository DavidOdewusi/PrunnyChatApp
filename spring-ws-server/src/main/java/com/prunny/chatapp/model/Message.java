package com.prunny.chatapp.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
