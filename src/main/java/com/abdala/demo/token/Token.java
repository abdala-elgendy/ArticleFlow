package com.abdala.demo.token;

import com.abdala.demo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "token", unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "tokenType")
    public TokenType tokenType = TokenType.BEARER;

    @Column(name = "revoked")
    public boolean revoked;
    @Column(name = "expired")
    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
