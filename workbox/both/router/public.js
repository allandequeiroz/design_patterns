FlowRouter.route('/',{
    subscriptions: function(params) {
        this.register('ad', Meteor.subscribe('Ad'));
        this.register('ignore', Meteor.subscribe('IgnoreAd'));
    },
    action: function(params) {
        FlowLayout.render('Layout', { main: "Ads" });
    }
});

FlowRouter.route('/login',{
    action: function(params) {
        FlowLayout.render('Layout', { main: "Login" });
    }
});