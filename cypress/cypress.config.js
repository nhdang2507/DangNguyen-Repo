const { defineConfig } = require("cypress");

module.exports = defineConfig({
  // default configuration
  defaultCommandTimeout: 3000,

  // reporter options
  reporter: 'cypress-mochawesome-reporter',
    reporterOptions: {
      charts: true,
      reportPageTitle: 'Report Cypress Final',
      reportDir: "cypress/reports",
      embeddedScreenshots: true,
      inlineAssets: true,
      saveAllAttempts: false
    },

  // E2E options
  e2e: {
    setupNodeEvents(on, config) {
      require('cypress-mochawesome-reporter/plugin')(on);
    },
    baseUrl: "https://unsplash.com",
    chromeWebSecurity: false,
    video: false,
    watchForFileChanges: false
  }, 
  
  // Environment options
  env: {
    apiUrl: "https://api.unsplash.com",
    email: "iris.huynh00@gmail.com",
    password: "cypress_group3",
    access_token: "zKAV47fQJ_NtO5zmfiOhXVxZndjCXG6p6oY7azYQhkg"
    // This token still works after exceed 50 requests per hour (just need to wait for an hour then rerun the all API tests)
  }
});