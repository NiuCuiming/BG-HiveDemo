package com.anu.hiveUDF;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Hive 自定义函数
 * 1.创建一个继承UDF类的函数
 * 2.并重载evaluate方法
 * 3.打成jar包上传到服务器
 * 4.使用hive>add JAR /home/anu/udf.jar; 把jar包添加到hive的classpath
 * 5.创建临时函数与开发好的javaClass关联
 *   create temporary function toUpperCase as 'com.anu.hiveUDF.UpperCase';
 * 6.在脚本中就可以使用自定义的函数了：select toUpperCase(name) as name  from major;
 */
public class UpperCase extends UDF {

    public Text evaluate(final Text s){

        if(s == null) { return null;}
        return new Text(s.toString().toUpperCase());
    }

}
