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

    public List<Good> getGoodList(int catagory) {
        ArrayList<Good> result = new ArrayList<>();
        Connection conn = DBHelp.getCon();
        String sql = "select * from goods where category=?";
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, catagory);
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


    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
