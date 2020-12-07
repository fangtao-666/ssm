package come.test.controller;

import com.alibaba.fastjson.JSONObject;
import come.test.entity.Account;
import come.test.entity.User;
import come.test.service.impl.AccountServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.nio.cs.US_ASCII;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AccountController {
    @Autowired
    private AccountServiceimpl accountServiceimpl;
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        double password = Double.parseDouble(request.getParameter("password"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean is = accountServiceimpl.select(user);
        if (is) {
            return "main";
        } else {
            return "fail";
        }


    }
    @RequestMapping("/insert")
    public String insert(HttpServletRequest request){
        return "insert";
    }


    @RequestMapping("/insertUser")
    public String insertUser(HttpServletRequest request){
        String username = request.getParameter("username");
        double password = Double.parseDouble(request.getParameter("password"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        accountServiceimpl.insert(user);
        return "index";
    }
    //修改密码
    @RequestMapping("/modify")
    public String modify( HttpServletRequest request){
        String username = request.getParameter("username");
        Double password = Double.parseDouble(request.getParameter("password"));
        Double pwd = Double.parseDouble(request.getParameter("pwd"));
        accountServiceimpl.modify(username,password,pwd);
        return "index";
    }
    //跳转到修改密码界面
    @RequestMapping("/modifypassword")
    public String modifyPassword(){
        return "modifypassword";
    }
    //跳转登录界面
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    //返回前端JSON数据格式
    @GetMapping ("/pageList")
    public void  pagelist(HttpServletResponse response){
        JSONObject json = new JSONObject();
        List<Account> accounts = accountServiceimpl.FindAll();

        json.put("msg","");
        json.put("code",0);
        json.put("count",1000);
        json.put("data",accounts);

        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //跳转到增加Account页面
    @RequestMapping("/ToAddAccount")
    public String ToAddAccount(){
        return "add";
    }

    //添加Account
    @RequestMapping("/AddAccount")
    public String AddAccount(HttpServletRequest request){
        String username = request.getParameter("username");
        Double money = Double.parseDouble(request.getParameter("money"));
        //System.out.println(username+money);
        accountServiceimpl.AddAccount(username,money);
        return "main";

    }

    //删除Account
    @RequestMapping("/deleteAccount")
    public String DeleteAccount(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        accountServiceimpl.DeleteAccount(id);
        return "main";


    }

    //跳转edit页面
    @RequestMapping("/ToEditAccount")
    public String ToEditAccount(){
        return "edit";
    }




}
