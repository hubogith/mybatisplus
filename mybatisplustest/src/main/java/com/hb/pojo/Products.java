package com.hb.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Products implements Serializable {
    @TableId(value = "pid",type = IdType.AUTO)
    private Long pid;
    private String pname;
    private Double price;
    private String pdesc;
    //INSERT表示新增时填充
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//新增时间
    @TableField(fill = FieldFill.INSERT_UPDATE)//新增 修改都会填充
    private Date updateTime;//修改时间
}
