package com.dessert.ringring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dessert.ringring.domain.DTOBoard;

@Mapper
public interface BoardMapper {
	
	public int insertBoard(DTOBoard board); //게시글 생성 쿼리 호출
	public DTOBoard selectBoardDetail(int idx); //게시글 조회 쿼리 호출
	public int updateBoard(DTOBoard board); //게시글 수정 쿼리 호출
	public int deleteBoard(int idx); //게시글 삭제 쿼리 호출
	public List<DTOBoard> selectBoardList(); //게시글 목록 조회 쿼리 호출
	public int selectBoardTotalCount(); //삭제여부 N으로 지정된 게시글 조회 쿼리 호출

}
