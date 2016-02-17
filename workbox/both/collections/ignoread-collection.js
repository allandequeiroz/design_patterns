IgnoreAd = new Mongo.Collection("ignoread");

IgnoreAd.allow({
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
    ignoreAd:function(adId){
        var ignored = IgnoreAd.findOne({owner:Meteor.userId()});
        if(!ignored){
            ignored = {
                owner:Meteor.userId(),
                ads:[]
            }
        }
        ignored.ads.push(adId);
        IgnoreAd.upsert({_id:ignored._id},ignored);
    },
    addInterest:function(adId){
        var ad = Ad.findOne({_id:adId});
        if(!ad.interested){
            ad.interested = [];
        }
        ad.interested.push(Meteor.userId());
        Ad.upsert({_id:ad._id},ad);
    },
    delInterest:function(adId){
        var ad = Ad.findOne({_id:adId});
        if(!ad.interested){
            ad.interested = [];
        }
        ad.interested.pop(Meteor.userId());
        Ad.upsert({_id:ad._id},ad);
    }
});