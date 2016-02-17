Template.InterestedList.helpers({
    'getInterested':function(){
        var adId = FlowRouter.getParam('adId');
        var ad = Ad.findOne({_id:adId});
        return Meteor.users.find({_id:{$in:ad.interested}}).fetch();
    }
});