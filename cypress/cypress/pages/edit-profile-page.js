const TXT_FIRST_NAME = "#user_first_name";
const TXT_LAST_NAME = "#user_last_name";
const TXT_USER_NAME = "#user_username";
const TXT_LOCATION = "#user_location";
const TXT_USER_URL = "#user_url";
const TXA_BIO = "#user_bio";
const TXT_INTERESTS = "#user_interests_tag";
const TXT_INSTAGRAM = "#user_instagram_username";
const TXT_TWITTER = "#twitter_username";
const TXT_DONATION_EMAIL = "#user_paypal";
const BTN_UPDATE_ACCOUNT = "input[value='Update account']";

export const editProfilePage = {
    navigate() {
        cy.visit(LOGIN_URL);
    },
    inputFirstName(firstName) {
        cy.get(TXT_FIRST_NAME).clear();
        cy.get(TXT_FIRST_NAME).type(firstName);
    },
    inputLastName(lastName) {
        cy.get(TXT_LAST_NAME).clear();
        cy.get(TXT_LAST_NAME).type(lastName);
    },
    inputUserName(userName) {
        cy.get(TXT_USER_NAME).clear();
        cy.get(TXT_USER_NAME).type(userName);
    },
    inputLocation(location) {
        cy.get(TXT_LOCATION).clear();
        cy.get(TXT_LOCATION).type(location);
    },
    inputPersonalURL(url) {
        cy.get(TXT_USER_URL).clear();
        cy.get(TXT_USER_URL).type(url);
    },
    inputBio(bio) {
        cy.get(TXA_BIO).clear();
        cy.get(TXA_BIO).type(bio);
    },
    inputInterests(interests) {
        cy.get(TXT_INTERESTS).clear();
        cy.get(TXT_INTERESTS).type(interests);
    },
    inputInstagram(instagram) {
        cy.get(TXT_INSTAGRAM).clear();
        cy.get(TXT_INSTAGRAM).type(instagram);
    },
    inputTwitter(twitter) {
        cy.get(TXT_TWITTER).clear();
        cy.get(TXT_TWITTER).type(twitter);
    },
    inputDonationEmail(email) {
        cy.get(TXT_DONATION_EMAIL).clear();
        cy.get(TXT_DONATION_EMAIL).type(email);
    },
    clickUpdateAccountButton() {
        cy.get(BTN_UPDATE_ACCOUNT).click();
    }
}