const {ApiEndpoints} = require('../support/api-endpoints.js');
const {NavigationPage} = require('../pages/navigation-page.js');
const {CollectionPage} = require('../pages/collection-page.js');
const {AddToCollectionPage} = require('../pages/add-to-collection-page.js');

describe('remove photo from collection', () => {
    beforeEach('There is a private collection with two photos',  () => {
        cy.fixture('create-collection.json').as('collection')        

        cy.log("Create a private collection")
        cy.get('@collection').then((collection) => {
            cy.sendrequest('POST', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_CREATE_COLLECTION, {
                "title" : collection.collection_name,
                "private": collection.private
            }).then(response => {
                cy.wrap(response.body.id).as('collectionId');
                cy.log(response.body.id);
        })
        })

        cy.log("Get 2 random photos")
        cy.get('@collection').then((collection) => {

            cy.sendrequest('GET', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_RANDOM_PHOTO, {
                'count': collection.number_of_photo_to_add
            }).then(response => {
                expect(response.body.length).equals(collection.number_of_photo_to_add);
                const photo_id_list = [];

                for (let i = 0; i < response.body.length; i++){
                    photo_id_list.push(response.body[i].id);
                }
                cy.wrap(photo_id_list).as('photosId');
            })
        })

        cy.log("Add each photo into collection")
        cy.get('@collectionId').then((collectionId) => {
            cy.get('@photosId').then((photosId) => {
                for (let i = 0; i < photosId.length; i++){
                    cy.sendrequest('POST', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_MODIFIED_PHOTO_TO_COLLECTION + collectionId + ApiEndpoints.ENDPOINT_ADD_PHOTO_TO_COLLECTION, {
                        'collection_id': collectionId,
                        'photo_id': photosId[i],
                    })
                }
            })
        })
        
        cy.log("Check if 2 photos are already in the collection")
        cy.get('@collection').then((collection) => {
            cy.get('@collectionId').then((collectionId) => {
                cy.sendrequest('GET', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_COLLECTION_BY_ID + collectionId, {
                        'id': collectionId
                    }).then(response => {
                    expect(response.body.total_photos).equals(collection.number_of_photo_to_add);
                })                
            })
        })

    })

    it.only('Remove photo from collection with UI', function () {
        cy.log("Login to the application")
        NavigationPage.navigateToLogin();

        cy.login(Cypress.env("email"), Cypress.env("password"))
        var orderOfPhoto = 2 //remove second photo
        var numberOfPhotoLeft = 1

        cy.log("Remove photo from collection")
        NavigationPage.goToCollectionById(this.collectionId)
        CollectionPage.clickAddToCollectionBtnOnPhoto(orderOfPhoto)
        AddToCollectionPage.clickCollectBtnByName(this.collection.collection_name)
        
        cy.log("Check if there is 1 photo left in the collection")
        NavigationPage.goToCollectionById(this.collectionId)
        cy.reload()
        CollectionPage.getAllPhotosInCollection().should("have.length", numberOfPhotoLeft)
    })


    it.only('Remove photo from collection with API', function () {
        var orderOfPhoto = 0 //remove first photo
        var numberOfPhotoLeft = 1

        cy.log("Remove photo from collection")
        cy.sendrequest('DELETE', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_MODIFIED_PHOTO_TO_COLLECTION + this.collectionId + ApiEndpoints.ENDPOINT_REMOVE_PHOTO_FROM_COLLECTION, {
            'collection_id': this.collectionId,
            'photo_id': this.photosId[orderOfPhoto]
        })

        cy.log("Check if there is 1 photo left in the collection")
        cy.sendrequest('GET', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_GET_COLLECTION_BY_ID + this.collectionId, {
            'id': this.collectionId
        }).then(response => {
        expect(response.body.total_photos).equals(numberOfPhotoLeft);
        })
    })

    afterEach("Delete collection", function () {
        cy.sendrequest('DELETE', Cypress.env("apiUrl") + ApiEndpoints.ENDPOINT_DELETE_COLLECTION + this.collectionId, {
                'id': this.collectionId
            }).then(response => {
            expect(response.status).equals(204)
        })
    })
})