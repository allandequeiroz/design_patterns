Template.Ads.helpers({
    'getAds':function(){
        return Ad.find({}).fetch();
    },
    'showAd':function(){
        var ignored = IgnoreAd.findOne({owner:Meteor.userId()});
        if(ignored){
            if(_.contains(ignored.ads,this._id)){
                return false;
            }
        }

        if(Meteor.user()){
            return Ad.findOne({_id:this._id,interested:{$in:[Meteor.userId()]}})?false:true;
        }else{
            return true;
        }
    }
});