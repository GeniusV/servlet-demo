package com.hjc.service;

import com.hjc.entity.Good;
import com.hjc.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeniusV on 5/15/18.
 */
public class GoodService {
    private Good good;

    public GoodService(Good good) {
        this.good = good;
    }

    public GoodService() {

    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }


    public List<Good> getGoodList(int category) {
        ArrayList<Good> result = new ArrayList<>();
        Connection conn = DBHelp.getCon();
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sql;
        if (category > 0 && category < 4) {
            sql = "select * from goods where category=?";
        } else {
            sql = "select * from goods";
        }
        try {
            stm = conn.prepareStatement(sql);
            if (category > 0 && category < 4) {
                stm.setInt(1, category);
            }
            rs = stm.executeQuery();
            while (rs.next()) {
                result.add(new Good(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("info"),
                        rs.getString("imgPath"),
                        rs.getInt("category"),
                        rs.getFloat("price"),
                        rs.getInt("num")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelp.closeDBResource(rs, stm, conn);
        }
        return result;
    }
}
