package cn.joharxiao.dao.impl;

import cn.joharxiao.dao.MavenTestDao;
import cn.joharxiao.domain.MavenTest;
import cn.joharxiao.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MavenTestDaoImpl implements MavenTestDao {
    Connection con= JdbcUtil.getCon();
    @Override
    public List<MavenTest> showAll() {
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<MavenTest> lists=new ArrayList<MavenTest>();
//        String sql="select * from maventest;";
        String sql="select * from maventest where id > ?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                MavenTest maven=new MavenTest();
                maven.setId(rs.getInt("id"));
                maven.setName(rs.getString("name"));
                maven.setHobby(rs.getString("hobby"));
                lists.add(maven);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(con,ps,rs);
        }
        return lists;
    }
}
