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

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Got single user with id {int}")
    public void gotSingleUserWithId(int id) {
        reqresAPI.getListUsersValidId(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body id was {int} and email was {string}")
    public void responseBodyIdWasAndEmailWas(int id, String email) {
        SerenityRest.and()
                .body(ReqressResponses.DATA_ID,equalTo(id))
                .body(ReqressResponses.DATA_EMAIL,equalTo(email));
    }

    @Given("got single user with unregistered id {int}")
    public void gotSingleUserWithUnregisteredId(int id) {
        reqresAPI.getListUsersValidId(id);
    }
}
