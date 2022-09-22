package com.nashtech.finalcucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage extends BasePage{
    /** ---------------- Web Elements-------------------- **/
    public static final By SEARCH_BOX_BOOK = By.id("searchBox");
    public static final By LIST_TITLE_RESULTS = By.xpath("//div[@class='rt-tbody']//a");
    public static final By LIST_SEARCH_RESULTS = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']");
    public static final By LIST_LNK_BOOK_NAME_RESULTS = By.xpath("//span[contains(@id, 'see-book')]//a");
    public static final By TOTAL_OF_PAGE = By.className("-totalPages");
    public static final By BTN_NEXT_PAGE = By.xpath("//button[text()='Next']");
    public static By BOOK_NAME (String bookName){
        return By.xpath(String.format("//a[text()='%s']", bookName));
    }

    /** ---------------- Page Methods-------------------- **/

    public void inputKeysSearch(String keys){
        inputText(SEARCH_BOX_BOOK, keys);
    }

    public String getBookName(WebElement book) {
        return getText(book.findElement(LIST_LNK_BOOK_NAME_RESULTS));
    }

    public List<WebElement> getAllSearchResult(){
        return findAllElements(LIST_SEARCH_RESULTS);
    }

    public String getTotalPage(){
        return getText(TOTAL_OF_PAGE);
    }

    public void selectBook(String bookName){
        clickElement(BOOK_NAME(bookName));
    }
}
