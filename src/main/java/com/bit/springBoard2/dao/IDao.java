package com.bit.springBoard2.dao;

import java.util.ArrayList;

import com.bit.springBoard2.dto.BoardDto;

public interface IDao {
	
	public void writeDao(String bname, String btitle, String bcontent);
	public void modifyDao(int bid, String bname, String btitle, String bcontent);
	public ArrayList<BoardDto> listDao();
	public BoardDto contentViewDao(int bid);
	public void deleteDao(int bid);
	public void upHitDao(int bid); 
	
}
