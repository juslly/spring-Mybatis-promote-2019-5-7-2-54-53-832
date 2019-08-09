package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll() {
        return null;
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable long userId) {
        return null;
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable int userId) {
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable long userId) {
    }
    
    @RequestMapping("/toUserList")
    public String toUserList(){
        return "userList";
    }
    
     @RequestMapping("/getUserList")
    @ResponseBody
    public String getUserList(Integer page,Integer limit){
        LayuiResponseJSONBean layuiResponseJSONBean;
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        Page pages = new Page(page,limit);
        Page<Map> userList = userService.getUserList(pages);
        List<Map> list = userList.getRecords();
        //总数
        Integer total = userList.getTotal();
        layuiResponseJSONBean = LayuiResponseJSONBean.getSuccessClientResponseJSONBean();
        layuiResponseJSONBean.setCount(total);
        layuiResponseJSONBean.setData(list);
        return layuiResponseJSONBean.toJSONString();
    }
}
