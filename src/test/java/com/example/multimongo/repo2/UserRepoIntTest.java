package com.example.multimongo.repo2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.multimongo.MultiMongoApplication;
import com.example.multimongo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiMongoApplication.class)
public class UserRepoIntTest {

    @Autowired
    private UserRepository userRepo;

    private User user;

    @Before
    public void init() {
        userRepo.deleteAll();
        user = new User(1, "user 1");
    }

    @Test
    public void assertThatUserIsSaved() {
        userRepo.save(user);
        List<User> users = userRepo.findAll();
        assertThat(users.size()).isEqualTo(1);
        User u = users.get(0);
        assertThat(u.getName()).isEqualTo("user 1");
        assertThat(u.getId()).isNotNull();
    }


}
