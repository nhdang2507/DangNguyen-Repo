package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class SearchBookLocator {
    public static final By SEARCH_BOX_BOOK = By.id("searchBox");
    public static final By LIST_TITLE_RESULTS = By.xpath("//div[@class='rt-tbody']//a");
    public static final By LIST_SEARCH_RESULTS = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']");
    public static final By LIST_LNK_BOOK_NAME_RESULTS = By.xpath("//span[contains(@id, 'see-book')]//a");

    public static final By TOTAL_OF_PAGE = By.className("-totalPages");
    public static final By BTN_NEXT_PAGE = By.xpath("//button[text()='Next']");
}
