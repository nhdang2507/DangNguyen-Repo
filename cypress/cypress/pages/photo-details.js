var BTN_DOWNLOAD_PHOTO = '//span[text()="Download"]'
var LNK_DOWNLOAD_PHOTO = '//span[text()="Download"]//parent::a'

export const PhotoDetails = {
    clickDownloadBtn(){
        cy.xpath(BTN_DOWNLOAD_PHOTO).click();
    },
    
    getLinkToDownloadPhoto(){
        cy.xpath(LNK_DOWNLOAD_PHOTO)
        .invoke('attr', 'href')
        .then(href => {
           cy.wrap(href).as('linkDownloadPhoto')
        })
    }
}
