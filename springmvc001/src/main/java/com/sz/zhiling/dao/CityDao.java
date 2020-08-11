package com.sz.zhiling.dao;

import com.sz.zhiling.module.Citys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询分页的城市信息
    public List<Citys> showAllCity(int page){
        String sql="select * from(\n" +
                "      select rownum rn , tt.*from(\n" +
                "           select * from t_addr order by aid desc \n" +
                "\t) tt where rownum<=?*5\n" +
                ") where rn>?*5\n";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Citys.class),page,page-1);
    }

    //查询页数
    public int showAllPage(){
        String sql="select * from t_addr";
        List s=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Citys.class));
        if(s.size()%3==0){
            return s.size()/3;
        }else {
            return s.size()/3+1;
        }
    }

    //删除一条数据
    public int del(int aid) {
        String sql="delete from t_addr where aid=?";
        return jdbcTemplate.update(sql,aid);
    }


    //查询市的上级省名
    public String showCityName(int fid) {
        String sql="select aname from t_addr where aid=?";
        return jdbcTemplate.queryForObject(sql,String.class,fid);
    }

    //添加省
    public int addPname(String pname) {
        String sql="insert into t_addr values(addr_seq_aid.nextval,?,0)";
        return jdbcTemplate.update(sql,pname);
    }

    //查询省的id,如果不存在就返回0，重新添加省
    public int showAid(String pname) {
        String sql="select aid from t_addr where aname=?";
        try{
            int s=jdbcTemplate.queryForObject(sql,int.class,pname);
            return s;
        }catch(Exception e){
            return 0;
        }
    }

    //添加一个市
    public int addCname(String cname, int aid) {
        String sql="insert into t_addr values(addr_seq_aid.nextval,?,?)";
        return jdbcTemplate.update(sql,cname,aid);
    }

    public int updpname(String pname,String aid) {
        String sql="update t_addr set aname=? where aid=?";
        return jdbcTemplate.update(sql,pname,Integer.parseInt(aid));
    }

    public int updCity(String cname, int fid, String aid) {
        String sql="update t_addr set aname=?,fid=? where aid=?";
        return jdbcTemplate.update(sql,cname,fid,Integer.parseInt(aid));
    }

    public List<Citys> getAllPrivce() {
        String sql="select * from t_addr where fid=0";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Citys.class));
    }
}
