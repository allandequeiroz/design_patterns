Template.MyAds.helpers({
    'getAds':function(){
        return Ad.find({}).fetch();
    }
});