package com.geniusver.service;

import com.geniusver.entity.User;
import com.geniusver.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {
    //判断用户名在数据库表users是否已经被注册过
    public boolean checkUsernameValid(User user) {
        //连接数据库
        Connection conn = DBHelp.getCon();
        String sql = "select * from User where username=?";
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUseName());
            rs = stm.executeQuery();
            if (rs.next())//为真说明当前用户名被查到了，已经被注册过了，所以不合法
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelp.closeDBResource(rs, stm, conn);
        }
        return true;
    }

    public User checkUserValid(User user) {
        Connection conn = DBHelp.getCon();
        String sql = "select * from User where username=? AND password=?";
        ResultSet rs = null;
        PreparedStatement stm = null;
        User result = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUseName());
            stm.setString(2, user.getPwd());
            rs = stm.executeQuery();
            if (rs.next()) {
                result = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("tel")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelp.closeDBResource(rs, stm, conn);
        }
        return result;
    }

    public boolean updateUser(User user) {
        if (user == null) {
            throw new NullPointerException("user should not be null");
        }

        Connection conn = DBHelp.getCon();
        String sql = "update User set password=?, email=?, tel=? where username=?";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getPwd());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getTel());
            stm.setString(4, user.getUseName());
            int num = stm.executeUpdate();
            if (num == 1)//说明影响的行数是一条，说明数据插入成功
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    public boolean registerWriteDB(User user) {
        Connection conn = DBHelp.getCon();
        String sql = "insert into User values(?,?,?,?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user.getUseName());
            stm.setString(2, user.getPwd());
            stm.setString(3, user.getEmail());
            stm.setString(4, user.getTel());
            int num = stm.executeUpdate();
            if (num == 1)//说明影响的行数是一条，说明数据插入成功
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
