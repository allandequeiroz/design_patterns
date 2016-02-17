Ad = new Mongo.Collection("ad");

Ad.allow({
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
    addAd:function(ad){
        Ad.insert(ad);
    },
    finishAd:function(adId){
        var ad = Ad.findOne({_id:adId});
        if(ad){
            ad.active = false;
        }
        Ad.upsert({_id:ad._id},ad);
    }
});