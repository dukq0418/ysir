package com.dkq.service.impl;

import com.dkq.dao.AdminDao;
import com.dkq.pojo.Admin;
import com.dkq.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    /**
     *  @Autowired  @Qualifier 必须同时用 Autowired 自动注入 Qualifier 明确具体类
     *   如果前面注入标签命名了  只能用下面的
     *   @Resource(name="adminDao") 相当于上面两个的综合注入明确的类
     */
    @Resource(name="adminDao")
    private AdminDao adminDao;

    @Override
    public List<Admin> login(Admin admin) {
        return adminDao.login(admin);
    }
}
