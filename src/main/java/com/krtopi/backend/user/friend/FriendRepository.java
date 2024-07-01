package com.krtopi.backend.user.friend;

import com.krtopi.backend.user.UserEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<FriendEntity, Long> {
    @Query("SELECT f FROM FriendEntity f WHERE (f.sentUser = :user1 AND f.receivedUser = :user2) OR (f.sentUser = :user2 AND f.receivedUser = :user1)")
    Optional<FriendEntity> findByUserCombination(@Param("user1") UserEntity user1, @Param("user2") UserEntity user2);
}
