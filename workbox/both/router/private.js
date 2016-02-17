FlowRouter.route('/profile',{
    action: function(params) {
        FlowLayout.render('Layout', { main: "Perfil" });
    }
});

FlowRouter.route('/ad',{
    action: function(params) {
        Meteor.call('isProfileComplete',function(err,complete){
            if(complete){
                FlowLayout.render('Layout', { main: "Ad" });
            }else{
                FlowLayout.render('Layout', { main: "IncompleteProfile" });
            }
        });

    }
});

FlowRouter.route('/myads',{
    subscriptions: function(params) {
        this.register('myads', Meteor.subscribe('MyAds'));
    },
    action: function(params) {
        if(Meteor.user()){
            FlowLayout.render('Layout', { main: "MyAds" });
        }else{
            FlowLayout.render('Layout', { main: "NotAuthorized" });
        }
    }
});

FlowRouter.route('/myads/:adId',{
    subscriptions: function(params) {
        this.register('oneAd', Meteor.subscribe('OneAd',params.adId));
        this.register('interested', Meteor.subscribe('Interested',params.adId));
    },
    action: function(params) {
        if(Meteor.user()){
            FlowLayout.render('Layout', { main: "InterestedList" });
        }else{
            FlowLayout.render('Layout', { main: "NotAuthorized" });
        }
    }
});

FlowRouter.route('/interesting',{
    subscriptions: function(params) {
        this.register('interesting', Meteor.subscribe('Interesting'));
    },
    action: function(params) {
        if(Meteor.user()){
            FlowLayout.render('Layout', { main: "Interesting" });
        }else{
            FlowLayout.render('Layout', { main: "NotAuthorized" });
        }
    }
});
