Meteor.startup(function () {

    if (Meteor.isClient) {
        sAlert.config({
            effect: 'bouncyflip',
            position: 'bottom',
            timeout: 4000,
            html: false
        });
    }

});