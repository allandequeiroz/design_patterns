Interesting = new Mongo.Collection("Interesting");

Interesting.allow({
    insert: function(doc){
        return true;
    },
    update: function(doc){
        return true;
    },
    remove: function(doc){
        return true;
    }
});

Meteor.methods({
    addInteresting:function(adId,adOwner){
        var interesting = Interesting.findOne({owner:Meteor.userId()});
        if(!interesting){
            interesting = {
                adId:adId,
                adOwner:adOwner,
                interested:[]
            }
        }
        var interested = {
            id:Meteor.userId(),
            hired:false
        }
        interesting.interested.push(interested);
        IgnoreAd.upsert({_id:interesting._id},interesting);
    }
});