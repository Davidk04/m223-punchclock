package ch.zli.m223;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.gradle.internal.impldep.javax.annotation.meta.When;

@QuarkusTest
public class BenutzerResourceTest {
    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InJ5YW4uY2FycGlvQGdtYWlsLmNvbSIsImdyb3VwcyI6WyJhZG1pbiJdLCJpYXQiOjE2NjkyMTM4MDIsImV4cCI6MzgxNjY5NzQ0OSwianRpIjoiYTIwMTU0YWUtY2U5Ni00YjZhLWIyYzctMWI2OTBkYmY2MGFhIn0.BwEFRa4Khtsf1utxcV2fDsW9qKOKcJ1159brz4Dx7cUNi_QxBjsAUmFaqBFJhQYEpkzf4rtXLjOjsIL5N520j4bOuCmYhbRSFjFjPKn6jAl42lO_B8RYOAWsyPWN2WWXHzx6X28bkQ8M8M79kQ9R3tpNszQ5MJFjxx4XX-b6yXTeilP42AypJs0DQplq5jZmEODCYgcashKb9WgmNP51gkEZ9XjxuZ3g4UXWSNwil-xYu8ttB0dUcdkxwY8PkqW0gwXxC69AX-_-jxz0CtilV1hnVZjpCIrlWewd6774JGlLk0cuNivLxD84e727FejvuK_TfFVXntAimnoxpnoIWw";
    String mitgliedToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6ImRhdmlkLmtyZXNpY0BnbWFpbC5jb20iLCJncm91cHMiOlsibWl0Z2xpZWQiXSwiaWF0IjoxNjY5MjEzNzc0LCJleHAiOjM4MTY2OTc0MjEsImp0aSI6IjgzYTJmZGNlLWMzYzEtNDNmNy04OWFmLWFkNmU1NTlkYmQ4YSJ9.5AJngXOskA2hWtoMHPPS-Zis96fgW_zbDzwnGbH1_gbF06Hf7crzLNtx4_11qLFrGxjOdh0UpC1T_duTGkp47E_XfUqZ7dLxu38RtS8QBzXF_5vGGTAc4Sgx1-vavqV5eC2_zc1TqzSXn40wgW53P_QzJIS4AFWZs6kjyNM78tRnOE1Cof8shyvnRbRxpQ44uPaCWFEkZCEfkaAjBsRTGQKxYJmjGJ-tK2UubM_tp9_Zy2Flnoim6CGJ8897Hm_ElnnEn9C87uoJS6KNa1Pnwx8VYnoEcMvcfDSi-xr5vg7bTeuDDltfLhFE0SUqp1uX2wJ8iAAeQJ2pB9GLOYBIog";
 
    @Test
    public void getId() {
        given()
            .header("Authorization", "Bearer" + mitgliedToken)
            .when()
            .get("/user")
            .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void putId() {
        given()
            .header("Authorization", "Bearer" + adminToken)
            .when()
            .put("/user/2")
            .then()
                .assertThat()
                .statusCode(404);
    }
}
