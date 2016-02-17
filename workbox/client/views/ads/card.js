Template.Card.helpers({
    'showInterestBtns':function(){
        return Meteor.userId()!==this.owner?true:false;
    }
    /*
    'alreadyInterested':function(){
        return Ad.findOne({_id:this._id,interested:{$in:[Meteor.userId()]}})?true:false;
    }
    */
});

Template.Card.events({
    'click .interest-yes':function(e){
        e.preventDefault();
        Meteor.call('addInterest',this._id,function(err,result){
            if(err){
                alert(TAPi18n.__("interested-nok"));
            }
        });
    },
    'click .interest-no':function(e){
        e.preventDefault();
        Meteor.call('ignoreAd',this._id,function(err,result){
            if(err){
                alert(TAPi18n.__("interested-del-nok"));
            }
        });
    }
    /*
    'click .interest-not-enymore':function(e){
        e.preventDefault();
        Meteor.call('delInterest',this._id,function(err,result){
            if(err){
                alert(TAPi18n.__("interested-del-nok"));
            }else{
                alert(TAPi18n.__("interested-del-ok"));
            }
        });
    },
    */
});