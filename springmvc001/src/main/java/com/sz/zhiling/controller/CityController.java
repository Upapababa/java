package com.sz.zhiling.controller;

import com.sz.zhiling.module.Citys;
import com.sz.zhiling.module.ResoultPage;
import com.sz.zhiling.service.ICity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController  {

    @Autowired
    private ICity iCity;
    @Autowired
    private ResoultPage resoultPage;

//    进入HTML页面
    @RequestMapping("/1")
    public String back(){
        return "Stt";
    }


    //删除一个城市
    @RequestMapping("/del")
    @ResponseBody
    public int delCity(@RequestParam("aid") String aid){
        int x=iCity.del(Integer.parseInt(aid));
        return x;
    }



    //查询所有分页后的城市和分页信息
    @RequestMapping("/show")
    @ResponseBody
    public ResoultPage getAllCity(@RequestParam("page") String pa){
        int page=Integer.parseInt(pa);
        resoultPage.setList(iCity.showAllCity(page));
        resoultPage.setCount(iCity.showAllPage());
        resoultPage.setPage(page);
        return resoultPage;
    }

    //查询上级省的名字
    @RequestMapping("/show2")
    @ResponseBody
    public String getPname(@RequestParam("fid") String fid){
        return iCity.showCityName(Integer.parseInt(fid));
    }


    //添加与修改省市
    @RequestMapping("/add")
    @ResponseBody
    public String updateCity(@RequestParam String cname,String pname ,String aid){
        String msg="";
        if(aid==""){
            //添加
            if(cname=="" ||cname ==null){
                //市为空，添加省
                int n=iCity.addPname(pname);
                msg=n>0?"添加省成功":"添加省失败";
            }else{
                int aid2=iCity.showAid(pname);
                if(aid2==0){
                    int n=iCity.addPname(pname);
                    aid2=iCity.showAid(pname);
                    int s=iCity.addCname(cname,aid2);
                    msg=s>0?"添加省市成功":"添加省市失败";
                }else{
                    int s=iCity.addCname(cname,aid2);
                    msg=s>=0?"添加市成功":"添加市失败";
                }
            }
        }else{
            //修改
            if(cname=="" ||cname ==null){
                int n=iCity.updpname(pname,aid);
                msg=n>0?"修改省成功":"修改省失败";
            }else{
                int fid=iCity.showAid(pname);
                int n=iCity.updCity(cname,fid,aid);
                msg=n>0?"修改成功":"修改失败";
            }
        }



        return msg;
    }

    //查询所有省
    @RequestMapping("/select")
    @ResponseBody
    public List<Citys> getAllPrivce(){
        return iCity.getAllPrivce();
    }

}

