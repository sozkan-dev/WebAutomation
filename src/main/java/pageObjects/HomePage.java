package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	private @FindBy(css = "#twotabsearchtextbox") WebElement homepage_searchbar;
	private @FindBy(css = ".nav-search-submit.nav-sprite") WebElement searchbar_searchbutton;
	private @FindBy(css = ".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-3") List<WebElement> products;

	public HomePage() {
		super();
	}

	public void goTo_HomePage() {
		navigateTo_URL(getURL());
	}

	public void typeProductTo_SearchBar(String product) {
		sendKeys(homepage_searchbar, product);
	}

	public void clickOn_SearchButton() {
		waitForWebElementAndClick(searchbar_searchbutton);
	}

	public void clickWith_EnterKeyboard() {
		pressEnter(homepage_searchbar);
	}

	public Boolean validateProducts(String word) {
		Boolean flag = false;
		String[] wordList = word.split(" ");
		for (WebElement elem : products) {
			String text = elem.getText().toLowerCase();
			if (text.contains(wordList[0])) {
				flag = true;
			} else
				flag = false;
		}
		return flag;
	}

}
