package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.SearchPage;

public class WebstaurantstoreSearchItems_Steps extends BasePage {
private SearchPage search_page;
	
	public WebstaurantstoreSearchItems_Steps(SearchPage search_page) {
		this.search_page = search_page;
	}
	
	
	
	@Given("Go to home page")
	public void go_to_home_page() {
		search_page.goTo_Page();
		
	}

	@When("search for {}")
	public void search_for(String string) {
	    search_page.typeWordTo_SearchBar(string);
	}

	@When("check the result ensuring every product has the word {} in its title")
	public void check_the_result_ensuring_every_product_has_the_word_table_in_its_title(String keyword) {
	    search_page.getAllItemsFromAllPages(keyword);
	}

	@When("add the last of found items to cart")
	public void add_the_last_of_found_items_to_cart() {
	    search_page.addTo_Cart();
	}

	@Then("Empty cart")
	public void empty_cart() {
	   search_page.emptyCart();
	}

	
	
}
