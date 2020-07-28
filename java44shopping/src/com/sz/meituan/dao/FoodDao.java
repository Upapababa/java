package com.sz.meituan.dao;

import com.sz.meituan.dbutils.DBUtils;
import com.sz.meituan.model.Food;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodDao {

    private QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    //查询所有的菜；
    public List<Food> getAllFood(){
        try {
            return runner.query("select * from food",new BeanListHandler<>(Food.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //查询一个菜；
    public Food getFoodByFid(int fid){
        try {
            return runner.query("select * from food where fid=?",new BeanHandler<>(Food.class),fid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FoodDao dao = new FoodDao();
        System.out.println("dao = " + dao.getAllFood());
    }

    public int update(String orderid) {
        String sql="update orderform set otype='已取消' where orderid=?";
        try {
            int s=runner.update(sql,Integer.parseInt(orderid));
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
