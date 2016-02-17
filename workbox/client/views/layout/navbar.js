Template.Navbar.events({
    'click .logout':function(e){
        e.preventDefault();
        Meteor.logout();
        FlowRouter.redirect('/login');
    }
});

Template.Navbar.helpers({
    isDesktop:function(){
        return Meteor.Device.isDesktop();
    }
});