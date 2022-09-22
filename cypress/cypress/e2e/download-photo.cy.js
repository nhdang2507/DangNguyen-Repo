
const {HomePage} = require('../pages/home-page.js')
const {NavigationPage} = require('../pages/navigation-page.js')
const {PhotoDetails} = require('../pages/photo-details.js')

describe('Download a random photo', () => {
    beforeEach(() =>{
        cy.log("Login to the application")
        NavigationPage.navigateToLogin();

        cy.login(Cypress.env("email"), Cypress.env("password"))
    })

    it.only('Download a random photo successfully', () => {
        var orderOfPhoto = 2 //open second photo

        HomePage.clickOnAPhoto(orderOfPhoto)
        PhotoDetails.clickDownloadBtn()
    })
  })	