/**
 * Created by allanqueiroz on 12/12/14.
 */
document.writeln('Hello, world!');
document.writeln(1e3);

Function.prototype.method = function(name, func){
    this.prototype[name] = func;
    return this;
}

//CHAPTER 2

//Object Literals
var empty_object = {};

var stooge = {
    "first-name": "Jerome",
    "last-name": "Howard"
};

var flight ={
    airline: "Oceanic",
    number: 815,
    departure: {
        IATA: "SYD",
        time: "2004-09-22 14:55",
        city: "Sydney"
    },
    arrival: {
        IATA: "LAX",
        time: "2004-09-23 10:42",
        city: "Los Angeles"
    }
};

//Retrieval
document.writeln('\nRetrieval');
document.writeln( stooge["middle-name"] );
document.writeln( flight.status );
document.writeln( stooge["FIRST-NAME"] );

var middle = stooge["middle-name"] || "(none)";
var status = flight.status || "unknown";

document.writeln( middle );
document.writeln( status);

document.writeln( flight.equipment ); // undefined
//document.writeln( flight.equipment.model ); // throw "TypeError"
document.writeln( flight.equipment && flight.equipment.model ); // undefined

//Update
document.writeln('\nUpdate');
stooge['first-name']= 'Allan';
stooge['middle-name']= 'de';
stooge['middlename']= 'de';
stooge['last-name']= 'Queiroz';
stooge.nickname = 'Curly';

flight.equipment = {
    model: 'Boeing 777'
};
flight.status = 'overdue'

document.writeln( stooge['first-name'] );
document.writeln( stooge.middle-name );
document.writeln( stooge.middlename );
document.writeln( stooge.last-name );
document.writeln( stooge.nickname );

//Reference
document.writeln('\nReference');
var x = stooge;
x.nickname = 'Curly';
var nick = stooge.nickname;
document.writeln( nick );

var a = {}, b = {}, c = {}; // differente objects
a = b = c = {}; // same object

//Prototype
document.writeln('\nPrototype');
if(typeof Object.create !== 'function'){
    Object.create = function(o){
        var F = function(){};
        F.prototype = o;
        return new F();
    };
}
var another_stooge = Object.create(stooge);
another_stooge['first-name'] = 'Harry';

//Reflection
document.writeln('\nReflection');
document.writeln( flight.number );
document.writeln( flight.status );
document.writeln( flight.arrival );
document.writeln( flight.manifest );
document.writeln( flight.toString );
document.writeln( flight.constructor );

document.writeln( flight.hasOwnProperty('number') );
document.writeln( flight.hasOwnProperty('constructor') );

//Enumeration
document.writeln('\nEnumeration');
var name;
for(name in another_stooge){
    if(typeof another_stooge[name] !== 'function'){
        document.writeln(name + ': ' + another_stooge[name]);
    }
}

var i;
var properties = [
    'first-name',
    'middle-name',
    'last-name',
    'profession'
];
for(i = 0 ; i < properties.length ; i+= 1){
    document.writeln(properties[i] + ": " + another_stooge[properties[i]]);
}

//Delete
document.writeln('\nDelete');
delete another_stooge.nickname;
document.writeln(another_stooge.nickname);

//Global Abatement
document.writeln('\nGlobal Abatement');
var MYAPP = {};
MYAPP.stooge = {
    "first-name": "Joe",
    "last-name": "Howard"
};
MYAPP.flight = {
    airline: "Oceanic",
    number: 815,
    departure: {
        IATA: "SYD",
        time: "2004-09-22 14:55",
        city: "Sydney"
    },
    arrival: {
        IATA: "LAX",
        time: "2004-09-23 10:42",
        city: "Los Angeles"
    }
};
document.writeln(MYAPP.stooge['first-name']);
document.writeln(MYAPP.flight.departure.IATA);

//Function Objects
document.writeln('\nFunction Objects');

//Function Literal
document.writeln('\nFunction Literal');
var add = function (a,b) {
    return a+b;
};

//Invocation
document.writeln('\nInvocation');

//Method Invocation Pattern
document.writeln('\nMethod Invocation Pattern');
var myObject = {
    value: 0,
    increment: function(inc){
        this.value += typeof inc === 'number' ? inc : 1;
    }
};
myObject.increment();
document.writeln(myObject.value);

myObject.increment(3);
document.writeln(myObject.value);

//Function Invocation Pattern
document.writeln('\nFunction Invocation Pattern');
var sum = add(3,4);

myObject.double = function(){
    var that = this;
    var helper = function(){
        that.value = add(that.value, that.value);
    };
    helper();
};

myObject.double();
document.writeln(myObject.value);

//Constructor Invocation Pattern
document.writeln('\nConstructor Invocation Pattern');
var Quo = function(string){
    this.status = string;
}

Quo.prototype.get_status = function(){
    return this.status;
}

var myQuo = new Quo("confused");
document.writeln(myQuo.get_status());

//Apply Invocation Pattern
document.writeln('\nApply Invocation Pattern');
var array = [3,4];
var sum = add.apply(null,array);

var statusObject = {
    status: 'A-OK'
}

//var status = Quo.prototype.get_status().apply(statusObject);

//Arguments
document.writeln('\nArguments');
var sum = function(){
    var i, sum = 0;
    for(i = 0 ; i < arguments.length ; i+= 1){
        sum += arguments[i];
    }
    return sum;
}
document.writeln(sum(4,8,15,16,23,42));

//Exceptions
document.writeln('\nExceptions');
var add = function(a,b){
    if(typeof a !== 'number' || typeof b !== 'number'){
        throw {
            name: 'TypeError',
            message: 'add needs numbers'
        };
    }
    return a+b;
}
var try_it = function(){
    try{
        add("seven")
    }catch (e){
        document.writeln(e.name + ": " + e.message);
    }
}
try_it();

//Augmenting Types
document.writeln('\nAugmenting Types');
Number.method('integer', function(){
    return Math[this < 0 ? 'ceil' : 'floor'](this);
});
document.writeln((-10/3).integer());

String.method('trim',function(){
    return this.replace(/^\s+|\s+$/g,'');
});
document.writeln('"' + "    neat    ".trim() + '"');

//Recursion
document.writeln('\nRecursion');
var factorial = function factorial(i,a){
    a = a || 1;
    if(i < 2){
        return a;
    }
    return factorial(i-1,a*i)
};
document.writeln(factorial(4));

//Closure
document.writeln('\nClosure');
var myObject = (function(){
    var value = 0;
    return {
        increment: function(inc){
            value += typeof inc === 'number' ? inc : 1;
        },
        getValue: function(){
            return value;
        }
    };
}());

var quo = function(status){
  return{
      get_status: function(){
          return status;
      }
  };
};
var myQuo = quo("amazed");
document.writeln(myQuo.get_status());

//Module
document.writeln('\nModule');
String.method('deentityify',function(){
    var entity = {
        quot: '"',
        lt: '<',
        gt: '>'
    };
    return function(){
        return this.replace(/&([^&;]+);/g, function(a,b){
                var r = entity[b];
                return typeof r === 'string' ? r : a;
            }

        );
    };
}());
document.writeln('&lt;&quot;&gt;'.deentityify());

var serial_maker = function(){
    var prefix = '';
    var seq = 0;
    return{
        set_prefix: function(p){
            prefix = String(p);
        },
        set_seq: function(s){
            seq = s;
        },
        gensym: function(){
            var result = prefix + seq;
            seq += 1;
            return result;
        }
    };
};
var seqer = serial_maker();
seqer.set_prefix('Q');
seqer.set_seq(1000);
var unique = seqer.gensym();
document.writeln(unique);

//Memoization
document.writeln('\nMemoization');
var memoizer = function(memo, formula){
    var recur = function(n){
        var result = memo[n];
        if(typeof result !== 'number'){
            result = formula(recur,n);
            memo[n] = result;
        }
        return result;
    };
    return recur;
};
var fibonacci = memoizer([0,1],function(recur,n){
    return recur(n-1)+recur(n-1);
});
document.writeln(fibonacci(1000));