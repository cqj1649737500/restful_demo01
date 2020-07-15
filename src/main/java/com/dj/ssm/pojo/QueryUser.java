package com.dj.ssm.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
public class QueryUser {

   private List<User> userList;

   private Integer money;
}
