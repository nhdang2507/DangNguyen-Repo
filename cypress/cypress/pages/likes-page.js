/**---------------------Web Elements----------------------- */
const TOTAL_LIKES_IMAGE = "//span[text()='Likes']//following-sibling::span/span";
const FIRST_IMAGE = "(//figure[@itemprop='image'])[1]";

/**---------------------Page Methods----------------------- */
export const LikesPage = {
    getTotalLikeImage(){
        return cy.xpath(TOTAL_LIKES_IMAGE);  
    },
    openFirstImage(){
        cy.xpath(FIRST_IMAGE).click();
    }
}