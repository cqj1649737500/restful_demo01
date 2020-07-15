package com.dj.ssm.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String userPwd;

    private Integer isDel;

    private Integer userId;

    private Integer age;

    private Integer userSex;

    private String hobby;

}
