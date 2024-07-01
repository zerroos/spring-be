package com.krtopi.backend.user.friend;

import com.krtopi.backend.user.UserEntity;

public interface FriendService {

    boolean friendCombinationExists(UserEntity user1, UserEntity user2);
}
