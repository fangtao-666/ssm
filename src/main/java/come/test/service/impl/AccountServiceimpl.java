package come.test.service.impl;

import come.test.dao.IuserDao;
import come.test.entity.Account;
import come.test.entity.User;
import come.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class AccountServiceimpl implements IAccountService {
    @Autowired
    private IuserDao iuserDao;
    @Override
    public boolean select(User user) {
        if(iuserDao.select(user)!=0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void insert(User user) {
        System.out.println("111");
        iuserDao.insert(user);
    }

    @Override
    public void modify(String username, Double password, Double pwd) {
        iuserDao.modify(username,password,pwd);
    }

    @Override
    public List<Account> FindAll() {
        return iuserDao.findAll();
    }

    @Override
    public void AddAccount(String username, Double money) {
        iuserDao.AddAccount(username,money);
    }

    @Override
    public void DeleteAccount(int id) {
        iuserDao.deleteAccount(id);
    }

}
