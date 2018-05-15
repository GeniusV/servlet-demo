package com.hjc.service;

import com.hjc.entity.Good;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GeniusV on 5/15/18.
 */
public class GoodServiceTest {

    @Test
    public void testGetGoodList(){
        GoodService service = new GoodService();

        List<Good> goods = service.getGoodList(2);

        assertNotEquals(0, goods.size());
        System.out.println(goods);
    }

}