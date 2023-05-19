package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqressResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUsersStepDef {

    @Steps
    ReqresAPI reqresAPI;

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
                .body(ReqressResponses.NAME,equalTo(name))
                .body(ReqressResponses.JOB,equalTo(job));
    }
}
