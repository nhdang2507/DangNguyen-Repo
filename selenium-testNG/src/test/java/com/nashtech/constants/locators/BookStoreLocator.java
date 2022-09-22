package com.nashtech.constants.locators;

import org.openqa.selenium.By;

public class BookStoreLocator {
    /** Book Store Page **/
    public static By LINK_BOOK (String text){
        return By.xpath(String.format("//a[text()='%s']", text));
    }
}
