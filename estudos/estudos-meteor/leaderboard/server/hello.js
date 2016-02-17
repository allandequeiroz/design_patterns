Meteor.methods({
  'insertPlayerData':function(playerNameVar){
    var currentUserId = Meteor.userId();
    PlayerList.insert({
      name:playerNameVar,
      score:0,
      createdBy:currentUserId
    });
  },
  'removePlayerData':function(removePlayerData){
    PlayerList.remove(removePlayerData);
  },
  'modifyPlayerScore':function(selectedPlayer,scoreValue){
    PlayerList.update(selectedPlayer, {$inc:{score:scoreValue}});
  }
});
Meteor.publish('thePlayers',function(){
  var currentUserId = this.userId;
  return PlayerList.find({createdBy:currentUserId});
});