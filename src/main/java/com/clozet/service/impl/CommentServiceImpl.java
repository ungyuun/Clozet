package com.clozet.service.impl;

import com.clozet.model.dto.CommentDto;

import com.clozet.model.entity.Comment;
import com.clozet.repository.CommentRepository;
import com.clozet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional()
public class CommentServiceImpl implements CommentService {
    @Override
    public void addComment(CommentDto comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void recommend(boolean click) {

    }

    @Override
    public void deleteComment(int commentId) {

    }

    @Override
    public List<Comment> getCommentList(int prodNo) throws Exception {
        return null;
    }

    @Override
    public Comment getComment(int commentId) throws Exception {
        return null;
    }

//    @Autowired
//    @Qualifier("commentRepository")
//    private CommentRepository commentRepository;
//
//    public void setCommentDao(CommentDao commentDao){
//        this.commentDao = commentDao;
//    }
//
////	public void addComment(Map<String, Object> commentMap) {
////
////		commentDao.addComment(commentMap);
////	}
//
//    public void updateComment(CommentDto commentDto) {
//        commentDao.updateComment(commentDto);
//    }
//    public void recommend(boolean click) {
//
//        commentDao.recommend(click);
//    }
//
//    public void deleteComment(Long commentId) {
//
//        commentDao.deleteComment(commentId);
//    }
//
//    public List<CommentDto> getCommentList(Long postNo) throws Exception {
//
//        List<CommentDto> list = commentDao.getCommentList(postNo);
//
//        return list;
//    }
//
//
//    public CommentDto getComment(Long commentNo) throws Exception {
//
//        return commentDao.getComment(commentNo);
//    }
//
//
//    public void addComment(CommentDto comment) {
//        commentDao.addComment(comment);
//
//    }
//
//


}
