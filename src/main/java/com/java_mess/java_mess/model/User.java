package com.java_mess.java_mess.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="user")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "appId", nullable = false)
    @JsonIgnore
    private App app;

    @Column(name = "clientUserId")
    private String clientUserId;

    @Column(name = "name")
    private String name;

    @Column(name = "profileImgUrl")
    private String profileImgUrl;

    @CreationTimestamp
    private Instant createdAt;
}
