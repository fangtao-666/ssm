package come.test.service;

import come.test.entity.Account;
import come.test.entity.User;

import java.security.PrivateKey;
import java.util.List;

public interface IAccountService {

    boolean select(User user);

    void insert(User user);

    //修改密码
    void modify(String username,Double password,Double pwd);

    //查找Account列表
    public List<Account> FindAll();

    //插入Account数据
    public  void AddAccount(String username,Double money);

    //删除Account数据
    public  void DeleteAccount(int id);

}


