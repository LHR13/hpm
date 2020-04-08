package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.CheckWork;
import com.lhr13.hpm.dao.CheckWorkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CheckWorkService {

    @Autowired
    private CheckWorkDAO checkWorkDAO;

    public List<CheckWork> findAll() {
        List<CheckWork> checkWorks = checkWorkDAO.findAll();
        Iterator<CheckWork> cw = checkWorks.iterator();
        while (cw.hasNext()) {
            CheckWork checkWork = cw.next();
            if (checkWork.getPerson().getInfoState() == 0) {
                cw.remove();
            }
        }
        return checkWorks;
    }

    public List<CheckWork> findByName(String name) {
        return checkWorkDAO.findByPerson_Name(name);
    }
}
