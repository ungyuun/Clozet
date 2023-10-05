package com.clozet.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.clozet.model.dto.CommentDto;
import com.clozet.model.dto.UserDto;
import com.clozet.service.CommentService;
import com.clozet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/comment/*")
public class CommentController {

//	@Autowired
//	@Qualifier("commentServiceImpl")
//	private CommentService commentService;
//
//	@Autowired
//	@Qualifier("productServiceImpl")
//	private ProductService productService;
//	public CommentController() {
//
//	}
//	@RequestMapping("/addComment")
//	public CommentDto addComment(@RequestBody CommentDto commentDto, HttpSession session, Model model) throws Exception {
//
//		System.out.println("addComment()");
//		UserDto user = (UserDto) session.getAttribute("user");
//
//		commentService.addComment(commentDto);
//		commentDto = commentService.getComment(commentDto.getCommentNo());
//
//		return commentDto;
//	}
//	@RequestMapping("/getComment/{commentNo}")
//	public CommentDto getComment(@PathVariable("commentNo") int commentNo,@RequestBody CommentDto commentDto) throws Exception{
//		return commentService.getComment(commentNo);
//	}
//	@RequestMapping("/updateComment")
//	public CommentDto updateComment(@RequestBody CommentDto commentDto, Model model) throws Exception{
//
//
//
//		commentService.updateComment(commentDto);
//		System.out.println(commentDto.getCommentNo());
//		commentDto = commentService.getComment(commentDto.getCommentNo());
//
//		System.out.println("성공");
//		// 업데이트한 게시물 아이디
//		return commentDto;
//	}
//	@RequestMapping("/deleteComment/{commentNo}")
//	public String deleteComment(@PathVariable("commentNo") int commentNo, Model model) throws Exception{
//		System.out.println("deleteComment");
//		System.out.println("커멘트 " +commentNo);
//		commentService.deleteComment(commentNo);
//		return "/product/getProduct.jsp";
//	}
//	@RequestMapping("/getCommentList/{prodNo}")
//	public List<CommentDto> getCommentList(@PathVariable("prodNo") int prodNo) throws Exception {
//
//		System.out.println("getCommentList()");
//		List<CommentDto> commentDto= commentService.getCommentList(prodNo);
//
//		return commentDto;
//	}
//
//	//	@RequestMapping("/checkPassword")
////	public boolean checkPassword(@RequestParam("checkPassword") String reqPassword, @RequestParam("checkPasswordbt") int commentNo, Model model) throws Exception {
////
////
////		System.out.println("checkPass");
////		System.out.println(reqPassword+commentNo);
////		Comment comment = commentService.getComment(commentNo);
////		System.out.println(reqPassword+comment.getPassword());
////	    model.addAttribute("comment", comment);
////
////	    return reqPassword.equals(comment.getPassword());
////	}
//	@RequestMapping("/checkPassword")
//	public CommentDto checkPassword(@RequestBody Map<String, String> requestMap, Model model) throws Exception {
//		String reqPassword = requestMap.get("password");
//		int commentNo = Integer.parseInt(requestMap.get("commentNo"));
//
//		System.out.println("checkPass");
//		System.out.println(reqPassword + commentNo);
//
//		CommentDto commentDto = commentService.getComment(commentNo);
//		System.out.println(reqPassword + commentDto.getPassword());
//
//		if (reqPassword.equals(commentDto.getPassword())==true)
//			return commentDto;
//		else {
//			System.out.println("null 반환");
//			return null;
//		}
//	}
//



}
