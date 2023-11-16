package com.daniele.passwordmanager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "url")
    private String url;
    @Column(name = "notes")
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
