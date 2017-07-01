package com.bong.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coupang on 2017. 6. 29..
 */
@Service
@Transactional
public abstract class AbstractService {

    private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    private BoardRepository boardRepo;

    public void saveBoard(Board board) {

        logger.debug("saveBoard!!");

        boardRepo.save(board);

    }
}
