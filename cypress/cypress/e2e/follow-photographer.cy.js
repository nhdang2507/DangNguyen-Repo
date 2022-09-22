import apiRequestHelper from "../utils/api-request-helper";
const {photographerDetailPage} = require('../pages/photographer-detail');
const {NavigationPage} = require('../pages/navigation-page');
describe("Follow a photographer", () => {
  beforeEach(function () {
    NavigationPage.navigateToLogin();
    cy.login(Cypress.env("email"), Cypress.env("password"));
  });

  it.only("Follow a photographer successfully", async function () {
    const response = await apiRequestHelper.getPhotos(1, 10);
    photographerDetailPage.navigate(
      response.data[0].sponsorship.sponsor.links.html
    );
    photographerDetailPage.clickFollowButton();
    photographerDetailPage.getButtonUnFollowElement().should("be.visible");
    photographerDetailPage.clickUnFollowButton();
  });
});
