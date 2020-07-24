package com.migu.cases;

import com.migu.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j //日志
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class demo {

    //首先获取一个执行sql语句的对象

    @Autowired //启动即加载
    private SqlSessionTemplate template;
    //查询
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");//传进去的是在mySql里面的select id
    }
    //增加
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){ //需要创建一个user的属性类
        int result = template.insert("addUser",user);
        return result;
    }

//修改
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){

        return  template.update("updateUser",user);

    }
    //删除
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int delUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }

}