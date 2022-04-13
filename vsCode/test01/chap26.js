/* // 메서드
const obj = {
	x : 1,
    foo() {return this.x},  // 메서드
    bar: function() {return this.x} // 일반 함수
};
console.log(obj.foo());
console.log(obj.bar());

// new obj.foo(); //error
new obj.bar();

console.log(obj.foo.hasOwnProperty('prototype')); //false
console.log(obj.bar.hasOwnProperty('prototype')); //true

const base = {
    name: 'Lee',
    sayHi(){
        return `Hi! ${this.name}`;
    }
};
const derived = {
    __proto__:base,
    sayHi(){
        return `${super.sayHi()}.how are you doing?`;
    }
};

// const derived = {
//     __proto__:base,
//     sayHi : function(){
//         // 일반함수는 super 이용못해서 error
//         return `${super.sayHi()}.how are you doing?`;
//     }
// };

console.log(derived.sayHi()); // Hi! Lee. how are you doing? 

 */

//화살표 함수
// const arrow = (x, y) => {...};
// const arrow = x => {...};
// const arrow = () => {...};

// const power = x => x * 2;
// power(2);  
// const arrow = () => const x = 1;


// const person = (name => ({
//     sayHi(){
//         return `Hi? My name is ${name}.`;
//     }
// }))('Lee');
// console.log(person.sayHi());



