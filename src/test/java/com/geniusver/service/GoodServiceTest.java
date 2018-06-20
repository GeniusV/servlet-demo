package com.geniusver.service;

import com.geniusver.entity.Good;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GeniusV on 5/15/18.
 */
public class GoodServiceTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testGetGoodList() {
        GoodService service = new GoodService();

        List<Good> goods = service.getGoodList(0, 1);

        assertNotEquals(0, goods.size());
        System.out.println(goods);

        logger.debug("hhh");
        logger.info("hhh");
        logger.warn("hhh");

    }
}