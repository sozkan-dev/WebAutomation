package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.HomePage;

public class AmazonSearchProduct_Steps extends BasePage{
	private HomePage home_page;
	
	public AmazonSearchProduct_Steps(HomePage home_page) {
		this.home_page = home_page;
	}
	
	
	@Given("I go to Amazon.com Home Page")
	public void ı_go_to_amazon_com_home_page() {
	    home_page.goTo_HomePage();
	}

	@When("I type {} on search bar")
	public void ı_type_product1_on_search_bar(String product) {
	   home_page.typeProductTo_SearchBar(product);
	}

	@And("I click on search button")
	public void ı_click_on_search_button() {
	    home_page.clickOn_SearchButton();
	}
	@When("I press enter from keyboard")
	public void ı_press_enter_from_keyboard() {
	    home_page.clickWith_EnterKeyboard();
	}

	@Then("I validate the product whether results are related to {}")
	public void ı_validate_the_first_product_whether_related_to_product(String word) {
	   Assert.assertEquals(true, home_page.validateProducts(word));
	}
}
