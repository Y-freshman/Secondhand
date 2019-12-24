package com.schoolTao.dao;

import com.schoolTao.pojo.Comment;
import com.schoolTao.pojo.CommentExample;
import com.schoolTao.pojo.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);
    
    List<Comment> selectCommentAndUser(Integer needId);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

	int incNum(Integer commentId);

	List<Comment> selectByLimit(@Param("page")Integer page, @Param("limit")Integer limit);
}