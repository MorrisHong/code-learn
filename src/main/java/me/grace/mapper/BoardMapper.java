package me.grace.mapper;

import me.grace.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> getList();
    Long insertSelectKey(BoardVO boardVO);
    BoardVO read(Long bno);
    int delete(Long bno);
    int update(BoardVO boardVO);
}
