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
import static org.hamcrest.Matchers.notNullValue;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Login user with valid json")
    public void loginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/ValidInputReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @When("Send POST login user")
    public void sendPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body token exist for login")
    public void responseBodyTokenExistForLogin() {
        SerenityRest.and().body(ReqressResponses.TOKEN, notNullValue());
    }

    @And("Validate post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+ "Login/SuccessfulLogin.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user without request body password")
    public void loginUserWithoutRequestBodyPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/WithoutPasswordReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @And("Response body error message was {string} for login")
    public void responseBodyErrorMessageWasForLogin(String errMessage) {
        SerenityRest.and().body(ReqressResponses.ERROR, equalTo(errMessage));
    }

    @And("Validate post unsuccessful login user")
    public void validatePostUnsuccessfulLoginUser() {
        File json = new File(Constants.JSON_SCHEMA_DIR+ "Login/UnsuccessfulLogin.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user without request body email")
    public void loginUserWithoutRequestBodyEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/WithoutEmailReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user without request body email and password")
    public void loginUserWithoutRequestBodyEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/WithoutReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login for unregistered user")
    public void loginForUnregisteredUser() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/UnregisteredUser.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with invalid format email")
    public void loginUserWithInvalidFormatEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/InvalidEmailReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with email number type data")
    public void loginUserWithEmailNumberTypeData() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/NumberEmailReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with invalid password")
    public void loginUserWithInvalidPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/InvalidPasswordReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with invalid email and password")
    public void loginUserWithInvalidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/InvalidEmailAndPassword.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with empty password")
    public void loginUserWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/EmptyPasswordReqBody.json");
        reqresAPI.LoginUser(json);
    }

    @Given("Login user with empty email")
    public void loginUserWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY_DIR+ "Login/EmptyEmailReqBody.json");
        reqresAPI.LoginUser(json);
    }
}
