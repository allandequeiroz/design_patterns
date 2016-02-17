Template.Ad.rendered = function(){
    AUTOCOMPLETE.initialize(function(){
        $('.div-autocomplete').hide();
        $('.div-endereco').show();
        $("html, body").animate({ scrollTop: $(document).height() }, 1000);
    });

    $('.ad-title').maxlength({
        threshold: 25
    });

    $('.ad-value').inputmask('decimal',
        { 'alias': 'numeric',
            'groupSeparator': '.',
            'autoGroup': true,
            'digits': 2,
            'radixPoint': ",",
            'digitsOptional': false,
            'allowMinus': false,
            'placeholder': '0'
        }
    );

    $('.ad-value').maxlength({
        threshold: 11
    });

    $('#ad-content').maxlength({
        threshold: 140
    });
}

Template.Ad.events({
    'click .btn-here':function(){
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position){
                Meteor.call(
                    'getAddressByLatLng',
                    position.coords.latitude,
                    position.coords.longitude,
                    function(err,result){
                        if(!err){
                            alert(result);
                        }
                    }
                );
            });
        } else {
            alert(TAPi18n.__("geoloc-msg"));
        }
    },
    'click .btn-my-place':function(){
        var address = Meteor.user().profile.address;
        $(".complemento").val(address.complement);
        $(".numero").val(address.number);
        $(".logradouro").val(address.route);
        $(".bairro").val(address.neighborhood);
        $(".cidade").val(address.city);
        $(".estado").val(address.state);
        $(".cep").val(address.postalCode);
        $(".latitude").val(address.latitude);
        $(".longitude").val(address.longitude);
        $('.div-autocomplete').hide();
        $('.div-endereco').show();
    },
    'click .btn-annouce':function(e){
        e.preventDefault();
        var ad = {
            title: $('.ad-title').val(),
            value: $('.ad-value').val(),
            content: $('#ad-content').val(),
            owner: Meteor.userId(),
            createdAt: new Date(),
            active:true
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

        if(!_.isEmpty(address.route)){
            ad.address = address;
        }

        Meteor.call('addAd',ad,function(err,result){
            if(!err){
                cleanForm();
                alert(TAPi18n.__("ad-inserted"))
            }else{
                alert(TAPi18n.__("ad-not-inserted"))
            }
        });
    }
});

function cleanForm(){
    $('.ad-title').val(""),
    $('.ad-value').val(""),
    $('#ad-content').val(""),
    $(".numero").val("");
    $(".logradouro").val("");
    $(".bairro").val("");
    $(".cidade").val("");
    $(".estado").val("");
    $(".cep").val("");
    $(".latitude").val("");
    $(".longitude").val("");
    $('.div-autocomplete').show();
    $('.div-endereco').hide();
}