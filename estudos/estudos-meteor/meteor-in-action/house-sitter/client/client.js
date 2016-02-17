var emptyHouse = {name:"",plants:[]};
var editObject;
reactiveHouseObject = new ReactiveVar(emptyHouse);

storeReativeHouseObject = function(obj){
    obj.edited = true;
    reactiveHouseObject.set(obj);
};

Template.registerHelper('selectedHouse',function(){
    return reactiveHouseObject.get();
});

Template.registerHelper('withIndex',function(list){
    var withIndex = _.map(list, function(v,i){
        v.index = i;
        return v;
    });
    return withIndex;
});

Tracker.autorun(function(){
    console.log("The selectedHouse Id is: " + Session.get("selectedHouse"));
});

//SELECT HOUSE
Template.selectHouse.helpers({
    houseNameId: function(){
        return HouseCollection.find({},{fields: {name: 1, _id: 1}});
    },
    isSelected: function(){
        return Session.equals('selectedHouse',this._id) ? 'selected' : '';
    }
});

Template.selectHouse.events = {
    'change #selectHouse': function(evt){
        Session.set("selectedHouse",evt.currentTarget.value);
        reactiveHouseObject.set(
            HouseCollection.findOne({_id:Session.get('selectedHouse')})
            || emptyHouse
        )
    }
};
//FIM SELECT HOUSE

//SHOW HOUSE
Template.showHouse.events({
    'click button#delete': function(evt){
        var id = $(evt.currentTarget).attr('data-id');
        var deleteConfirmation = confirm("Really delete this house?");
        if(deleteConfirmation){
            HouseCollection.remove(id);
            reactiveHouseObject.set(emptyHouse);
        }
    }
});
//FIM SHOW HOUSE

//HOUSE FORM
Template.houseForm.events({
    'click button#saveHouse':function(evt){
        evt.preventDefault();
        editObject = reactiveHouseObject.get();
        delete editObject.edited;
        editObject._id = HouseCollection.upsert(
            {_id:reactiveHouseObject.get()._id},
            reactiveHouseObject.get()
        ).insertedId || reactiveHouseObject.get()._id;
        Session.set("selectedHouse",editObject._id);
        reactiveHouseObject.set(editObject);
    },
    'click button.addPlant': function(evt){
        evt.preventDefault();
        editObject = reactiveHouseObject.get();
        editObject.plants.push({color:'',instructions:''});
        storeReativeHouseObject(editObject);
    },
    'keyup input.name': function(evt){
        editObject = reactiveHouseObject.get();
        editObject.name = $(evt.currentTarget).val();
        storeReativeHouseObject(editObject);
    }
});
//FIM HOUSE FORM

//PLANT DETAILS
Template.plantDetails.events({
    'click button.water': function(evt){
        var plantId = $(evt.currentTarget).attr('data-id');
        var lastvisit = new Date();
        Session.set(plantId,true);
        HouseCollection.update(
            {_id:Session.get("selectedHouse")},
            {$set:{lastvisit:lastvisit}}
        );
        editObject = reactiveHouseObject.get();
        editObject.lastvisit = lastvisit;
        reactiveHouseObject.set(editObject);
    }
});

Template.plantDetails.helpers({
    isWatered: function(){
        var plantId = Session.get('selectedHouse') + '-' + this.color;
        return Session.get(plantId) ? 'disabled' : '';
    }
});
//FIM PLANT DETAILS

//PLANT FIELDSET
Template.plantFieldset.events({
    'click button.removePlant':function(evt){
        evt.preventDefault();
        var thisPlantIndex = $(evt.currentTarget).parent().attr("id").split('-')[1];
        editObject = reactiveHouseObject.get();
        editObject.plants.splice(thisPlantIndex,1);
        storeReativeHouseObject(editObject);
    },
    'keyup input.color, keyup input.instructions':function(evt){
        var thisPlantIndex = $(evt.currentTarget).attr("data-index");
        console.log("Index: ", thisPlantIndex);
        var fieldName = $(evt.currentTarget).attr("class");
        editObject = reactiveHouseObject.get();
        editObject.plants[thisPlantIndex][fieldName] = $(evt.currentTarget).val();
        storeReativeHouseObject(editObject);
        if(fieldName == "color"){
            var currentColor = editObject.plants[thisPlantIndex]['color'];
            plantsArray = reactiveHouseObject.get().plants;
            var colorCount = 0;
            for(i in plantsArray){
                if(plantsArray[i]['color']){
                    colorCount+=1;
                }
            }
            if(colorCount!=1){
                $(evt.currentTarget).css("background-color","red");
                $("button#saveHouse").attr("disabled","disabled");
            }else{
                $(evt.currentTarget).css("background-color","");
                $("button#saveHouse").removeAttr("disabled");
            }
        }
    }
});
//FIM PLANT FIELDSET