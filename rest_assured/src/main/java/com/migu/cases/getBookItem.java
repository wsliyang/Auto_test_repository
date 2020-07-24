package com.migu.cases;

import com.migu.util.caseTools;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getBookItem {
    @Test
    public void EbookForTest() throws ClassNotFoundException, SQLException {
        String methodName = "getBookItem";
        Map<String, Object>  Request = new HashMap<>();
        Request.put("bookId","831369640");
        String url = caseTools.getMethodUrl(methodName);

        //传入JDBC驱动,mysql:com.mysql.jdbc.Driver
        Class.forName("oracle.jdbc.OracleDriver");
        //数据库连接信息mysql:jdbc:mysql://localhost:3306/test
        String url1 = "jdbc:oracle:thin:@//10.211.95.53:1521/stdb";//其中test是数据库名
        //数据库用户名
        String user = "cntdb";
        //数据库密码
        String password = "cnt_Db123";
        //连接数据库
        Connection conn = DriverManager.getConnection(url1, user, password);
        //sql语句（这里面是select 那么下面就用executeQuery，如果是insert或者update，那么下面用executeUpdate，并且用int接收）
        String sql = "select * from CON_T_AUDIOBOOKCHAPTER t where chapterid='394345571'";
        //创建执行语句的事务
        Statement st = conn.createStatement();
        //获取执行结果
        int len = st.executeUpdate(sql);
        //获取select执行结果返回
        ResultSet rs = st.executeQuery(sql);
        //next()表示是否还有下一行
        while(rs.next()){
            Object did = rs.getObject(1);//获取第1列的值
            Object dname = rs.getObject(2);//获取第2列的值
            Object desc = rs.getObject(3);//获取第3列的值
            System.out.println(did +"\t" + dname + "\t"+ desc);
        }
        System.out.println(len>0?"成功":"失败");
        st.close();
        conn.close();
        rs.close();


        given().
                contentType(ContentType.JSON).
                body(Request.toString()).
        when()
                .post(url)
                .prettyPeek().
        then()
                .log()
                .all()
                .statusCode(200)
                .body("bookItem.bookId",equalTo("831369640"));

    }

}
