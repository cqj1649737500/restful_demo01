package com.dj.ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResultModel<Object> selectById(@PathVariable Integer id){
        try{
            User list = userService.getById(id);
            return new ResultModel<Object>().success(list);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }


    }


    @GetMapping
    public ResultModel<Object> show(){
        try{
            List<User> list = userService.list();
            return new ResultModel<Object>().success(list);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }
    }

    @PostMapping
    public ResultModel<Object> add(User user){
        try{
           userService.save(user);
            return new ResultModel<Object>().success();
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }
    }

    @PutMapping
    //public ResultModel<Object> update(User user){
    public ResultModel<Object> update(@RequestBody User user){
        try{
           userService.updateById(user);
            return new ResultModel<Object>().success();
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }
    }


    @DeleteMapping("/{id}")
    public ResultModel<Object> deleteUser(@PathVariable  Integer id){
        try{
            userService.removeById(id);
            return new ResultModel<Object>().success();
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }
    }

    @PostMapping("/list")
    public ResultModel<Object> showPage(Integer pageNo){
        try{
            IPage<User> iPage = new Page<User>(pageNo, 3);


            IPage page = userService.page(iPage);
            List<User> list = page.getRecords();

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("list", list);
            map.put("pages", page.getPages());

            return  new ResultModel<Object>().success(map);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResultModel<Object>().error("服务器异常");
        }
    }


    @PostMapping("/addUserFile")
    public ResultModel<Object> addUser(User user, MultipartFile file) {
        try {
            System.out.println(user.getUserName());
            String fileName = file.getOriginalFilename();

            return new ResultModel<Object>().success(fileName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<Object>().error("服务器异常");
        }
    }

}
