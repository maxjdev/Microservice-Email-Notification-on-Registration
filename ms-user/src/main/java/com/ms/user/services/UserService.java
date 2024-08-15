package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserModel save(UserModel model) {
        return repository.save(model);
    }
}
