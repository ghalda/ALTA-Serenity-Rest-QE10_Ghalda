package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.Reqres.ReqresAPI;
import net.thucydides.core.annotations.Steps;

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

    @Given("Delete user with exceeded parameter id {int}")
    public void deleteUserWithExceededParameterId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with invalid parameter id {}")
    public void deleteUserWithInvalidParameterId(String id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with empty parameter id")
    public void deleteUserWithEmptyParameterId() {
        reqresAPI.deleteUser("");
    }
}
