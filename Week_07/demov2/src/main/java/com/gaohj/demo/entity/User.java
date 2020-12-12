package com.gaohj.demo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("user")
public class User {

    private Long id;
    private String account;
    private String mobile;
    private String name;
    private String birth;
    private String type;
    private String createBy;
    private String updateBy;
    private Date createDate;
    private Date updateDate;
    private String remarks;
}
