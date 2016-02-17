Template.AddressComponent.events({
    "click .new-address" : function(e) {
        e.preventDefault();
        $('.logradouro').val(null);
        $('.numero').val(null);
        $('.bairro').val(null);
        $('.cidade').val(null);
        $('.estado').val(null);
        $('.cep').val(null);
        $('.latitude').val(null);
        $('.longitude').val(null);
        $('.autocomplete').val(null);
        $('.div-autocomplete').val(null);
        $('.div-autocomplete').show();
        $('.div-endereco').hide();
    },
    'keyup .numero':function(){
        AUTOCOMPLETE.reloadLocation();
    }
});