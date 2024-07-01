package com.krtopi.backend.user.friend;

import com.krtopi.backend.user.UserEntity;
import jakarta.persistence.*;

@Table(name = "friend_status")
@Entity
public class FriendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "friend_status_id")
    private Long id;

    private FriendStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity sentUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private UserEntity receivedUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FriendStatus getStatus() {
        return status;
    }

    public void setStatus(FriendStatus status) {
        this.status = status;
    }

    public UserEntity getSentUser() {
        return sentUser;
    }

    public void setSentUser(UserEntity sentUser) {
        this.sentUser = sentUser;
    }

    public UserEntity getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(UserEntity receivedUser) {
        this.receivedUser = receivedUser;
    }
}
