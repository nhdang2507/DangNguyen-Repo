var BTN_ADD_COLLECTION = '(//button[@title="Add to collection"])'
var BTN_COLLECTION = '(//span[text()="%s"])[1]'

export const AddToCollectionPage = {
    clickAddToCollectionBtn(){
        cy.xpath(BTN_ADD_COLLECTION).click();
    },
    clickCollectBtnByName(collectionName){
        var BTN_COLLECTION_NAME = BTN_COLLECTION.replace("%s", collectionName);
        cy.xpath(BTN_COLLECTION_NAME).click();
    }
}
