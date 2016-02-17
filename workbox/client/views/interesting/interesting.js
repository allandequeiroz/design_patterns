Template.Interesting.helpers({
    'getInteresting':function(){
        return Ad.find({}).fetch();
    }
});