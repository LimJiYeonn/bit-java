// 417p 25장 클래스

// ex1)
//1
// 생성자 함수 : 클래스로도 가능하다. 

/* function Person(name){
    this.name = name;
}
//함수 생성 : 안에서 하면 중첩, 밖에서 하면 싱글로 만들어짐
Person.prototype.f1 = function(){
    console.log(this.name);
}

let p = new Person('tiger');
p.f1(); */

//3
// function(){
// }

// (function(){
// })();

/* let Person2 = (function(){
    function Person(name){
        this.name = name;

        // f1 : 내부 생성자 함수
        Person.prototype.f1 = function(){
            console.log(this.name);
        }
    }
    return Person;
})();

let p = new Person2('tiger');
p.f1(); */

//4
/* class Person{
    constructor(){
        console.log(1);
    }
}

let p = new Person();
 */
// 5
/* class Person{
    // 방법2 - 문법자체가 나온지 얼마 안 되었다. 
    n3 = 30; //public 이다.
    constructor(n2){
        console.log(1);
        // 방법1
        this.n1 = 10;
        this.n2 = n2; // 주입
    }
}

let p = new Person(20);
console.log(p.n1, p.n2, p.n3); */


//6
/* class Person{
    n3 = 30;
    constructor(n2){
        console.log(1);
        this.n1 = 10;
        this.n2 = n2; 
    }
    // .프로토타입.함수이름 과 동격, 컴파일시 .프로토타입.함수이름로 바뀜
    f1(){
        // this 생략 불가
        console.log(this.n1, this.n2, this.n3);
    }
}

let p = new Person(20);
p.f1();
 */

//7
/* class Person{
    n3 = 30;
    static n4 = 20;
    constructor(n2){
        console.log(1);
        this.n1 = 10;
        this.n2 = n2; 
    }

    f1(){
        console.log(this.n1, this.n2, this.n3);
    }

    static f2(){
        // 필드 사용 불가
        console.log('static f2 call', this.n4);
    }
}

let p = new Person(20);
p.f1();
Person.f2();
console.log(Person.n4);
 */

//7-1
/* function Person(){
    Person.prototype.f1 = function(){
        console.log('1');
    };//prototype 함수
    Person.f2 = function(){
        console.log('2');
    }; // static 함수
}
let p = new Person();
p.f1();
Person.f2(); */



// 8 class의 rename
/* let Person2 = class Person{}
// let p1 = new Person(); // error 발생
let p1 = new Person2(); // 정상 작동 */

//9
/* class Person{
    a = 10;
    b = 20;
    constructor(){
        this.a = 1,
        this.b = 2
        // 생략된 코드
        // return this; //person객체가 리턴
        // return {}; // {}   비어있는 객체가 return 된다. Person객체가 아니라
        // return 100; // -> return this로 변환됨
        // return {a:10, b:20};
    }
}
let p = new Person();
console.log(p);
 */

// 10-1
/* class Square1{
    static area(w, h){
        return w * h;
    }
}
console.log(Square1.area(3, 4));

//10-2
class Square2{
    constructor(w, h){
        this.w = w;
        this.h = h;
    }
    area(){
        return this.w * this.h;
    }
}
let p = new Square2(3, 4)
console.log(p.area(3, 4));
 */
// Math. 가 static이기 때문에 이렇게 사용가능


//11 - 438p
/* class Person{
    constructor(firstName, lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    get fullName(){
        console.log('fullName');
        return `${this.firstName} ${this.lastName}`;
    }

    set fullName(name){
        // [] = name.split(' ') // space 기준으로 분리하여 배열에 넣기
        [this.firstName, this.lastName] = 
            name.split(' ') 
    }
}

const p = new Person('while', 'tiger');
console.log(p.fullName); // 괄호 열고 닫고 하지 않음 
console.log(p.firstName, p.lastName); 
console.log(`${p.firstName} ${p.lastName}`);

p.fullName = 'red lion';
console.log(p.fullName);
 */

/* class Person{
    name = 'Lee';
}
const me = new Person('Lee');
console.log(me); */

//ex13)
/* class Person{
    // # 을 붙이면 private 
    #name = 'tiger';
    constructor(name){
        this.#name = name;
    }
}
let p = new Person('lion');
console.log(p.name); */

// 13 - 2
/* class Person{
    constructor(name){
        this.#name = name;
    }

    
    #name = 'tiger';
    get name(){ 
        // get 함수 안에서 가변적인 코드가 추가될 수 있다. 
        // name 이라는 이름을 가공할 수 있다. 
        return this.#name.trim();
    }

    #age = 10;
    get age(){
        return this.#age;
    }
}
let p = new Person('     lion       ');
console.log(p.name); */

// ex14
/* class Animal{
    f1(){
        return 'f1';
    };
    f3(){
        return 'Animal f3';
    };
}
class Bird extends Animal{
    f2(){
        return 'f2';
    };
    f3(){
        return 'Bird f3';
    };
}
let b = new Bird();
console.log(b.f1());
console.log(b.f2());
console.log(b.f3()); */

// 15 - 1
/* class Base{
    constructor(a, b){
        console.log(a,b);
        this.a = a;
        this.b = b;
    }
}
class Derived extends Base{
    // default 코드이다. 
    // constructor(...args){
    //     super(...args);
    //     // console.log(2);
    // }
}

new Derived();
new Derived(3);
new Derived(3,4); */

//15-2
/* class Base{
    constructor(a, b){
        console.log(a,b);
        this.a = a;
        this.b = b;
    }
}
class Derived extends Base{
    constructor(a, b, c){
        super(a, b + c);
    }
}

new Derived(3); // 3 Nan
new Derived(3, 4); // 3 Nan
new Derived(3, 4, 5); // 3 9
 */

/* class MyArray extends Array{
    uniq(){
        return this.filter(
            (v, i, self) => {
                console.log(v, i, self);
                self.indexOf(v) === i;
            }
        );
    }

    average(){
        console.log(this.length);
        return this.reduce( (p, c) => {
            return p + c;
        },0 ) / this.length;
    }
}
const ar = new MyArray(1, 1, 2, 2, 3, 3, 3);
console.log(ar.uniq());
console.log(ar.average()); */
