package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	private @FindBy(css = ".rounded-md>.inline-block.leading-4.align-top:nth-last-child(2)") WebElement pagination_last_index;
	private @FindBy(css = "#searchval") WebElement search_bar;
	private @FindBy(css = "[data-testid='itemDescription']") List<WebElement> allCards;
	private @FindBy(css = ".btn.btn-small.btn-primary") WebElement cart_button;
	private @FindBy(css = "[value='Search']") WebElement searchbtn;
	private @FindBy(css = "[data-testid='itemAddCart']") List<WebElement> allAddCarts;
	private @FindBy(css = ".emptyCartButton.btn.btn-mini.btn-ui.pull-right") WebElement empty_button;
	private @FindBy(css = "[type='button'][style='outline: none;']") WebElement empty_button2;

	public SearchPage() {
		super();
	}

	public void goTo_Page() {
		navigateTo_URL("https://www.webstaurantstore.com/");
	}

	public void typeWordTo_SearchBar(String word) {
		sendKeys(search_bar, word);
		waitForWebElementAndClick(searchbtn);

	}

	public List<WebElement> getAllCards() {
		return allCards;
	}

	public List<WebElement> getAllAddCarts() {
		return allAddCarts;
	}

	public void getAllItemsFromAllPages(String keyword) {
		waitFor(pagination_last_index);

		String last_index = pagination_last_index.getText();
		int last_index_num = Integer.parseInt(last_index);
		List<WebElement> items = getAllCards();
		int counter = items.size();
		List<WebElement> getItems = new ArrayList<>();
		for (int i = 1; i < last_index_num; i++) {
			for (WebElement element : items) {
				if (!element.getText().toLowerCase().contains(keyword)) {
					getItems.add(element);
				}
			}
			if ((i + 1) == last_index_num) {
				waitForWebElementAndClick(By.cssSelector("[aria-label='last page, page " + (i + 1) + "']"));
			} else {
				waitForWebElementAndClick(By.cssSelector("[aria-label='page " + (i + 1) + "']"));
			}
			counter += items.size();
		}

		System.out.println("The products that include the word " + keyword + " : " + (counter - getItems.size()));
		System.out.println("The products that not include the word " + keyword + " : " + getItems.size());
	}

	public void addTo_Cart() {
		try {
			waitForWebElementAndClick(getAllAddCarts().get(getAllAddCarts().size() - 1));
			Thread.sleep(3000);
			waitForWebElementAndClick(cart_button);
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public void emptyCart() {
		try{
			waitForWebElementAndClick(empty_button);
			Thread.sleep(2000);
			getDriver().switchTo().alert();
			waitForWebElementAndClick(empty_button2);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
