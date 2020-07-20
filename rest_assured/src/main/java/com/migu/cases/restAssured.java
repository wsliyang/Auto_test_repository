package com.migu.cases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class restAssured {
    @Test
    public void test(){
        given()
                .header("Content-Type","application/json")

                .body("{\"bookId\":\"831369640\"}").
        when()
                .log()
                .all()
                .post("http://10.129.41.234:8080/composite.caps.ContentService/getBookItem").
        then()
                .log()
                .all()
                .statusCode(200);

    }
}