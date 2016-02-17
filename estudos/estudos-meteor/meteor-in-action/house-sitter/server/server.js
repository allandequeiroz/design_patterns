Meteor.startup(function(){
    if(HouseCollection.find().count() === 0){
        var houses = [{
            name: 'Stephan',
            plants: [
                {color: "red", instructions: "3 pots/week"},
                {color: "white", instructions: "keep humid"}
            ]
        }];
        while(houses.length > 0){
            HouseCollection.insert(houses.pop());
        }
        console.log("Added fixtures");
    }
});