package ch.zli.m223;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.gradle.internal.impldep.javax.annotation.meta.When;

@QuarkusTest
public class BuchungResourceTest {
    String adminToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6InJ5YW4uY2FycGlvQGdtYWlsLmNvbSIsImdyb3VwcyI6WyJhZG1pbiJdLCJpYXQiOjE2NjkyMDk3NzgsImV4cCI6MzgxNjY5MzQyNSwianRpIjoiYjhkMjQzZWItY2M4Yy00YTc3LWI5NDAtNGRkMGM1YThlZDdlIn0.iGaUStNd-y1gZAgDZu3I7L6AZmP_iiy-XZnwCEbmOVhGhbxDU5f_HTYAbxrgxla9rz0LxVOeZw0f1ueqwJo8jPJEpJTPmRZw_38kpI7wmxeeIUk_B5qtitqSFljOZ8P5PFvkR_YZnVHJwy6kZHmOMdKJRzNToplMzJ9BuX38yr0mVtq9CjD13EDDCqcUfvlZ8QHbnxM2I-f6shK8n6hYnKfw_xS41OQD4oAgZDg831G_Pq6qj_2jtxX2xzFpxYMPr15hRu7YeQoK70Z7trNOrn9FibeTESFk8bDRMVoPT2DGDsd3px0FFxd1UZdFKMOkLmqv8yVoUXkz5mhiYHhxOw";
    String mitgliedToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tL2lzc3VlciIsInVwbiI6ImRhdmlkLmtyZXNpY0BnbWFpbC5jb20iLCJncm91cHMiOlsibWl0Z2xpZWQiXSwiaWF0IjoxNjY5MjA5ODI3LCJleHAiOjM4MTY2OTM0NzQsImp0aSI6Ijk1YTIwY2ZkLTdlZDUtNGM2ZS1hM2Q2LTBiZWEwY2UxZjA1MyJ9.mSG8PP55YYYZxBXzZMbvKBP2HEzW3-h7DE2zsoYxHDTdKG4AEuOrOcnEJU1LM6j1LJC1QTTmhHMDfjnaeCyyPkgwADRDRhkrnfdEgOMqcoKA7S5lsfkHP-4EMmQXs3MVer1Luy9vcpJFXdMLxvOUlY5v8aHG5129yHZRp84pQAR-eXg-ysPgvZcDWAtNMdzg8LzZIG9TzAba5uzqDobkzypoGmlj54CWXA7mKahup9jlIUDN-p_ah6Huyq3ra9d7WGz8bqec5ZedE-sYmLNwRoztZBivmdeuioPs8oMP_wFXBmsMmUMsFjQjPAtA2zxmdx0GoIRF-dl_Wwpn1lLVkw";

    @Test
    public void NotWorkingtestGetId() {
        given()
            .header("Authorization", "Bearer" + mitgliedToken)
            .when()
            .get("/buchung")
            .then()
                .assertThat()
                .statusCode(401);
    }

    @Test
    public void NotWorkingDeleteId() {
        given()
        .header("Authorization", "Bearer" + mitgliedToken)
        .when().delete("/buchung/4")
        .then()
            .assertThat()
            .statusCode(401);
    }

    @Test
    public void NotWorkingDeleteIdAdmin() {
        given()
        .header("Authorization", "Bearer" + adminToken)
        .when().delete("/buchung/4")
        .then()
            .assertThat()
            .statusCode(401);
    }

    @Test
    public void NotWorkingtestGetIdAdmin() {
        given()
            .header("Authorization", "Bearer" + adminToken)
            .when()
            .get("/buchung")
            .then()
                .assertThat()
                .statusCode(401);
    }

    @Test
    public void postIdAdmin() {
        given()
            .header("Authorization", "Bearer" + adminToken)
            .when()
            .put("/buchung/18")
            .then()
                .assertThat()
                .statusCode(401);
    }
    
}
