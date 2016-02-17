if (Meteor.isClient) {
  //Expressions
  Template.expressions.helpers({
    name: function(){
      return "<strong>Allan</strong>"
    }
  });
  //Fim Expressions

  //Modular Templates
  Template.partialsUserProfile.helpers({
    name: function(){
      return "Allan";
    },
    image: function(){
      return "http://goo.gl/LCO7NX";
    }
  });
  //Fim Modular Templates

  //Dynamically included templates
  Template.dynamicPartials.helpers({
    templateNameLeft: function(){
      return "partialsUserProfile";
    },
    templateNameRight: function(){
      return "partialsNewsStream";
    }
  });
  //Fim Dynamically included templates

  //Block tags
  Template.blockTags.helpers({
    image: function(){
      return "http://goo.gl/BcEvDA";
    },
    highlight: function(){
      return true;
    },
    skills: function(){
      return ['meteor','sailing','cooking'];
    },
    profileJim: function(){
      var jim = {
        name: 'Jim "Sailor Ripley" Johnson',
        skills: ['meteor','sailing','cooking']
      };
      return jim;
    }
  });
  //Fim Block tags

  //Local template helpers
  Template.localHelpers.helpers({
    name: 'Jim',
    image: {
      large: 'http://goo.gl/JmQRaV',
      thumb: 'http://goo.gl/FhqKAQ'
    },
    skills: ['meteor','sailing','cooking'],
    hasMoreSkills: function(skills){
      return skills && skills.length > 1;
    }
  });
  //Fim Local template helpers

  //Global helpers
  Template.globalHelpers.helpers({
    skills: function(){
      return ['meteor','sailing','cooking'];
    },
    images: function(){
      return ['http://goo.gl/JmQRaV','http://goo.gl/FhqKAQ'];
    }
  });
  //Fim Global helpers

  //Template.elseBlock
  Template.templateElseBlock.helpers({
    gender: function(){
      return 'w';
    }
  });
  Template.isFemale.helpers({
    eq: function(a,b){
      return a === b;
    }
  });
  //Fim Template.elseBlock

  //Template event maps
  Template.layout.events({
    'click button': function(event, template){
      $('body').css('background-color','red');
    }
  });
  Template.green.events({
    'click button': function(event, template){
      event.stopImmediatePropagation();
      $('body').css('background-color','green');
    }
  });
  //Fim Template event maps

  //Prevent browser behavior
  Template.profile.events({
    'click a': function(){
      event.preventDefault();
      alert('Stay here!');
    }
  });
  //Fim Prevent browser behavior

  //Template lifecycle
  Template.lifecycle.created = function(){
    this.lastCallback = 'created';
    console.log('profile.created',this);
  };
  Template.lifecycle.rendered = function(){
    this.lastCallback = 'rendered';
    console.log('profile.rendered',this);
  };
  Template.lifecycle.destroyed = function(){
    this.lastCallback = 'destroyed';
    console.log('profile.destroyed',this);
  };
  Template.lifecycle.helpers({
    placeholder: function(){
      console.log('profile.placeholder',this);
      console.log('profile.tplInstance',Template.instance().lastCallback);
      return 'This is the {{placeholder}} helper';
    },
    'click button': function(event, template){
      Template.instance().lastCallback = 'rendered and clicked';
      console.log('profile.clicked',this);
      console.log('profile.clicked.tplInstance',template);
    }
  });
  //Fim Template lifecycle

}

if (Meteor.isServer) {

}
