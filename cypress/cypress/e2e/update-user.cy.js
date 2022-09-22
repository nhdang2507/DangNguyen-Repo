const { NavigationPage } = require("../pages/navigation-page");
const { profilePage } = require("../pages/profile-page");
const { editProfilePage } = require("../pages/edit-profile-page");
const { HomePage } = require("../pages/home-page");

describe("Update the user in the Profile page", () => {
  beforeEach(function () {
    cy.fixture("updateUser.json").as("updateUser");
    NavigationPage.navigateToLogin();
    cy.log("Login to the application");
    cy.login(Cypress.env("email"), Cypress.env("password"));
    HomePage.turnOffNoti();
  });
  it.only("Update the user with all filed successfully", function () {
    cy.get("@updateUser").then((updateUser) => {
      NavigationPage.clickAvatarButton();
      NavigationPage.clickViewProfile();
      profilePage.clickEditButton();
      editProfilePage.inputFirstName(this.updateUser.updateAccount.firstName);
      editProfilePage.inputLastName(this.updateUser.updateAccount.lastName);
      editProfilePage.inputUserName(this.updateUser.updateAccount.userName);
      editProfilePage.inputLocation(this.updateUser.updateAccount.location);
      editProfilePage.inputPersonalURL(this.updateUser.updateAccount.personalSite);
      editProfilePage.inputBio(this.updateUser.updateAccount.bio);
      editProfilePage.inputInterests(this.updateUser.updateAccount.interests);
      editProfilePage.inputInstagram(this.updateUser.updateAccount.instagram);
      editProfilePage.inputTwitter(this.updateUser.updateAccount.twitter);
      editProfilePage.inputDonationEmail(this.updateUser.updateAccount.emailDonation);
      editProfilePage.clickUpdateAccountButton();
      NavigationPage.navigateProfilePage(this.updateUser.updateAccount.userName);
      var fullName = this.updateUser.updateAccount.firstName + " " + this.updateUser.updateAccount.lastName;
      profilePage.getTextFullName().should("contain.text", fullName);
    });
  });
  afterEach(function () {
    NavigationPage.clickAvatarButton();
    NavigationPage.clickViewProfile();
    profilePage.clickEditButton();
    editProfilePage.inputFirstName(this.updateUser.originalAccount.firstName);
    editProfilePage.inputLastName(this.updateUser.originalAccount.lastName);
    editProfilePage.inputUserName(this.updateUser.originalAccount.userName);
    editProfilePage.clickUpdateAccountButton();
  });
});
