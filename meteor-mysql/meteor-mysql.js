var click = undefined;
var clicks = new MysqlSubscription('clicks');

clicks.addEventListener('update', function(diff, data) {
  console.log(data[0].counter);
});

if (Meteor.isClient) {
  Meteor.methods({
    'incCounter': function(id, amount) {
      var filtered = clicks.filter(function(click) {
        return click.id === id;
      })[0];

      filtered.counter = parseInt(filtered.counter)+amount;
      clicks.changed();
    }
  });

  Template.hello.helpers({
    counter: function () {
      clicks.depend();
      var filtered = clicks.filter(function(click) {
        return true;
      });
      click = filtered[0];
      return click;
    }
  });

  Template.hello.events({
    'click button': function () {
      Meteor.call('incCounter', click.id, 1);
    }
  });
}

if (Meteor.isServer) {
  var liveDb = new LiveMysql(Meteor.settings.mysql);

  var closeAndExit = function() {
    liveDb.end();
    process.exit();
  };

  // Close connections on hot code push
  process.on('SIGTERM', closeAndExit);

  // Close connections on exit (ctrl + c)
  process.on('SIGINT', closeAndExit);

  Meteor.publish('clicks', function(){
    return liveDb.select(
    'SELECT * FROM clicks LIMIT 1',
    [ { table: 'clicks' } ]
    );
  });

  Meteor.methods({
    'incCounter': function(id, amount) {
      check(id, Number);
      check(amount, Number);

      liveDb.db.query(
        'UPDATE clicks SET counter = counter + ? WHERE id = ?', [ amount, id ]);
    }
  });
}
