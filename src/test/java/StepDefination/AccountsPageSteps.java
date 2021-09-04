package StepDefination;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage;

	@Given("User has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountPage = loginPage.doLogin(userName, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String pageTitle = accountPage.getAccountsPageTitle();
		System.out.println("Page title is " + pageTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable setcionsTable) {
		List<String> expectedAccountSectionList = setcionsTable.asList();
		System.out.println("Expected account section account list " + expectedAccountSectionList);
		List<String> actualAccountSectionList = accountPage.getAccountSectionsList();
		System.out.println("Actual account section account list " + actualAccountSectionList);
		assertTrue(actualAccountSectionList.containsAll(expectedAccountSectionList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);

	}
}
