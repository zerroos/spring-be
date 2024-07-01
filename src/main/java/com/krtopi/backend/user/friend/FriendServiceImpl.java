package com.krtopi.backend.user.friend;

import com.krtopi.backend.user.UserEntity;
import com.krtopi.backend.user.UserRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl {
    private FriendRepository friendRepository;
    private UserRepository userRepository;
    public FriendServiceImpl(FriendRepository friendRepository,UserRepository userRepository){
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }
    public boolean createFriendRequest(Long senderId, Long receiverId, FriendEntity friend){
        UserEntity senderUser = this.userRepository.findById(senderId).orElseThrow(() -> new ResourceNotFoundException("sender user not found"));
        UserEntity receiverUser = this.userRepository.findById(receiverId).orElseThrow(() -> new ResourceNotFoundException("receiver user not found"));
        friend.setSentUser(senderUser);
        friend.setReceivedUser(receiverUser);
        this.friendRepository.save(friend);
        return false;
    }
    public boolean updateFriendRequest(Long senderId, Long receiverId, FriendEntity friend){
        UserEntity senderUser = this.userRepository.findById(senderId).orElseThrow(() -> new ResourceNotFoundException("sender user not found"));
        UserEntity receiverUser = this.userRepository.findById(receiverId).orElseThrow(() -> new ResourceNotFoundException("receiver user not found"));
        friend.setSentUser(senderUser);
        friend.setReceivedUser(receiverUser);
        this.friendRepository.save(friend);
        return false;
    }
}
