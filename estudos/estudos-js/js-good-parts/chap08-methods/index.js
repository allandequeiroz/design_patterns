/**
 * Created by allanqueiroz on 12/12/14.
 */
Function.prototype.method = function(name, func){
    this.prototype[name] = func;
    return this;
}

//Array
document.writeln('\nArray');

var a = ['a','b','c'];
var b = ['x','y','z'];
var c = a.concat(b,true);
document.writeln(c);
document.writeln('--');

var a = ['a','b','c'];
a.push('d');
var c = a.join('');
document.writeln(c)
document.writeln('--');

var a = ['a','b','c'];
var c = a.pop();
document.writeln(c)
document.writeln('--');

var a = ['a','b','c'];
var b = ['x','y','z'];
var c = a.push(b,true);
document.writeln(c)
document.writeln('--');

var a = ['a','b','c'];
var b = a.reverse();
document.writeln(b)
document.writeln('--');

var a = ['a','b','c'];
var b = a.shift();
document.writeln(b)
document.writeln('--');

var a = ['a','b','c'];
var b = a.slice(0,1);
var c = a.slice(1);
var d = a.slice(1,2);
document.writeln(b)
document.writeln(c)
document.writeln(d)
document.writeln('--');

var n = [4,8,15,16,23,42];
n.sort();
document.writeln(n)
document.writeln('--');

n.sort(function(a,b){
    return a-b;
});
document.writeln(n)
document.writeln('--');

var m = ['aa','bb','a',4,8,15,16,23,42];
m.sort(function(a,b){
    if(a===b){
        return 0;
    }if(typeof a === typeof b){
        return a < b ? -1 : 1;
    }
    return typeof a < typeof b ? -1 : 1;
});
document.writeln(m)
document.writeln('--');

var by = function(name){
    return function(o,p){
        var a,b;
        if(typeof o === 'object' && typeof p === 'object' && o && p){
            a = o[name];
            b = p[name];
            if(a === b){
                return 0;
            }
            if(typeof a === typeof b){
                return a < b ? -1 : 1;
            }
            return typeof a < typeof b ? -1 : 1;
        }else{
            throw{
                name: 'Error',
                message: 'Expected an object when sorting by ' + name
            };
        }
    };
};
var s = [
    {first: 'Joe',last: 'Besser'},
    {first: 'Moe',last: 'Howard'},
    {first: 'Joe',last: 'DeRita'},
    {first: 'Shemp',last: 'Howard'},
    {first: 'Larry',last: 'Fine'},
    {first: 'Curly',last: 'Howard'}
];
s.sort(by('first')).sort(by('last'));
for(i = 0 ; i < s.length ; i += 1){
    document.writeln(s[i].first + ' ' + s[i].last);
}
document.writeln('--');

var by = function(name, minor){
    return function(o,p){
        var a,b;
        if(o && p && typeof o === 'object' && typeof p === 'object'){
            a = o[name];
            b = p[name];
            if(a === b){
                return typeof minor === 'function' ? minor(o,p) : 0;
            }
            if(typeof a === typeof b){
                return a < b ? -1 : 1;
            }
            return typeof a < typeof b ? -1 : 1;
        }else{
            throw {
                name: 'Error',
                message: 'Expected an object when sorting by' + name
            };
        }
    };
};
var s = [
    {first: 'Joe',last: 'Besser'},
    {first: 'Moe',last: 'Howard'},
    {first: 'Joe',last: 'DeRita'},
    {first: 'Shemp',last: 'Howard'},
    {first: 'Larry',last: 'Fine'},
    {first: 'Curly',last: 'Howard'}
];
s.sort(by('last')).sort(by('first'));
for(i = 0 ; i < s.length ; i += 1){
    document.writeln(s[i].first + ' ' + s[i].last);
}
document.writeln('--');

var a = ['a','b','c'];
var r = a.splice(1,1,'ache','bug');
document.writeln(a)
document.writeln('--');

var a = ['a','b','c'];
var r = a.unshift('?','@');
document.writeln(a)
document.writeln('--');

//Function
document.writeln('\nFunction');
Function.method('bind',function(that){
    var method = this,
        slice = Array.prototype.slice,
        args = slice.apply(arguments,[1]);
    return function() {
        return method.apply(
            that,
            args.concat(slice.apply(arguments, [0]))
        );
    };
});
var x = function(){
    return this.value;
}.bind({value: 666});
document.writeln(x())
document.writeln('--');

//Number
document.writeln('\nNumber');
document.writeln(Math.PI.toExponential(0));
document.writeln(Math.PI.toExponential(2));
document.writeln(Math.PI.toExponential(7));
document.writeln(Math.PI.toExponential(16));
document.writeln(Math.PI.toExponential());
document.writeln('--');

document.writeln(Math.PI.toFixed(0));
document.writeln(Math.PI.toFixed(2));
document.writeln(Math.PI.toFixed(7));
document.writeln(Math.PI.toFixed(16));
document.writeln(Math.PI.toFixed());
document.writeln('--');

document.writeln(Math.PI.toString(2));
document.writeln(Math.PI.toString(7));
document.writeln(Math.PI.toString(16));
document.writeln(Math.PI.toString());
document.writeln('--');

//Object
document.writeln('\nObject');
var a = {member: true};
var b = Object.create(a);
var t = a.hasOwnProperty('member');
var u = b.hasOwnProperty('member');
var v = b.member;
document.writeln(a);
document.writeln(b);
document.writeln(t);
document.writeln(u);
document.writeln(v);
document.writeln('--');

//String
document.writeln('\nString');

var name = 'Curly';
var initial = name.charAt(0);
document.writeln(initial);
document.writeln('--');

var initial = name.charCodeAt(0);
document.writeln(initial);
document.writeln('--');

var s = 'C'.concat('a','t','.');
document.writeln(s);
document.writeln('--');

var text = 'Mississippi';
var a = text.indexOf('ss');
b = text.indexOf('ss',3);
c = text.indexOf('ss',6);
document.writeln(a);
document.writeln(b);
document.writeln(c);
document.writeln('--');

var text = 'Mississippi';
var a = text.lastIndexOf('ss');
b = text.lastIndexOf('ss',3);
c = text.lastIndexOf('ss',6);
document.writeln(a);
document.writeln(b);
document.writeln(c);
document.writeln('--');

var m = ['AAA','A','aa','a','Aa','aaa'];
m.sort(function(a,b){
    return a.localeCompare(b);
});
document.writeln(m);
document.writeln('--');

var text = '<html><body bgcolor="#faf0e6"><p>This is <b>bold<\/b>!<\/p><\/body><\/html>';
var tags = /[^<>]+|<(\/?)([A-Za-z]+)([^<>]*)>/g;
var a,i;
a = text.match(tags);
for(i = 0 ; i < a.length ; i+= 1){
    document.writeln(('// ['+i+'] '+a[i]));
}
document.writeln('--');

var text = 'and in it he says "Any damm fool could';
var a = text.slice(18);
var b = text.slice(0,3);
var c = text.slice(-5);
var d = text.slice(19,32);
document.writeln(a);
document.writeln(b);
document.writeln(c);
document.writeln(d);
document.writeln('--');

var digits = '0123456789';
var a  = digits.split('',5);
document.writeln(a);
document.writeln('--');
