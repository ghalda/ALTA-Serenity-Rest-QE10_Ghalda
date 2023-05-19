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

public class GetUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Got list users with valid parameter page {int}")
    public void gotListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }

    @When("Send get lists users")
    public void sendGetListsUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @And("Response body page should be {int}")
    public void statusCodeShouldBe(int page) {
        SerenityRest.and().body(ReqressResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Got list user with invalid parameter {string}")
    public void gotListUserWithInvalidParameter(String invalidParams) {
        reqresAPI.getListUsersInvalidParamPage(invalidParams);
    }
}
