package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqressResponses;
import starter.Utils.Constants;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

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
                .body(ReqressResponses.NAME,equalTo(name))
                .body(ReqressResponses.JOB,equalTo(job));
    }
}
