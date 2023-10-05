package com.clozet.service;

import com.clozet.model.dto.CommentDto;
import com.clozet.model.entity.Comment;

import java.util.List;

public interface CommentService {

    public void addComment(CommentDto comment);

    public void updateComment(Comment comment);

    public void recommend(boolean click);

    public void deleteComment(int commentId);

    public List<Comment> getCommentList(int prodNo) throws Exception;

    public Comment getComment(int commentId) throws Exception;

    //public int getTotalCount(Search search) throws Exception ;
}
