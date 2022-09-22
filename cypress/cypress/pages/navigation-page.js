var LOGIN_URL = '/login'
const PROFILE_URL = "https://unsplash.com/@";
const BTN_ATATAR = "div[id='popover-avatar-loggedin-menu-desktop'] img";
const LBL_VIEW_PROFILE = "//a[text()='View profile']";
export const NavigationPage = {
    navigateToLogin(){
        cy.visit(LOGIN_URL)
    },
    goToCollectionById(collectionId){
        cy.visit('/collections/' + collectionId);
    },
    navigateProfilePage(url) {
        cy.visit(PROFILE_URL+url);
    },
    clickAvatarButton() {
        cy.get(BTN_ATATAR).click();
    },
    clickViewProfile() {
        cy.xpath(LBL_VIEW_PROFILE).click();
    }
}