Accounts.onCreateUser(function(options,user){
    if(options.profile){
        user.profile = options.profile;
    }else{
        user.profile = {};
    }
    user.profile.rank = "White belt";
    if(options.email){
        Meteor.setTimeout(
            function() {
                Accounts.sendVerificationEmail(user._id);
            },
            2*1000
        );
    }
    if(user.services.facebook){
        user.profile.first_name = user.services.facebook.first_name;
        user.profile.last_name = user.services.facebook.last_name;
        user.profile.gender = user.services.facebook.gender;
    }
    return user;
});

Meteor.startup(function(){
    smtp = {
        username: 'allan@reclameaqui.com.br',
        password: 'eIlsk8b82',
        server: 'smtp.gmail.com',
        port: 587
    };
    process.env.MAIL_URL = 'smtp://' +
        encodeURIComponent(smtp.username) + ':' +
        encodeURIComponent(smtp.password) + '@' +
        encodeURIComponent(smtp.server) + ':' +
        smtp.port;
    process.env.ROOT_URL = 'http://';
});

if(ServiceConfiguration.configurations.find({service:'facebook'}).count() === 0){
    ServiceConfiguration.configurations.insert({
        service: "facebook",
        appId: "oAuth-credentials-from-facebook",
        secret: "oAuth-credentials-from-facebook",
        loginStyle: "popup"
    });
}
