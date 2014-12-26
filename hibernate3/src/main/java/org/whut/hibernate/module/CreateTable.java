package org.whut.hibernate.module;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created with IntelliJ IDEA.
 * User: zhangbojun
 * Date: 14-12-23
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
public class CreateTable {

    public static void main(String[] args){
        //自动建立与module对应的表
        SchemaExport export = new SchemaExport(new Configuration().configure());
        export.create(true,false);  //如果第二个参数是false则会生成创建表的语句而不在数据库中创建    若为true则会自动在数据库中进行创建
    }
}
