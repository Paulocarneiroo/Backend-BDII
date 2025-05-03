package com.bdII.bdII.services;

import com.bdII.bdII.entities.Calc;
import com.bdII.bdII.entities.User;
import com.bdII.bdII.repositories.CalcRepository;
import com.bdII.bdII.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalcService {

    @Autowired
    private UserRepository repository;

    public Optional<List<Calc>> findById(Long id) {
        return repository.findById(id)
                .map(User::getCalcs);
    }

    public void delete(Long id) {
        Optional<User> user = repository.findById(id);

        user.ifPresent(u -> {
            u.getCalcs().clear();
            repository.save(u);
        });
    }

    public Optional<Calc> save(Long userId, Calc calc) {
        Optional<User> optionalUser = repository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.getCalcs().add(calc);
            repository.save(user);

            return Optional.of(calc);
        }

        return Optional.empty();
    }


}
