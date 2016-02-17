Template.Perfil.rendered = function(){
    $('.perfil-cpf').inputmask('999.999.999-99');
    $('.perfil-phone').inputmask('(99) 9999[9]-9999');
    $('.perfil-birthdate').inputmask('99-99-9999');
    $('.cep').inputmask('99999-999');

    AUTOCOMPLETE.initialize(function(){
        $('.div-autocomplete').hide();
        $('.div-endereco').show();
        $("html, body").animate({ scrollTop: $(document).height() }, 1000);
    });

    var user = Meteor.user();

    if ( user.profile && user.profile.address){
        if ( user.profile.address.route ){
            // Endereço
            $('.div-autocomplete').hide();
            $('.div-endereco').show();
            $('.logradouro').val(user.profile.address.route);
            $('.numero').val(user.profile.address.number);
            $('.complemeto').val(user.profile.address.complement);
            $('.bairro').val(user.profile.address.neighborhood);
            $('.cidade').val(user.profile.address.city);
            $('.estado').val(user.profile.address.state);
            $('.cep').val(user.profile.address.postalCode);
            $('.latitude').val(user.profile.address.latitude);
            $('.longitude').val(user.profile.address.longitude);
        }
    }
}

Template.Perfil.helpers({
    checkMale: function(){
        if(Meteor.user().profile.details.gender=='male') return 'checked';
    },
    checkFemale: function(){
        if(Meteor.user().profile.details.gender=='female') return 'checked';
    },
    checkOther: function(){
        if(Meteor.user().profile.details.gender=='other') return 'checked';
    }
});

function validateForm(details,address){

    if(_.isEmpty(details.name)){
        alert(TAPi18n.__("profile-inv-name"))
        return false;
    }

    if(!UTIL.isValidEmail($('.perfil-email').val())){
        alert(TAPi18n.__("profile-inv-email"))
        return false;
    }

    if(!UTIL.validateCPF($('.perfil-cpf').val())){
        alert(TAPi18n.__("profile-inv-cpf"))
        return false;
    }

    if(_.isEmpty(details.phone)){
        alert(TAPi18n.__("profile-inv-phone"))
        return false;
    }

    if(_.isEmpty(details.birhdate)){
        alert(TAPi18n.__("profile-inv-birhdate"))
        return false;
    }

    if(_.isEmpty(address.route)){
        alert(TAPi18n.__("profile-inv-route"))
        return false;
    }

    if(_.isEmpty(address.neighborhood)){
        alert(TAPi18n.__("profile-inv-neighborhood"))
        return false;
    }

    if(_.isEmpty(address.city)){
        alert(TAPi18n.__("profile-inv-city"))
        return false;
    }

    if(_.isEmpty(address.state)){
        alert(TAPi18n.__("profile-inv-state"))
        return false;
    }

    if(_.isEmpty(address.postalCode)){
        alert(TAPi18n.__("profile-inv-postalCode"))
        return false;
    }

    return true;
}

Template.Perfil.events({
    'click .update-button': function(e){
        e.preventDefault();

        var details = {
            name: $('.perfil-name').val(),
            email: $('.perfil-email').val(),
            phone: $('.perfil-phone').val(),
            birhdate: $('.perfil-birthdate').val(),
            cpf: $('.perfil-cpf').val().replace(/[^\d]+/g,''),
            gender: $('.perfil-gender:checked').val()
        };

        var address = {
            route: $('.logradouro').val(),
            number: $('.numero').val(),
            complement: $('.complemento').val(),
            neighborhood: $('.bairro').val(),
            city: $('.cidade').val(),
            state: $('.estado').val(),
            postalCode: $('.cep').val(),
            latitude: $('.latitude').val(),
            longitude: $('.longitude').val()
        };

        if(!validateForm(details,address)){
            return false;
        }

        Meteor.call('updateUser', details, address, function (err, result) {
            if (!err) {
                alert(TAPi18n.__("profile-update-ok"));
            } else {
                alert(TAPi18n.__("profile-update-nok"));
            }
        });
    }
});