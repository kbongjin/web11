package com.bong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coupang on 2017. 6. 29..
 */
@Service
public class BoardServiceImpl extends AbstractService {


    @Autowired
    private CommentRepository commentRepo;

    public void saveAll(Board board) {

        saveBoard(board);

        Comment comment = new Comment();
        comment.setComment("comment1111");
        comment.setUser("user1");

        commentRepo.save(comment);
    }
}
