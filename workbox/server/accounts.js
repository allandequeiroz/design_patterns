Accounts.onCreateUser(function(options, user){
    if(options.profile){
        if(!user.profile) user.profile = {};
        if(!user.profile.services) user.profile.services = [];
        if(!user.profile.details) user.profile.details = {};
        user.profile.details.active = true;
        if(user.services.google){
            if(!user.profile.details.name){
                user.profile.details.name = user.services.google.name;
            }
            if(!user.profile.details.email){
                user.profile.details.email = user.services.google.email;
            }
            user.profile.services.push("google");
        }
        if(user.services.facebook){
            if(!user.profile.details.name){
                user.profile.details.name = user.services.facebook.name;
            }
            if(!user.profile.details.email){
                user.profile.details.email = user.services.facebook.email;
            }
            user.profile.services.push("facebook");
        }
        if(user.services.twitter){
            if(!user.profile.details.name){
                user.profile.details.name = user.services.twitter.screenName;
            }
            user.profile.services.push("twitter");
        }
        if(user.services.password){
            user.profile.details.name = options.profile.name;
            user.profile.details.email = options.email;
            user.profile.services.push("password");
        }
    }
    return user;
});