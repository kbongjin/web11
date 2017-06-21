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

    @Transactional
    public void save() {
        Session session = sessionFactory.getCurrentSession();

        Board board = new Board();
        //board.setSeq(1);
        board.setTitle("title111");
        board.setRegdate(new Date());

        //Integer seq = (Integer)session.save(board);
        session.persist(board);

        logger.debug("saved!! ");
    }
}
