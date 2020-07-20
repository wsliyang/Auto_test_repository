package com.migu.cases;

import com.migu.util.caseTools;
import com.mongodb.util.JSON;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getBookItem {
    @Test
    public void EbookForTest(){
        String methodName = "getBookItem";
        Map<String, Object>  Request = new HashMap<>();
        Request.put("bookId","831369640");
        String url = caseTools.getMethodUrl(methodName);

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
