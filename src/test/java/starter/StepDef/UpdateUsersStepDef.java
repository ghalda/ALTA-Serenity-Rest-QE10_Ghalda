package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqressResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // put update user
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body for update name was {string} and job was {string}")
    public void responseBodyForUpdateNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqressResponses.NAME,equalTo(name))
                .body(ReqressResponses.JOB,equalTo(job));
    }

    @And("Validate put user json schema")
    public void validatePostUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"Update/UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with valid json and invalid id {string}")
    public void putUpdateUserWithValidJsonAndInvalidId(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid json and empty id")
    public void putUpdateUserWithValidJsonAndEmptyId() {
        File json = new File(Constants.REQ_BODY_DIR+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser("", json);
    }

    @Given("Put update user with empty request body and valid id {int}")
    public void putUpdateUserWithEmptyRequestBodyAndValidId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/WithoutReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body without name")
    public void putUpdateUserWithValidIdAndRequestBodyWithoutName(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/WithoutName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body without job")
    public void putUpdateUserWithValidIdAndRequestBodyWithoutJob(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/WithoutJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with invalid name")
    public void putUpdateUserWithValidIdAndRequestBodyWithInvalidName(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/InvalidNameNumberType.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with invalid job")
    public void putUpdateUserWithValidIdAndRequestBodyWithInvalidJob(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/InvalidJobNumberType.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with empty name")
    public void putUpdateUserWithValidIdAndRequestBodyWithEmptyName(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/EmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with empty job")
    public void putUpdateUserWithValidIdAndRequestBodyWithEmptyJob(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"Update/EmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }
}
