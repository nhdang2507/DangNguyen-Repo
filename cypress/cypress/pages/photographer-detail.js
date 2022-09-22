const BTN_FOLLOW = "//button[@title='Follow']";
const BTN_UNFOLLOW = "//button[@title='Following']";
/**---------------------Page Methods----------------------- */
export const photographerDetailPage = {
  navigate(photographer_url) {
    cy.visit(photographer_url);
  },
  clickFollowButton() {
    cy.xpath(BTN_FOLLOW).click();
  },
  clickUnFollowButton() {
    cy.xpath(BTN_UNFOLLOW).click();
  },
  getButtonUnFollowElement() {
    return cy.xpath(BTN_UNFOLLOW);
  }
};
