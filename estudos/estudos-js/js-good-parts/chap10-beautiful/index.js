/**
 * Created by allanqueiroz on 12/12/14.
 */
Function.prototype.method = function(name, func){
    this.prototype[name] = func;
    return this;
}
