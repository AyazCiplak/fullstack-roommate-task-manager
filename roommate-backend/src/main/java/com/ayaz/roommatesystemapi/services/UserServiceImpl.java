package com.ayaz.roommatesystemapi.services;

import com.ayaz.roommatesystemapi.entity.UserEntity;
import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createRoommate(User roommate) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(roommate, userEntity);
        userRepository.save(userEntity);
        return roommate;
    }

    @Override
    public List<User> getAllUsers(){
        //Retrieves all users in database
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities
                .stream()
                .map(user -> new User(
                        user.getId(),
                        user.getName(),
                        user.getDescription()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(Long id){
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

}
