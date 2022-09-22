/**---------------------Web Elements----------------------- */
const ICON_LIKE = "(//div[@data-test='photos-route']//button)[1]";
const ICON_CLOSE = "(//div[contains(@class, 'ReactModal__Content')]//button)[1]";
const ICON_NEXT = "//a[@title='Next']";
 
/**---------------------Page Methods----------------------- */
export const ImageDetails = {
    clickLikeImage(){
        cy.xpath(ICON_LIKE).click();  
    },
    clickCloseImage(){
        cy.xpath(ICON_CLOSE).click();  
    },
    clickNextImage(){
        cy.xpath(ICON_NEXT).click();
    },
    compareTwoArrat(array1, array2){
        let flag = true;
        /*Nếu số phần tử của 2 mảng khác nhau, thì chúng sẽ khác nhau*/
        if (array1.length !== array2.length)  return flag = false;
        
        /*Kiểm tra từng cặp phần tử tương ứng xem có cặp nào khác nhau không*/
        for (let i = 0; i < array1.length; ++i) {
            if (array1[i] != array2[i])  return flag = false; 
        }
        return flag;
    }
}