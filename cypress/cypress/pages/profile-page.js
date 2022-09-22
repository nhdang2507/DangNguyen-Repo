const BTN_EDIT = "//a[text()='Edit profile']";
const LBL_FULLNAME = "//div[@class='dJnu9 CjK9V Fu4vG lP2EO']";

export const profilePage = {
    clickEditButton() {
        cy.xpath(BTN_EDIT).click();
    },
    getTextFullName() {
        return cy.xpath(LBL_FULLNAME);
    }
}