package com.hb.myutil;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class CodeGen {
    public static void main(String[] args) {
        //构建代码生成器对象
        AutoGenerator ag=new AutoGenerator();

        //全局配置
        GlobalConfig gc=new GlobalConfig();

        gc.setAuthor("波");//作者
        gc.setFileOverride(false);//是否覆盖相同文件
        //配置生成文件地址
        String property = System.getProperty("user.dir");
        gc.setOutputDir(property+"/src/main/java");
        gc.setOpen(false);//创建成功后是否打开文件夹
        gc.setDateType(DateType.ONLY_DATE);//设置时间类型

        ag.setGlobalConfig(gc);

        //设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);//数据库类型
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("327429");
        dsc.setUrl("jdbc:mysql://localhost:3306/clouddb?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8");
        //设置数据源  读取数据表
        ag.setDataSource(dsc);


        //包的配置
        PackageConfig pc=new PackageConfig();
        //pc.setModuleName("hb");//模块名
        pc.setParent("com.hb");//所有类放在此包名下面
        pc.setEntity("pojo");//实体类名字
        pc.setMapper("mapper");//mapper
        pc.setService("service");//service层的名字
        pc.setController("controller");//controller的名字
        ag.setPackageInfo(pc);


        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //这是生成的表名,可以是new String[] { "tb_student","user","product"},自定义长度String数组
        strategy.setInclude("products");

        //表自动映射成驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段自动映射成驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自动lombok
        strategy.setEntityLombokModel(true);
        //逻辑删除字段名
        strategy.setLogicDeleteFieldName("deleted");
        //自动填充策略
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);//自动填充新增时间
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

        ag.setStrategy(strategy);

        //执行
        ag.execute();
    }
}
