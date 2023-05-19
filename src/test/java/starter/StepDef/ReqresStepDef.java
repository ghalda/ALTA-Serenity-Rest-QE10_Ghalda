package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Get Users
//    @Given("Got list users with valid parameter page {int}")
//    public void gotListUsersWithValidParameterPage(int page) {
//        reqresAPI.getListUsersValidParamPage(page);
//    }
//
//    @When("Send get lists users")
//    public void sendGetListsUsers() {
//        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
//    }
//
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
//
//    @And("Response body page should be {int}")
//    public void statusCodeShouldBe(int page) {
//        SerenityRest.and().body("page", equalTo(page));
//    }
//
//    @And("Validate get list user json schema")
//    public void validateGetListUserJSONSchema() {
//        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
//        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
//    }

    //Create New User
    @Given("Post create new user with valid json")
    public void postCreateNewUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.postCreateUsers(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int create) {
        SerenityRest.then().statusCode(create);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job){
        SerenityRest.and()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }

    // put update user
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    // delete user
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @And("Validate post list user json schema")
    public void validatePostListUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate put user json schema")
    public void validatePostUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body for update name was {string} and job was {string}")
    public void responseBodyForUpdateNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badReq) {
        SerenityRest.then().statusCode(badReq);
    }
}
