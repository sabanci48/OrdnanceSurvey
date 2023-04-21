package Testing.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
public abstract class TestBase {

    @BeforeAll
    public static void init(){
        baseURI= "https://api.os.uk/";
    }
    @AfterAll
    public static  void destroy(){
       reset();
    }

}
