const { UrlConstants } = require("../constants/url-constant");
const { HomePage } = require("../pages/home-page");
const { ImageDetails } = require("../pages/image-details-page");
const { LikesPage } = require("../pages/likes-page");
const { NavigationPage } = require("../pages/navigation-page");
const {ApiEndpoints} = require('../support/api-endpoints.js');


describe('Like 3 random images', () => {
  beforeEach(function () {
    NavigationPage.navigateToLogin();
    cy.login(Cypress.env("email"), Cypress.env("password"))
  });

  it.only("Like 3 random images successfully", () => {
    HomePage.turnOffNoti();
    var imageId = [];
    var randomImage = HomePage.random();
    randomImage.forEach(random => {
      HomePage.openImage(random);
      cy.url().then((currentUrl) => {
        cy.log("Get id image")
        imageId.push(currentUrl.split("/")[4]);
      });
      ImageDetails.clickLikeImage();
      ImageDetails.clickCloseImage();  
    });
    cy.wrap(imageId).as('imageId');

    cy.visit(UrlConstants.LIKES_URL);
    LikesPage.getTotalLikeImage().should("have.text", "3");    
  });

  afterEach(function () {
    cy.log("Unlike 3 image")
    cy.get('@imageId').then((imageId) => {
      imageId.forEach(id => {
        cy.sendrequest('DELETE', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_PHOTO + id + ApiEndpoints.ENDPOINT_LIKE_PHOTO,{
          "id" : id,
        }).then(response => {
            expect(response.status).equals(200)
        });
      })
    }) 
  })
})