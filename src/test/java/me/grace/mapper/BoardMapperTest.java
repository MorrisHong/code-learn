package me.grace.mapper;

import lombok.extern.log4j.Log4j;
import me.grace.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
@Log4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        mapper.getList().forEach(log::info);
    }

    @Test
    public void testInsert() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("매퍼 테스트 제목");
        boardVO.setContent("매퍼 테스트 내용");
        boardVO.setWriter("매퍼 테스트 글쓴이.");

        mapper.insertSelectKey(boardVO);

        log.info(boardVO);
    }

    @Test
    public void testRead() {

        BoardVO read = mapper.read(5L);
        log.info(read);
    }

    @Test
    public void testDelete() {
        log.info(mapper.delete(5L));
    }

    @Test
    public void testUpdate() {

    }
}