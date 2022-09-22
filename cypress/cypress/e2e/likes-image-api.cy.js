
const {ApiEndpoints} = require('../support/api-endpoints.js');

describe('Like 3 images with API', () => {
  beforeEach(function () {
    cy.log("Get 3 random photos")
    cy.sendrequest('GET', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_RANDOM_PHOTO, {
        'count': 3
    }).then(response => {
        expect(response.body.length).equals(3);
        const photo_id_list = [];

        for (let i = 0; i < response.body.length; i++){
            photo_id_list.push(response.body[i].id);
        }
        cy.wrap(photo_id_list).as('photosId');
    })
  });

  it.only("Like 3 random images successfully", () => {
    cy.log("Like 3 images")
    cy.get('@photosId').then((photosId) => {
        photosId.forEach(id => {
          cy.sendrequest('POST', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_PHOTO + id + ApiEndpoints.ENDPOINT_LIKE_PHOTO,{
            "id" : id,
          }).then(response => {
              expect(response.status).equals(201)
          });
        })
      })   
  });


  afterEach(function () {
    cy.log("Unlike 3 random images")
    cy.get('@photosId').then((photosId) => {
        photosId.forEach(id => {
          cy.sendrequest('DELETE', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_PHOTO + id + ApiEndpoints.ENDPOINT_LIKE_PHOTO,{
            "id" : id,
          }).then(response => {
              expect(response.status).equals(200)
          });
        })
      }) 
  })
})