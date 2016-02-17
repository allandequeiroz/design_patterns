Template.Login.onRendered(function() {
    var instance =  Template.instance();
    instance.autorun(function() {
        if(Meteor.user()) {
            Meteor.call('isProfileComplete',function(err,complete){
                if(complete){
                    FlowRouter.redirect('/');
                }else{
                    if(Meteor.user()) {
                        FlowRouter.redirect('/profile');
                    }else{
                        FlowRouter.redirect('/login');
                    }
                }
            });
        }
    });
});

Template.Login.events({
    'click .login-google-button': function(){
        var loginStyle = Meteor.Device.isDesktop()?"popup":"redirect";
        Meteor.loginWithGoogle({
            loginStyle:loginStyle,
            requestPermissions: [
                'https://www.googleapis.com/auth/plus.circles.read',
                'https://www.googleapis.com/auth/plus.stream.read',
                'https://www.googleapis.com/auth/youtube',
                'https://www.googleapis.com/auth/plus.login',
                'https://www.googleapis.com/auth/plus.me',
                'https://www.googleapis.com/auth/userinfo.email',
                'https://www.googleapis.com/auth/userinfo.profile',
            ]
        });
    },
    'click .login-facebook-button': function(){
        var loginStyle = Meteor.Device.isDesktop()?"popup":"redirect";
        Meteor.loginWithFacebook({
            loginStyle:loginStyle,
            requestPermissions: [
                'ads_management',
                'ads_read',
                'publish_pages',
                'read_custom_friendlists',
                'user_about_me',
                'user_birthday',
                'user_events',
                'user_friends',
                'user_hometown',
                'user_likes',
                'user_location',
                'user_photos',
                'user_religion_politics',
                'user_status',
                'user_tagged_places'
            ]
        });
    }
});
