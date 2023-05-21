package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+ "/api/users?page={page}";
    public static String GET_SINGLE_USER = Constants.BASE_URL+ "/api/users/{id}";
    public static String POST_CREATE_USERS = Constants.BASE_URL+ "/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String POST_REGISTER = Constants.BASE_URL+"/api/register";
    public static String POST_LOGIN = Constants.BASE_URL+"/api/login";

    //Get List Users
    @Step("Get lists user")
    public void getListUsers(Object page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Get Single User
    @Step("Get single user")
    public void getSingleUser(Object id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post create new user")
    public void postCreateUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(Object id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(Object id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    //Register Users
    @Step("Post Register User")
    public void registerUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login User")
    public void LoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
