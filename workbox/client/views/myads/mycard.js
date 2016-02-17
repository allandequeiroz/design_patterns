Template.MyCard.events({
    'click .mycard-details':function(e){
        e.preventDefault();

    },
    'click .mycard-end':function(e){
        e.preventDefault();
        var r = confirm(TAPi18n.__("finish-ad-ask"));
        if (r == true) {
            Meteor.call('finishAd',this._id,function(err,result){
                if(err){
                    alert(TAPi18n.__("finish-ad-nok"));
                }
            });
        }
    },
    'click .btn-interesting':function(e){
        e.preventDefault();
        FlowRouter.go('/myads/'+this._id);
    }
});

Template.MyCard.helpers({
    'hasInteresting':function() {
        if (this.interested) {
            if(this.interested.length>0){
                return true;
            }
        }
        return false;
    },
    'howManyInterested':function(){
        return this.interested.length;
    }
});