/**---------------------Web Elements----------------------- */
const BTN_NOTI = "//button[text()='Got it']";
const BTN_IMAGE = "(//figure[@itemprop='image'])[%s]"
/**---------------------Page Methods----------------------- */
export const HomePage = {
    random(){
        var arr = [];
        while(arr.length < 3){
            var r = Math.floor(Math.random() * 20) + 4;
            if(arr.indexOf(r) === -1) arr.push(r);
        }
        return arr;
    },
    getRandomImmge(randomNumber){
        return BTN_IMAGE.replace("%s", randomNumber);
    },
    openImage(randomNumber){
        cy.xpath(this.getRandomImmge(randomNumber)).click();
    },
    turnOffNoti(){
        cy.xpath(BTN_NOTI).click();
    }
}