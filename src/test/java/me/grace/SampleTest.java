package me.grace;


import lombok.extern.log4j.Log4j;
import me.grace.mapper.TimeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class SampleTest {

    @Autowired
    private DataSource source;

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void testConnection() {
        try (Connection con = source.getConnection()) {
            log.debug(con);
        } catch (SQLException e) {

        }
    }

    @Test
    public void testMyBatis() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();) {
            log.info(session);
            log.info(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTime() {
        log.info(timeMapper.getTime());
    }
}
