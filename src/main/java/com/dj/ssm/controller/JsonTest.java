package com.dj.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.QueryUser;
import com.dj.ssm.pojo.User;
import com.google.gson.JsonArray;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.control.Alert;

import java.util.List;
import java.util.Map;

public class JsonTest {

    private String aa;

    private String u;
    private String uy;
    private String u_dev;

    public void  ab(){
        System.out.println("s");
    }


    public void a(){
        System.out.println("b");
    }
    public static void main(String[] args) {
      //  JsonTest.test01();
       // JsonTest.test02();
       // JsonTest.test04();
        //test03();
        test06();
    }

    public static void test01(){
        String str = "{'userName':'qq','userPwd':'23'}";
        Map mapTypes = JSON.parseObject(str);

        //json字符串---json对象
        JSONObject obj = JSONObject.parseObject(str);
        //json对象-----java对象
        User user = obj.toJavaObject(User.class);
        System.out.println(user.getUserName()+"......"+user.getUserPwd());
        //json字符串----java对象
        User userStr = JSONObject.parseObject(str, User.class);
        //java对象-----json字符串
        String usersStr = JSONObject.toJSONString(userStr);
        System.out.println(usersStr);

    }
    public static void test03(){
        String str = "[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"},{\"userName\":\"qc\",\"userPwd\":\"123\"},{\"userName\":\"qw\",\"userPwd\":\"123\"}]";
        //json字符串转换json数组
        JSONArray arr = JSONArray.parseArray(str);
        //json数组转换成java集合
        List<User> userList = arr.toJavaList(User.class);
        System.out.println(userList.size());
        // list--->str
        String s = JSONArray.toJSONString(userList);
        System.out.println(s);

    }

    public static void test02(){
        String str = "[1,2,3]";
        //json字符串转换成json数组
        JSONArray arr = JSONArray.parseArray(str);
        System.out.println(arr.size());
        Object[] s = arr.toArray();
        System.out.println(s.length);
    }


    public static void test04() {
        String str = "{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"}";
        //json字符串转换为json对象
        QueryUser queryUser = JSONObject.parseObject(str, QueryUser.class);
        System.out.println(queryUser.getUserList().get(1).toString());
        JSONObject jsonObject = JSONObject.parseObject(str);
        Object userList = jsonObject.get("userList");
        System.out.println(userList);
    }
    public static void test05() {


    }

    /**
     * 转换MaP
     */
    public static void test06(){
        String str = "{\"userList\":[{\"userName\":\"qa\",\"userPwd\":\"123\"},{\"userName\":\"qb\",\"userPwd\":\"123\"}],\"money\" : \"120\"}";
        Map map = JSONObject.parseObject(str, Map.class);
        System.out.println(map.get("userList"));
        List<Map> map1 = JSONArray.parseObject(map.get("userList").toString(),List.class);
        System.out.println(map1.get(1).get("userName"));

    }

}
