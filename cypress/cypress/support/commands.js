// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

const {LoginPage} = require('../pages/login-page.js');

Cypress.Commands.add('login', (email, password) => {
    LoginPage.inputEmail(email);
    LoginPage.inputPassword(password);
    LoginPage.clickLoginBtn();
})

Cypress.Commands.add('sendrequest', (method, url, params) => {
    cy.request({
        method: method,
        url: url,
        qs: params,
        headers: {
            'content-type': 'application/json',
            'authorization': 'Bearer ' + Cypress.env("access_token")
        }
    }).then(response => {
        return response;
    })
})