import Model.MainApi;
import com.jayway.restassured.RestAssured;
import groovy.lang.DelegatesTo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson9 {

   /* public static void main (String[]args){
        RestAssured.get("https://swapi.co/api/").
                body().
                prettyPrint();

    }*/
@Test
    public void verifyMainApi(){
    MainApi expectedApi = new MainApi.MainApiBuilder().
            people("https://swapi.co/api/people/").
            planets("https://swapi.co/api/planets/").
            films("https://swapi.co/api/films/").
            species("https://swapi.co/api/species/").
            vehicles("https://swapi.co/api/vehicles/").
            starships("https://swapi.co/api/starships/").
            createMainApi();

    MainApi mainApi = RestAssured.
            get("https://swapi.co/api/")
            .as(MainApi.class);

        Assert.assertEquals(expectedApi,mainApi);
}

}
   /*     String ID = "246678";
MainApi mainApi = RestAssured.given().param(ID).
            get("https://swapi.co/api/")
            .as(MainApi.class);*/
