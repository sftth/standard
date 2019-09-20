package com.summit.springboot.standard.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import sun.swing.AccumulativeRunnable;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("Jacob", "summit");
        values.set("springboot","2.0");
        values.set("hello","world");

        Account account = new Account();
        account.setEmail("test@me.com");
        account.setUsername("Jacob");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println("####Redis " + byId.get().getUsername());
        System.out.println("####Redis " + byId.get().getEmail());
    }
}
