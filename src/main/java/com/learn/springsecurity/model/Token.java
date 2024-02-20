package com.learn.springsecurity.model;

import static com.learn.springsecurity.enumerated.TokenType.BEARER;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.UUID;

import com.learn.springsecurity.enumerated.TokenType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_token")
public class Token {
    @Id
    @GeneratedValue(strategy = UUID)
    public String id;

    @Column(unique = true)
    public String token;

    @Builder.Default
    @Enumerated(STRING)
    public TokenType tokenType = BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}
