package com.sz.zhiling.service;

import com.sz.zhiling.dao.ShowDao;
import com.sz.zhiling.model.Conferenceroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IShowImp implements IShow {
    @Autowired
    ShowDao showDao;

//    public void setShowDao(ShowDao showDao) {
//        this.showDao = showDao;
//    }

    @Override
    public List<Conferenceroom> showAll(int page) {
        return  showDao.showAll(page);
    }

    @Override
    public int showAllpage() {
        return showDao.showAllpage();
    }
}
