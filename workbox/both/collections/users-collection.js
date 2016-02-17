Meteor.methods({
    updateUser: function(details,address){
        if (Meteor.isServer) {
            var user = Meteor.user();
            user.profile.details = details;
            user.profile.address = address;
            Meteor.users.update(user._id, {$set: user}, {upsert: true});
        }
    },
    changeStatus: function(id,status){
        Meteor.users.update(id,{$set:{"profile.details.active":status}});
    },
    isProfileComplete: function(){
        if(Meteor.user()) {
            var user = Meteor.user();
            if (_.isEmpty(user.profile.details.name))return false;
            if (_.isEmpty(user.profile.details.email))return false;
            if (_.isEmpty(user.profile.details.cpf))return false;
            if (_.isEmpty(user.profile.details.phone)) return false;
            if (_.isEmpty(user.profile.details.birhdate)) return false;
            if (_.isEmpty(user.profile.address.route)) return false;
            if (_.isEmpty(user.profile.address.neighborhood)) return false;
            if (_.isEmpty(user.profile.address.city)) return false;
            if (_.isEmpty(user.profile.address.state)) return false;
            if (_.isEmpty(user.profile.address.postalCode)) return false;
            return true;
        }else{
            return false;
        }
    }
});