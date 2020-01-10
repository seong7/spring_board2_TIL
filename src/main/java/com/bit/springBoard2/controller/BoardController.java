package com.bit.springBoard2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.springBoard2.dao.IDao;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value="list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		return "list";
	}
	
	@RequestMapping(value="writeView")
	public String writeView() {
		return "writeView";
	}
	
	@RequestMapping(value="write")
	public String write(HttpServletRequest req) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(req.getParameter("bname"), req.getParameter("btitle"), req.getParameter("bcontent"));
		return "redirect:list";
	}
	
	@RequestMapping(value="contentView/{bid}" )					// "?bid=" 대신 "/" 표시   : 폴더의 위치가 바뀌므로 해당페이지에서 이동하는 href 주소 주의해야함
	public String contentView(@PathVariable int bid, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.upHitDao(bid);
		model.addAttribute("contentView", dao.contentViewDao(bid));
		return "contentView";
	}
	
	@RequestMapping(value="delete")
	public String delete(int bid) {			// 변수명 같으면 request 로 받지 않아도 됨  (post , get 둘 다 상관 없음
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(bid);
		return "redirect:list";
	}
	
	@RequestMapping(value="modify")		// 변수명 같으면 request 로 받지 않아도 됨  (post , get 둘 다 상관 없음
	public String modify(int bid, String bname, String btitle, String bcontent) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modifyDao(bid, bname, btitle, bcontent);
		return "redirect:list";
	}
	
	
}
