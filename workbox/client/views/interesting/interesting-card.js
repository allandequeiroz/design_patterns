Template.InterestingCard.events({

});

Template.InterestingCard.helpers({
    'hasInteresting':function() {
        if (this.interested) {
            if(this.interested.length>0){
                return true;
            }
        }
        return false;
    }
});