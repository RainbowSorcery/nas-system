package com.lyra.nas;

import cn.dev33.satoken.secure.BCrypt;
import com.lyra.nas.entity.User;
import com.lyra.nas.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NasSystemApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        String hashpw = BCrypt.hashpw("365373011");
        System.out.println(hashpw);
    }

}
