package com.bong.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by coupang on 2017. 6. 20..
 */
@Repository
public class BoardRepository {

    private static final Logger logger = LoggerFactory.getLogger(BoardRepository.class);


    @Autowired
    SessionFactory sessionFactory;

    public List<Board> selectAll() {

        Session session = sessionFactory.openSession();

        List<Board> result = session.createQuery("from Board").list();

        session.close();

        return result;
    }

    public void save() {

        Board board = new Board();
        //board.setSeq(1);
        board.setTitle("title111");
        board.setRegdate(new Date());

        save(board);
    }

    @Transactional
    public void save(Board board) {
        Session session = sessionFactory.getCurrentSession();

        //Integer seq = (Integer)session.save(board);
        session.persist(board);

        logger.debug("persist!! ");
    }

    @Transactional
    public void update(Board board) {

        Session session = sessionFactory.getCurrentSession();

        board.setTitle("update title!!");

        session.update(board);

        logger.debug("updated!! ");
    }

    public Board find(Integer seq) {
        Session session = sessionFactory.openSession();

        return (Board)session.get(Board.class, seq);
    }
}
