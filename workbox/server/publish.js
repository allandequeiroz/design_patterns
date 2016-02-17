Meteor.publish('OneAd',function(adId){
    var ad = Ad.findOne({_id:adId});
    if(ad.owner==this.userId) {
        return Ad.find({_id:adId});
    }else{
        return null;
    }
});

Meteor.publish('Ad',function(){
    var ignored = IgnoreAd.findOne({owner:this.userId});
    if(ignored){
        return Ad.find({active:true,_id:{$nin:[ignored.ads]}},{sort:{createdAt: -1}});// essa linha funciona?
    }else{
        return Ad.find({active:true},{sort:{createdAt: -1}});
    }
});

Meteor.publish('MyAds',function(){
    return Ad.find({active:true,owner:this.userId},{sort:{createdAt: -1}});
});

/*
Meteor.publish('Ad',function(){
    return Ad.find({},{sort:{createdAt: -1}});
});
*/

Meteor.publish('IgnoreAd',function(){
    return IgnoreAd.find({owner:this.userId});
});

Meteor.publish('Interested',function(adId){
    var ad = Ad.findOne({_id:adId});
    if(ad.owner==this.userId) {
        return Meteor.users.find({_id:{$in:ad.interested}});
    }else{
        return null;
    }
});

Meteor.publish('Interesting',function(){
    return Ad.find({active:true,interested:{$in:[this.userId]}},{sort:{createdAt: -1}});
});