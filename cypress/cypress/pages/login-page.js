
var TXT_EMAIL = '#user_email'
var TXT_PASSWORD = '#user_password'
var BTN_LOGIN = '//input[@type="submit"]'

export const LoginPage = {
    inputEmail(email){
        return cy.get(TXT_EMAIL).type(email);
    },

    inputPassword(password){
        return cy.get(TXT_PASSWORD).type(password);
    },

    clickLoginBtn(){
        cy.xpath(BTN_LOGIN).click();
    }
}

