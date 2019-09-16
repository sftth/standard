package com.summit.springboot.standard.account;

import javafx.beans.binding.Bindings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() {

    }

    @Test
    public void slicingTest() throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("@@@"+ metaData.getURL());
            System.out.println("@@@"+ metaData.getDriverName());
            System.out.println("@@@"+ metaData.getUserName());
        }
    }

    @Test
    public void springBootTest() throws SQLException {
        Account account = new Account();
        account.setUsername("Jacob");
        account.setPassword("1234");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Optional<Account> existAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existAccount).isNotEmpty();

        Optional<Account> notExistAccount = accountRepository.findByUsername("ja");
        assertThat(notExistAccount).isEmpty();
    }
}
