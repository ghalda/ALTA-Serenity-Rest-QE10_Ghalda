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

    //Get List Users
    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get lists user with invalid parameter page")
    public void getListUsersInvalidParamPage(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Get Single User
    @Step("Get single user with valid id")
    public void getListUsersValidId(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user with invalid id")
    public void getListUsersInvalidId(String id){
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
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}
