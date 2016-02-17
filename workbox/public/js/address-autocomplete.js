AUTOCOMPLETE = (function autocompleteModule(){
    //var locationByAddress = "https://maps.googleapis.com/maps/api/geocode/json?address={0}&key=AIzaSyBn3LaT87EFamAmpeF8McOcPJQZuu--AqI&q=&language=pt-br";
    var placeChangedListener;

    var setValues = function(place){
        var components =  place['address_components'];
        if(components){
            for(var i = 0 ; i < components.length ; i++){
                var component = components[i];
                switch (component['types'][0]){
                    case 'street_number':
                        $(".numero").val(component['short_name']);
                        break;
                    case 'route':
                        $(".logradouro").val(component['short_name']);
                        break;
                    case 'neighborhood':
                        $(".bairro").val(component['short_name']);
                        break;
                    case 'locality':
                        $(".cidade").val(component['short_name']);
                        break;
                    case 'administrative_area_level_1':
                        $(".estado").val(component['short_name']);
                        break;
                    case 'postal_code':
                        $(".cep").val(component['short_name']);
                        break;
                }
            }
        }
        $(".latitude").val(place.geometry.location.lat());
        $(".longitude").val(place.geometry.location.lng());
    }

    var fillInAddress = function() {
        $(".numero").val("");
        $(".logradouro").val("");
        $(".bairro").val("");
        $(".cidade").val("");
        $(".estado").val("");
        $(".cep").val("");
        $(".latitude").val("");
        $(".longitude").val("");

        var place = autocomplete.getPlace();
        setValues(place);
    };

    var initialize = function(func) {
        placeChangedListener = func;
        autocomplete = new google.maps.places.Autocomplete(
            /** @type {HTMLInputElement} */(document.getElementById('autocomplete')));
        google.maps.event.addListener(autocomplete, 'place_changed', function() {
            fillInAddress();
            placeChangedListener();
        });
    };

    var getAddress = function() {
        var address =
            $(".logradouro").val() + " " +
            $(".numero").val() + ", " +
            $(".bairro").val() + ", " +
            $(".cidade").val() + ", " +
            $(".estado").val();
        return address;
    }

    var reloadLocation = function(){
        geocoder = new google.maps.Geocoder();
        geocoder.geocode({ 'address': getAddress() }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                setValues(results[0]);
            }
        });
    }

    var publicAPI = {
        initialize: initialize,
        reloadLocation: reloadLocation
    };

    return publicAPI;
})();