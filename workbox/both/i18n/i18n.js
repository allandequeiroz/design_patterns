if (Meteor.isClient) {
    Meteor.startup(function () {
        Session.set("showLoadingIndicator", true);
        var language = 'pt-BR';
        TAPi18n.setLanguage(language)
            .done(function () {
                Session.set("showLoadingIndicator", false);
            })
            .fail(function (error_message) {
                console.log(error_message);
            });
    });
}