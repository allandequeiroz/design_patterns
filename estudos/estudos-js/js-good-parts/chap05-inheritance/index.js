/**
 * Created by allanqueiroz on 12/12/14.
 */
Function.prototype.method = function(name, func){
    this.prototype[name] = func;
    return this;
}

//Pseudoclassical
document.writeln('\nPseudoclassical');
Function.method('new',function(){
    var that = Object.create(this.prototype);
    var other = this.apply(that,arguments);
    return (typeof other === 'object' && other) || that;
});

var Mammal = function(name){
    this.name = name;
};
Mammal.prototype.get_name = function(){
    return this.name;
};
Mammal.prototype.says = function(){
    return this.saying || '';
};
var myMammal = new Mammal('Herb the Mammal');
var name = myMammal.get_name();
document.writeln(name);

var Cat = function(name){
    this.name = name;
    this.saying = 'meow';
};
Cat.prototype =  new Mammal();
Cat.prototype.purr = function(n){
    var i, s = '';
    for(i = 0 ; i < n ; i += 1){
        if(s){
            s += '-';
        }
        s += 'r';
    }
    return s;
};
Cat.prototype.get_name = function(){
    return this.says() + ' ' + this.name + ' ' + this.says();
};
var myCat = new Cat('Henrietta');
var says = myCat.says();
var purr = myCat.purr(5);
var name = myCat.get_name();
document.writeln(says);
document.writeln(purr);
document.writeln(name);

//Improving but, still not so good
Function.method('inherits',function(Parent){
    this.prototype = new Parent();
    return this;
});
var Cat = function(name){
    this.name = name;
    this.saying = 'meow';
}.inherits(Mammal).
    method('purr',function(n){
        var i,s='';
        for(i=0;i<n;i+=1){
            if(s){
                s+='-';
            }
            s+='r';
        }
        return s;
    }).
    method('get_name',function(){
        return this.says() + ' ' + this.name + ' ' + this.says();
    });
myCat = new Cat('Nikitta');
says = myCat.says();
purr = myCat.purr(5);
name = myCat.get_name();
document.writeln(says);
document.writeln(purr);
document.writeln(name);

//Object Specifiers
document.writeln('\nObject Specifiers');
//var myObject = maker({
//    first: f,
//    last: l,
//    middle: m,
//    state: s,
//    city: c
//});

//Prototypal
document.writeln('\nPrototypal');
var myMammal = {
    name: 'Herb the Mammal',
    get_name: function(){
        return this.name;
    },
    says: function(){
        return this.saying || '';
    }
};
var myCat = Object.create(myMammal);
myCat.name = 'Henrietta';
myCat.saying = 'meow';
myCat.purr = function(n){
    var i,s='';
    for(i=0;i<n;i+=1){
        if(s){
            s+='-';
        }
        s+='r';
    }
    return s;
};
myCat.get_name = function(){
    return this.says() + ' ' + this.name + ' ' + this.says();
};

//var block = function(){
//    var oldScope = scope;
//    scope = Object.create(scope);
//    advance('{');
//    parse(scope);
//    advance('}');
//    scope = oldScope;
//};
//var myBlock = block();

//Functional
document.writeln('\nFunctional');
var mammal = function(spec){
    var that = {};
    that.get_name = function(){
        return spec.name;
    };
    that.says = function(){
        return spec.saying || '';
    };
    return that;
};
var myMammal = mammal({name:'erb.'});
document.writeln(myMammal.get_name());

var cat = function(spec){
    spec.saying = spec.saying || 'meow';
    var that = mammal(spec);
    that.purr = function(n){
        var i, s = '';
        for(i = 0 ; i < n ; i += 1){
            if(s){
                s += '-';
            }
            s += 'r';
        }
        return s;
    };
    that.get_name = function(){
        return that.says() + ' ' + spec.name + ' ' + that.says();
    };
    return that;
};

Object.method('superior',function(name){
    var that = this, method = that[name];
    return function(){
        return method.apply(that,arguments);
    };
});
var coolcat = function(spec){
    var that = cat(spec),
        super_get_name = that.superior('get_name');
    that.get_name = function(n){
        return 'like ' + super_get_name() + ' baby';
    };
    return that;
};
var myCoolCat = coolcat({name:'Bix'});
var name = myCoolCat.get_name();
document.writeln(name);

//Parts
document.writeln('\nParts');
var eventuality = function(that){
    var registry = {};
    that.fire = function(event){
        var array,func,handler, i,
            type = typeof event === 'string' ? event : event.type;

        if(registry.hasOwnProperty(type)){
            array = registry[type];
            for(i = 0 ; i < array.length ; i += 1){
                handler = array[i];
                func = handler.method;
                if(typeof func === 'string'){
                    func = this[func];
                }

                func.apply(this,handler.parameters || [event]);
            }
        }
        return this;
    };

    that.on = function(type, method, parameters){
        var handler = {
            method: method,
            parameters: parameters
        };
        if(registry.hasOwnProperty(type)){
            registry[type].push(handler);
        }else{
            registry[type] = [handler];
        }
        return this;
    };
    return that;
};

