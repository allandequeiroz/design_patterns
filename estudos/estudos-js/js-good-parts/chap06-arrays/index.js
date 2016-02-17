/**
 * Created by allanqueiroz on 12/12/14.
 */
Function.prototype.method = function(name, func){
    this.prototype[name] = func;
    return this;
}

//Array Literals
document.writeln('\nArray Literals');
var empty = [];
var numbers = [ //inherits from Array.prototype
    'zero','one','two','three','four',
    'five','six','seven','eight','nine'
];
document.writeln(empty[1])
document.writeln(numbers[1])
document.writeln(empty.length)
document.writeln(numbers.length)

var numbers_object = {  //inherits from Object.prototype
    '0':'zero','1':'one','2':'two','3':'three','4':'four',
    '5':'five','6':'six','7':'seven','8':'eight','9':'nine'
};
document.writeln(numbers_object[0])
document.writeln(numbers_object['2'])

var misc = [
    'string',98.6,true,false,null,undefined,
    ['nested','array'],{object:true},NaN,Infinity
];
document.writeln(misc.length)

var myArray = [];
document.writeln(myArray.length)
myArray[5] = true;
document.writeln(myArray.length)

numbers.length = 3;
document.writeln(numbers)

numbers[numbers.length] = 'shi';
document.writeln(numbers)
numbers.push('go');
document.writeln(numbers)

//Delete
document.writeln('\nDelete');
delete numbers[2];
document.writeln(numbers)

numbers.splice(2,1);
document.writeln(numbers)

//Enumeration
document.writeln('\nEnumeration');
var i;
for(i = 0 ; i < myArray.length ; i += 1){
    document.writeln(myArray[i]);
}

//Confusion
document.writeln('\nConfusion');
var is_array = function(value){
    return Object.prototype.toString.apply(value) === '[object Array]';
};
document.writeln(is_array(myArray));

//Methods
document.writeln('\nMethods');
Array.method('reduce',function(f,value){
    var i;
    for(i=0;i<this.length;i+=1){
        value=f(this[i],value);
    }
    return value;
});
var data = [4,8,15,16,23,42];
var add = function(a,b){
    return a+b;
};
var mult = function(a,b){
    return a*b;
};
var sum = data.reduce(add,0);
var product = data.reduce(mult,1);
document.writeln(sum);
document.writeln(product);

data.total = function(){
    return this.reduce(add,0)
};
document.writeln(data.total());

//Dimensions
document.writeln('\nDimensions');
Array.dim = function(dimension,initial){
    var a = [], i;
    for(i = 0 ; i < dimension ; i += 1){
        a[i] = initial;
    }
    return a;
};
var myArray = Array.dim(10,0);
document.writeln(myArray);

var matrix = [
    [0,1,2],
    [3,4,5],
    [6,7,8]
];
document.writeln(matrix[2][1]);

Array.matrix = function(m,n,initial){
    var a, i, j, mat = [];
    for(i = 0 ; i < m ; i += 1){
        a = [];
        for(j = 0 ; j < n ; j += 1){
            a[j] = initial;
        }
        mat[i] = a;
    }
    return mat;
};
var myMatrix = Array.matrix(4,4,0);
document.writeln(myMatrix);
document.writeln(myMatrix[3][3]);

Array.identity = function(n) {
      var i, mat = Array.matrix(n,n,0);
    for(i = 0 ; i < n ; i += 1){
        mat[i][i] = 1;
    }
    return mat;
};
myMatrix = Array.identity(4);
document.writeln(myMatrix[3][3]);