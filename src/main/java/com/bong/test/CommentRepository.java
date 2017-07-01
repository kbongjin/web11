package com.bong.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by coupang on 2017. 6. 29..
 */
@Repository
public class CommentRepository {

    private static final Logger logger = LoggerFactory.getLogger(CommentRepository.class);

    @Autowired
    SessionFactory sessionFactory;


    //@Transactional
    public void save(Comment comment) {
        //Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();

        //Integer id = (Integer)session.save(comment);
        session.persist(comment);

        session.close();
        logger.debug("comment persisted!! ");
    }
}
