var BTN_ADD_COLLECTION = '(//button[@title="Add to collection"])[%s]'
var PHOTO_TO_ADD_ORDER = '(//figure[@itemprop="image"])[%s]'
var PHOTO_ALL = 'figure[itemprop="image"]'


export const CollectionPage = {
    clickAddToCollectionBtnOnPhoto(orderOfPhoto){
        var BTN_PHOTO_WITH_ORDER = BTN_ADD_COLLECTION.replace("%s", orderOfPhoto);
        var PHOTO_WITH_ORDER = PHOTO_TO_ADD_ORDER.replace("%s", orderOfPhoto);
        cy.xpath(PHOTO_WITH_ORDER).realHover('mouse')
        cy.xpath(BTN_PHOTO_WITH_ORDER).click();
    },
    
    getAllPhotosInCollection(){
        return cy.get(PHOTO_ALL)
    }
}
