//package com.yikes.utils;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
//import com.baomidou.mybatisplus.generator.fill.Column;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * <pre>
// *
// * </pre>
// *
// * @author guanrong.yin
// * @date 2023/9/9 2:06
// */
//public class GeneratorUtil {
//
//    public static void generatorCode(String projectPath, String url, String name, String password, List<String> tables, String parent, String addTablePrefix) {
//
//        //1、配置数据源
//        FastAutoGenerator.create("jdbc:mysql://" + url + "?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai",
//                name,
//                password)
//
//                //2、全局配置
//                .globalConfig(builder -> {
//                    builder.author("guanrong.yin")                                 // 设置作者名
//                            .fileOverride()                                 // 开启覆盖已生成文件，默认值false
//                            .enableSwagger()                                // 开启 swagger 模式，默认值false
//                            .dateType(DateType.ONLY_DATE)                   //定义生成的实体类中日期类型
//                            // 指定输出目录，注意可根据包修改，20211206!!!!
//                            .outputDir(projectPath + "/src/main/java")
//                            .disableOpenDir();
//                })
//
//                //3、包配置
//                .packageConfig(builder -> {
//                    builder.parent(parent)                     // 设置父包名,注意一定要根据包修改
////                    .moduleName("core")                   // 父包模块名，默认值:无，注意根据包修改
//                            .entity("entities")                     // Entity包名
//                            .service("service")                     // Service包名
//                            .serviceImpl("service.impl")            // ServiceImpl包名
//                            .controller("controller")               // Controller包名
//                            .mapper("mapper")                       // Mapper包名
//                            .xml("mapper")                          // Mapper XML包名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper"));  // 路径配置信息，设置mapperXml生成路径
//                })
//
//                //4、策略配置
//                .strategyConfig(builder -> {
//                    builder.addInclude(tables) // 设置需要生成的数据表名
//                            .addTablePrefix(addTablePrefix) // 设置过滤表前缀
//
//                            //4.1、实体类策略配置
//                            .entityBuilder()
//                            .enableLombok() //开启 Lombok
////                            .disableSerialVersionUID()  //不实现 Serializable 接口，不生产 SerialVersionUID
////                            .logicDeleteColumnName("deleted")   //逻辑删除字段名
//                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
//                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
//                            .addTableFills(
//                                    new Column("created_time", FieldFill.INSERT),
//                                    new Column("updated_time", FieldFill.INSERT_UPDATE)
//                            )                   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
//                            .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解
//
//                            //4.2、service 策略配置
//                            .serviceBuilder()
//                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名
//                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名
//
//                            //4.3、Mapper策略配置
//                            .mapperBuilder()
//                            .superClass(BaseMapper.class)   //设置父类
//                            .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
//                            .enableMapperAnnotation()       //开启 @Mapper 注解
//                            .formatXmlFileName("%sMapper") //格式化 Xml 文件名称
//
//                            //4.4、Controller策略配置
//                            .controllerBuilder()
//                            .formatFileName("%sController") //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
//                            .enableRestStyle(); //开启生成 @RestController 控制器
//                })
//
//                //5、模板引擎配置
//                .templateEngine(new FreemarkerTemplateEngine())
//
//                //6、执行
//                .execute();
//
//    }
//
//    public static void main(String[] args) {
//
//        // 获取项目路径
//        String projectPath = "D:/JetBrainsit-work/Idea-Java/yikes/yikes-srb/yikes-service";
//
//        // 数据库地址、名称、密码
//        String url = "127.0.0.1:3306/srb_core";
//        String name = "root";
//        String password = "qwe123";
//
//        // 快速生成数据库的表名称
//        List<String> tables = new ArrayList<>();
//        tables.add("borrow_info");
//        tables.add("borrower");
//        tables.add("borrower_attach");
//        tables.add("dict");
//        tables.add("integral_grade");
//        tables.add("lend");
//        tables.add("lend_item");
//        tables.add("lend_item_return");
//        tables.add("lend_return");
//        tables.add("srb_permit_file");
//        tables.add("trans_flow");
//        tables.add("user_account");
//        tables.add("user_bind");
//        tables.add("user_info");
//        tables.add("user_integral");
//        tables.add("user_login_record");
//        
//        // 父包名
//        String parent = "com.yikes";
//        // 设置过滤表前缀
//        String addTablePrefix = "i_";
//
//
//        generatorCode(projectPath, url, name, password, tables, parent, addTablePrefix);
//    }
//}
