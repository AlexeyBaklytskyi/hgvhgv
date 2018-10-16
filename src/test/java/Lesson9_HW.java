import Model.MainApi;
import Model.WaetherApi;
import com.jayway.restassured.RestAssured;

public class Lesson9_HW {
    public static void main(String[] args) {
        RestAssured.given().
        param("q", "London,uk").
        param("units", "metric").
        param("appid", "3e36678885c7310bde72e93fe2e43625").
        get("http://api.openweathermap.org/data/2.5/weather").as(WaetherApi.class);



    }
}
