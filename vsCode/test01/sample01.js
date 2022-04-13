// ex2)
// console.log("Hello World!")
// console.log("호랑이");

// ex3) 
// console.log('');

// ex4) 
// var a = 10;
// console.log(a);

// let b = 20;
// console.log(b);

// const c = 30;
// console.log(c);

// ex5)
/* let a = 10;
let b = 'tiger';
let c = true;
let d = 3.14;
let e = [];
let f = {};
let g = function(){};
let h = undefined; // 객체가 아니다. 

console.log(typeof(b));
console.log(typeof(c));
console.log(typeof(d)); // number
console.log(typeof(e)); // object 객체 타입
console.log(typeof(f)); // object
console.log(typeof(g));
console.log(typeof(h)); // undefined */

// ex6)
/* let obj = {
    a:10,
    b:'tiger',
    c:true,
    d:[],
    e:{},
    f:function(){},
    g:undefined
}
console.log(typeof(obj)); // {} -> object
console.log(typeof(obj.a));
console.log(typeof(obj.b));
console.log(typeof(obj.c));
console.log(typeof(obj.d));
console.log(typeof(obj.e));
console.log(typeof(obj.f));
console.log(typeof(obj.g));
 */

// ex7)
/* let obj = {
    a:{
        b:{
            c:{
                d:10,
            },
        },
    },
}

let obj2 = {
    a:1000,
    b='tiger',
}

console.log(obj.a.b.c.d);
console.log(typeof(obj.a.b.c.d));
 */

// ex8)
/* let apple = 10;
// apple = new number(); // 메모리 생성
// 사용
// delete(apple) // 삭제
console.log(apple, typeof(apple));

// number 타입의 메모리가 삭제되고
// string 타입의 메모리가 생성된다.  -> 성능 떨어짐
// delete(apple)
// apple = new String();
apple = 'tiger';
// 숫자를 대입했다면 메모리 해제 후 요청이 필요없다. 
console.log(apple, typeof(apple));

// 동적 타입 변경 : 프로그램 실행 중에 타입이 변경
let b = 10;
b = 'lion';
b = function(){};
b = {};
console.log(typeof(b));
 */


// ex9)
/* {
    var a = 10;
}
console.log(a);

{
    let b = 10;
    console.log(b);    
}
// console.log(b);
 */

/* 
// ex10) const
const a = 10;
console.log(a);
a = 20;
console.log(a); 
*/


// ex11) undefined, null
/* 
let a = undefined; // 리턴값
return undefined; // 리턴값을 모를 경우
// return null // 객체를 리턴하는데 빈 객체일 경우 null
let b = null;
console.log(typeof(a));
console.log(typeof(b));

b = {}; 
*/

// ex12) 
/* let str = '호랑이';
str += '코끼리';
console.log(str);

let s = '100';
let n = 100;
console.log(s+n); // 문자열 연결
console.log(Number(s)+n);
console.log(String(n)+200); // String - 클래스 멤버함수 

console.log('---------------------------------------');

// 숫자로 변환
let s1 = '100원';
let s2 = '200원';
console.log(Number(s1) + 1);
console.log(parseInt(s2) + 1);


// 슈가 코드
let s3 = '10';
let s4 = +'10';
let s5 = +s3; // 양수화로 착각 가능
let s6 = 999 + +s3; 

console.log(typeof(s3));
console.log(typeof(s4));
console.log(typeof(s5));
console.log(s6);

 */


// ex13
/*
// java와 동일
// - 산술, 관계, 논리, 증가, 감소 연산 
// - 복합 대입 연산(+=)
// - true, false
// - 4대 제어문, 삼항연산

// **
console.log(Math.pow(2, 3));
console.log(2 ** 3);
// 예측1) 2의 3승 결과를 2승 
// = (2 **  3) ** 2 = 8 x 8 = 64
// 예측2) 2의 3승을 2승 = 2 ** ( 3 ** 2) = 2 ** 9 = 512
// 예측 2가 맞다.
console.log(2 ** 3 ** 2);
 */


// ex14
/*  let a = 10;
let b = 0X10; // 16진수 표기
let c = 0O777; // 8
let d = 0b1111011;
console.log(a);
console.log(b);
console.log(c);
console.log(d);

function apple(){
}

for (let i = 0; i < 3; i++) {
    console.log(i);
   
} 
 */ 
// ex15) 6장
/* console.log(10 == '10'); 
console.log(10 === '10'); 
console.log(10 === 10.0); 
console.log( 7 / 4 ); // 정확한 결과값
console.log( 7 % 4 );


console.log('한글');
console.log("한글'과'컴퓨터");
// 템플릿 리터럴
let t = 10;
console.log(`한${t}`);
 */

// ex16) 
/* let str = `<h3>호랑이</h3>`;

let first = 'tiger';
let last = 'lion';
console.log(`My name is ${first} and ${last}`); // 백틱
let a = 3;
let b = 4
console.log(`${a} + ${b} = ${a + b}`);
 */


// ex17)

// 1
// let obj1 = {
//     a : 10,
// };
// // 필요에 따라서 실행 시간에 키값을 추가할 수 있다. 
// obj1.b = 20;
// console.log(obj1.a);
// console.log(obj1.b);

// // 2
// let obj2 = {
//     a : 10,
// };
// obj2['b'] = 20;
// console.log(obj2['a']);
// console.log(obj2['b']);

// // 3. 라이브러리로 제공된 객체
// let obj3 = {
//     a : 10,
//     b : 20
// };
// // 키값을 새로 만드는지 기존 키의 값을 변경하는건지 모름
// obj3['b'] = 30;
// console.log(obj3['b']);
// console.log('----------');


// 4. 충돌 위험
// let obj4 = {
//     a : 10,
//     monkey : 20,
//     myfunc : function(){
//         return this.a + this.monkey;
//     }
// };

// obj4['monkey'] = 30;
// console.log(obj4.myfunc(), obj4['monkey']);

// // 5.  유일한 키 값 정의
// let obj5 = {
//     a : 10,
//     monkey : 20,
//     myfunc : function(){
//         return this.a + this.monkey;
//     }
// };

// let monkey = Symbol('monkey');
// // obj5['monkey'] = 999; // 이렇게 사용하면 충돌 위험
// obj5[monkey] = 999;
// console.log(obj5.myfunc());
// console.log(obj5['monkey']); // 원래의 키 값
// console.log(obj5[monkey]); // 심볼 키


// console.log('-------------');
// let obj6 = {
//     a : 20,
//     b : 30
//     // 함수가 사용하게 되었을 때 
//     // 실행시간으로 변경되는 결과에 대하여
//     // 어떻게 예측할 수 있는가?
// }
// // 중복된 속성을 변경할 수 있으니 symbol로 정의
// obj6['b'] = 10;

// console.log('-----------------');

// console.log(typeof obj5);
// console.log(4 > 5);

// let str = 'apple';
// console.log(str.length);




// 22일~~~
// ex18
/* let n = new Date();
console.log(typeof(n));
console.log(typeof n);
console.log(typeof(Date)); //function

console.log(n.getFullYear(), '년');
console.log(n.getMonth() + 1, '월');
console.log(n.getDate(), '일');
console.log(n.getDay(), '요일');

console.log(n.getHours(), '시');
console.log(n.getMinutes(), '분');
console.log(n.getSeconds(), '초');
 */

// ex19
/* 
let start = new Date().getTime();
console.log(start);
for (var i = 0; new Date().getTime() < start + 1000; i++) {
    
}
console.log(i);
// scope 범위 벗어나서 사용 가능
 */

// ex20
/* for (let i = 0; i < 3; i++) {}; // 원래 상태
for (let i = 0; i < 3; i++){} // 생략
for (let i = 0; i < 3; i++); // 생략 -> 다음문장과의 연관관계를 없다고 보여줌
// scope 닫힐 떄 ; 들어가는게 정석이었는데 ;생략 되었다.
 */

/* // 1번
let start = new Date().getTime();
console.log('start');
while (new Date().getTime() < start + 1000);
console.log('end');
 */

// 2번
/* function name(num){

}
(function(num){
    console.log(num); 
})(100);
 */

// 3번 시간 지연 함수
/* 
(function(num){
    console.log('시간 지연 시작', num / 1000, '초');
    let start = new Date().getTime();
    while (new Date().getTime() < start + num);
})(3000);

console.log('end'); 
*/


// ex21) 
/* if(true){
    console.log('100');
    
}
true && console.log('100'); // -> 짧은 if문, js에서 많이 사용

let num = 10;
num > 7 && console.log('100');

if(!(num > 10)){ // 이렇게 사용하는 경우 많다, 논리따질 때 부정연산자 사용
    console.log('20');    
}
false || console.log('30');
// (num > 10) || console.log('30');



if(true && num++){
}
console.log(num);

let num2 = 10;
if(false && num2++){ // risk가 큼, 사용하지 말기
}
console.log(num2);

 */


// ex22
/* // 1. 
f1(); // 함수를 호이스팅 할 수 있다. 
function f1(){
    console.log('1');
}

// 2.
let f2 = function(){
    console.log('2');
}
f2();

// 3.
let f3 = ()=>{
    console.log('3');
}; 
f3();

// 4
(function(){
    console.log('4');    
})();

// 5
()=>{}  
(()=>{})();  
(() => {
    console.log('5');    
})();


// 6. 람다 인수 전달
((num) => {
    console.log(num);    
})(6);

// 7
let result = ((num) => {
    return num * 10;  
})(7);
console.log(result);

((num) => {
    console.log(num * 10);
})(7);


// 8
function F4(){
    this.name = '호랑이'
    this.age = 100
    this.f1 = function(){ // 멤버 함수
        console.log(this.name);
    }
    this.f2 = () => {
        console.log(this.age);
        
    }
}

let obj = new F4(); // new Date() 처럼 사용
obj.f1();
obj.f2();
console.log(obj.name, obj.age);


// ex23
function t1(){
    console.log('1');
}
t1();

function t2(num){
    console.log(num);
}
t2(num);

function t3(){
    return 100;
}
console.log(t3());

function t4(num){
    return num * 10;
}
console.log(t4(20));
 */

// ex24) 
/* 
// 1. 
let count = {
    num: 0,
    increase: function(){
        this.num++;
        console.log(this.num);
        
    }
}
console.log(count.num);
count.increase();

// 2.
let person = {
    name: 'tiger',
    age: 100,
    salary: 2000,
    test : 3000,
    sayHello: function(){
        console.log(`${this.name}`);
    }
}
person.sayHello();
console.log(person);
console.log('end');

// 3.
let empty = {
}

// 4. 변수명을 quotation로 묶어 정의 - 변수명에 특수문자 포함인 경우 사용
let obj01 = {
    'name': 'tiger',
    'age': 10
}
console.log(obj01.name, obj01.age);

// 5
let obj02 = {};
let key = 'hello';
obj02[key] = 'world';
console.log(obj02.hello);
console.log(obj02);

// 6
let obj03 = {
    0 : 10,
    1 : 20,
    '2' : 30
}
console.log('-----------------------');
// console.log(obj03.0); // x
// console.log(obj03.'0'); // x
console.log(obj03[0]); // o
console.log(obj03['0']); // o



//7
let obj04 = {
    age:10,
    age:20
}
console.log(obj04);
console.log(obj04.age, obj04['age']);
// console.log(obj04[age]); // 익셉션 발생


// 8
// 속성 생성
let obj05 = {
    a:10,
};
// 속성 갱신
obj05.a = 20;

//속성 생성
obj05.b = 30;

//속성 삭제
delete obj05.a;

console.log(obj05);
console.log(obj05.a);
console.log(obj05.b);


// 9
let x = 3, y = 4;
let obj06 = {
    x:x, // 속성 : 값
    y:y,
}
console.log(obj06);

// 10 : xx: yy:를 생략할 수 있다.
let xx=5, yy=6;
let obj07 = {
    // xx:xx,
    // yy:yy,
    xx,
    yy,
}
console.log(obj07);


// 11 
let xxx=7, yyy=8;
let obj08 = { xxx,yyy,}
console.log(obj08);

// 12
let prefix = 'prop';
let cnt = 0;
let obj09 = {};
obj09['prop-0'] = 0;
obj09[prefix + '-' + ++cnt] = 0;
for (let i = 2; i < 5; i++) {
    obj09[prefix + '-' + i] = 0;
}
console.log(obj09);


// ex13) 
let obj10 = {
    [`${prefix}-${cnt}`]: 99,
}
console.log(obj10);

// 14
let obj11 = {
    // 일반 함수
    f1: function(){
        console.log('1');
    },
    f2(){
        console.log('2');
    }
}
obj11.f1();
let tt10 = new obj11.f1();
obj11.f2();
// let tt11 = new obj11.f2();

 */

//ex24
/* function f1(){
    console.log(typeof arguments); 
    console.log(arguments.length);

    let sum = 0;
    for (const key in arguments) {
        console.log(key, arguments[key]);
        sum += arguments[key]
    }
    console.log(sum);
}
// f1(10);
// f1(10, 20);
f1(77, 88, 99); */


// ex25
/*
// 1
let f1 = function(){
    console.log('1');
    let f2 = function(){
        console.log('2');
    }
    f2();
};
f1();

// 2 
let f3 = function(){
    console.log('1');
    return function(){
        console.log('2');
    }
};
f3()();

//3
let f4 = function(a, b){
    console.log('1');
    return function(c, d, e){
        console.log(c+d+e);
    }
};
f4(10,20)(10, 20, 30);


//4
let f5 = function(a){
    a();
    return function(c, d, e){
        c();
    }
};
f5(function(){
    console.log(99);
})(function(){
    console.log(100);
});


let f6 = function(a){
        a();
        return function(c, d, e){
        c();
        d();
        }
    };

f6(function(){
        console.log(99);
    })(function(){
        console.log(100); 
    },
    function(){
        console.log(101); 
    });
*/

// ex26

/* 
let f1 = function(cf){
    cf();
}

let f2 = function(cf){
    console.log('f2 call');
}

//1
f1( f2 );


//2
f1(function(){
    console.log('ex2');    
});

// 3
f1(() => {
    console.log('ex3');    
});

// 4
const f3 = function(){
    console.log('1');
    const f4 = function(){
        console.log('2');
    };
    // return f4(); -> return 이 아니라 함수를 call호출시킨 것이다. 주의하기
    return f4;    
};
f3()();


// 5
const f5 = function(){
    console.log('1');
    return function(){
        console.log('2');
    };    
};
f5()();



// ex27
// 1
(function(){
    console.log('1');
    return function(){
        console.log('2');        
    };
})()();

// 2.
(() => {
    console.log('1');
    return () => {
        console.log('2');        
    };
})()();

 
// 3. 
((cf1) => {
    cf1();
   
    return (cf2) => {
        cf2();
               
    };
})( ()=>{
    console.log('tiger');
    console.log('1');
} )( ()=>{
    console.log('lion');
    console.log('2'); 
} );

*/



//ex28
/* // 1. 
let c1 = function(a){return a*10;}
console.log(c1(2));
 
// 2. 
let c2 = (a) => {return a*10;}
console.log(c2(2));

// 3. 
let c3 = a => {return a*10;}
console.log(c3(2));

// 4.
let c4 = a =>  a*10;
console.log(c4(2));

// 5
let c5 = function(){
    // return 100;
    // return 'tiger';
    // return () => {};
    return { a : 10, b : 20}; // 객체
} 
let obj01 = c5();
console.log(obj01.a, obj01.b);


// 6
let c6 = () => {
    return { a : 10, b : 20}; 
} 

// 7
let c7 = () => ({ a : 30, b : 40});
let obj02 = c7();
console.log(obj02.a, obj02.b);
 */


// ex29)
/* // 1
(a) => {};

// 2
((a) => {})();

// 3
((a) => { 
    console.log(1);
    ((b) => {
        console.log(2); 
     })(); 
 })();

 // 4
((a) => {  ((b) => {})(); })();
// ((a) => {  ((b) => {})() })(); 가운데의 세미콜론 빼도 됨
// 5
((a) => {  ((b) => {console.log(a+b); })(10); })(20);
// 6
let c1 = (a) => {  (b) => {console.log(a+b); } };
//7
let c2 = (a) => {  (b) => {  } };
//8
let c3 = a => { b => { } };

//9
// let c4 = a => b => a + b;
// let c4 = (a) => (b) => a + b;
// let c4 = (a) => (b) => {return a + b; };
// let c4 = (a) => {return (b) => {return a + b; } };
let c4 = (a) => {
    return (b) => {
        return a + b; 
    } 
};
console.log(c4(10)(20)); */


//ex30)
/* let c1 = (a) => {
    return (b) => {
        return a + b; 
    } 
};
console.log(c1(1)(2));

let c2 = (a) => {
    return (b) =>  a + b; 
};
console.log(c2(1)(2));

let c3 = (a) => (b) =>  a + b;
console.log(c3(1)(2));

let c4 = a => b =>  a + b;
console.log(c4(1)(2));
 */





/////////////   3월 23일
// ex31
/* const f1 = function(){
    let a = 100;
    return function(){
        console.log(a);
    }
}
f1()(); */

// 32
// setTimeout(함수, 정수);
/* console.log('1'); // 우동
setTimeout(
    function(){
        console.log('2'); // 탕수육
    }, 2000);
console.log('3'); // 짜장
    

// 비동기 함수를 쓸 수 밖에 없는 상황일때 재보존해야한다.
{ 동기화
    setTimeout(
        function(){
            if(  ){
                login = true;
            }
            console.log('2'); 
        }, 2000);
}
// 

if(login === true){
    exit
} */


//33
// console.log('1');
// setInterval(
//     function(){
//         console.log('2'); 
//     }, 1000);
// console.log('3');

/* console.log('1');
let id = setInterval(
    () => {
        console.log('2'); 
    }, 1000);

setTimeout(
    () => {
        // 버튼이 클릭되었을 때
        clearInterval(id);
    },
    5600
)
console.log('3'); */


// 34
// console.log('test');

//1
// for(var i=0; i<3; i++){
//     setTimeout(
//         () => {
//             console.log(i);
            
//         },
//         1000
//     );
// }

//3
// for(let i=0; i<3; i++){
//     setTimeout(
//         () => {
//             console.log(i);           
//         },
//         1000
//     );
// }


//2
// for(var i=0; i<3; i++){
//     (num => {
//         setTimeout(
//             ()=>{
//                 console.log(num);
                
//             },1000
//         );    
//     })(i);
// }





// for(let i=0; i<5; i++){
//     setTimeout(
//         () => {
//             console.log(i);           
//         },
//         i * 1000
//     );
// }

//35 
/* let str = '';
str += 'let a = 10;'
str += 'console.log(a);'
eval(str);
 */
//'tiger'

//36
/*  let obj = {
    s:'tiger',
    n:10,
    b:true,
}
console.log(obj);
console.log(obj.s, obj.n, obj.b);
console.log(obj['s'], obj['n'],obj['b']);


// 출력 순서가 보장되지 않는다. 
for(const key in obj){
    console.log(key, obj[key]);
} 

// with 키워드
with(obj){
    console.log(s, n, b);
} */

// let c = 'dd';
// let apple = {
//     a:10,
//     b:'tiger',
//     [c]:30,
//     c: 20
// }
// console.log(apple);
// console.log(apple.c); // 20
// console.log(apple[c]); // 30
// // console.log(apple[dd]); //error



//37
/* const obj = {
    a:10,
    b:20,
    f1:function(){
        console.log(this.a,this.b);  // this 꼭 사용, 안하면 error
    },
    f2:()=>{
        console.log(this.a,this.b); // undefined undefined
    },
    f3:function(){
        for (const key in this) {
            console.log(key, this[key]);
        }
    }
};
obj.f1();
obj.f2();
obj.f3();

let c = 'dd';
let apple = {
    a:10,
    b:'tiger',
    [c]:30,
    c: 20
}
console.log(apple);

const obj01 = {
    a:10
}
obj01.b = 20;
obj01['c'] = 30;

for(let i=0; i < 3; i++){
    obj01['lion' + i] = i * 10;
}
console.log(obj01);
console.log('end');
 */

//38
/* const obj = {
    a:10,
    b:20,
};
console.log(obj);
console.log(Object.keys(obj));

let a = Object.keys(obj)
console.log(typeof a);
console.log(Array.isArray(a));
console.log(Array.isArray(obj));


console.log(Object.values(obj));
 */

//39
/* const obj01 = {
    a:10,
    b:20,
};

const obj02 = {
    b:30,
    d:40,
};

// 방법1
const obj03 = Object.assign(obj01, obj02);
console.log(obj03);

// 2
const obj04 = {...obj01, ...obj02};
console.log(obj04);

let apple = (banana) => {
    console.log(banana);
}
apple({...obj01, ...obj02});
 */

// 40
//1
/* let ar = [10, 20, 30]; 
console.log(ar);
console.log(ar.length);
console.log(typeof ar);
console.log(Array.isArray(ar));

//2
let br = Array();
console.log(br.length);

// 3
let cr = Array(10);
console.log(cr.length);

//4
let dr = Array(40, 50, 60);
console.log(dr);

let er = [10, 'tiger', true, [], {}, function(){}, undefined];
console.log(er);
 */

//ex40
/* let ar = [10, 20, 30];

// for in
for (const index in ar) { // key
    console.log(index, ar[index]);    
}

// for of - 값만 가져올 경우
for (const value of ar) {
    console.log(value);
}

// forEach 함수를 사용할 수 있다. 
// ar.forEach( 함수 );
// ar.forEach( function(){} );
console.log('');
ar.forEach( (v, i)=>{
    console.log(v, i);
    
} );


ar.map( (v, i) => {
    console.log(v,i);   
} );

console.log('');
// return 값 존재 -> 데이터 가공 후 생성
let br = ar.map( (value) => {
    console.log(value); 
    return value * 10;  
} );
console.log(br);
console.log(ar); // 원데이터는 변경X


let cr = ar.map( (value) => value * 10);
console.log(cr); */

// let ar = [10, 11, 12, 14];
// let br = ar.map( v=> v % 2 ? 'Odd' : 'Even');
// console.log(br);

//ex42
/* let ar = [
    {
        n:'tiger',
        a:10,
    }, 
    {
        n:'lion',
        a:20,
    },
    {
        n:'cat',
        a:30,
    },
];
console.log(ar);
for(const index in ar){
    console.log(ar[index].n, ar[index].a);
}
for (const v of ar) {
    console.log(v.n, v.a);
}
ar.forEach( (v,i) => {
    console.log(v);    
} );

let br = ar.map( (v,i) => {
    return v.n;    
} );
console.log(br);
 */


// ex43
// 1
/* let ar = [80, 20, 10, 15];
let str = ar.toString();
console.log(str, typeof str);

// 2
let date = new Date();
console.log(date);
console.log(date.toLocaleString);

// 3. 
ar.pop();
console.log(3, ar);

// 4. 
let num = ar.push(20);
console.log(4, ar, num);


let br = [77, 88, 99];
ar.push(br);
console.log(5, ar);
console.log(ar[4]);

// 5
let cr = [10, 20, 30];
let dr = [40, 50];
// cr.concat(40); 갱신안되니 새로운 변수 추가해서 return 값을 넣기
let er = cr.concat(40);
console.log(cr);
console.log(er);

let fr = cr.concat(dr);
console.log(fr);

fr = cr.concat([88, 99]);
console.log(fr);

// 6
let gr = ['tiger', 'lion', 'cat', 'dog'];
console.log(gr.join());
console.log(gr.join(' ~ '));

// 7
console.log(gr.reverse());
 
// 8
let t1 = gr.shift();
console.log(t1);
console.log(gr);

gr.unshift('rose')
console.log(gr);
 */

// ex44 ) 
// 주의: 우연히 정렬된다. 
/* let ar = [80, 20, 10, 15];
console.log(ar);
ar.sort();
console.log(ar);

let br = [52, 273, 103, 32];
console.log(br);
br.sort();
console.log(br);


let cr = [99, 52, 13, 42, 66, 21];
// cr.sort(정렬시키는 기준을 함수로 작성);
// a와 b를 이용해서 정렬 기준을 만든다. 
// 실제로 숫자가 들어오는게 아님
// cr.sort( (a,b) =>  a > b ? +1 : -1);
cr.sort( (a,b) =>  a - b );

cr.sort( (a,b) =>  b - a ); // 역순 정렬
console.log(cr);


let dr = [
    {
        n:30,
        s:'월',
    },
    {
        n:20,
        s:'화',
    },
    {
        n:10,
        s:'수',
    },
]

//a, b 로 객체가 들어옴
dr.sort( (a,b)=>{ // n 기준으로 순차정렬
    return a.s - b.s;
} );

console.log(dr);
console.log(''); 
*/


// ex45
/* let ar = [1, 2, 3, 4, 5, 6, 7, 8];
//              2 ~ 4-1 
// let br = ar.slice(start, end-1);
let br = ar.slice(2, 4);
console.log(br);

// splice(시작위치, 삭제수, 추가항목, 추가항목, .....)
let cr = [1, 2, 3, 99, 88, 77];
// cr.splice(1, 0, 4, 5, 6, 7);
cr.splice(2, 2, 4, 5, 6, 7); //1 2 4 5 6 7 88 77
console.log(cr);

// indexOf
let dr = ['lion', 'tiger', 'dog', 'cat','tiger'];
console.log(dr.indexOf('tiger')); // 1
console.log(dr.indexOf('tig')); // 0
console.log(dr.indexOf('tiger', 2)); // index=2번 부터 찾기
console.log('');
console.log(dr.lastIndexOf('tiger'));


let er = [1, 30, 39, 29, 10, 13];

// console.log(er.every( () => {} )); 
// 이렇게 해도 되지만 함수를 따로 만들고나서 함수명 넣어도 o
function f1(data){
    return data < 40;
}
function f2(data){
    return data < 0;
}
console.log(er.every(f1)); //true
console.log(er.some(f2)); //false

console.log('');

let fr=[1, 3, 5, 7];
console.log(fr.some( value => value % 2 === 0 ));

// 배열에서 map()
 */

//45
/* let ar = [1, 30, 39, 29, 10, 13];
console.log(ar.filter( v => v < 30 ));

let br = ar.filter( v => v < 30 );
console.log(br);

let cr = [
    'tiger',
    'lion',
    'dog',
    'cat',
    'rose',
];
// 3글자 이상
console.log(cr.filter( v=>{
    return v.length >= 4;
} ));
 */

// 46 reduce
/* let ar = [1, 2, 3];
result1 = ar.reduce((acc, cur, i) => {
    console.log(acc, cur, i);
    return acc + cur;
  }, 0);
  // 0 1 0
  // 1 2 1
  // 3 3 2
console.log(result1); // 6


result2 = ar.reduce((acc, cur, i) => {
    console.log(acc, cur, i);
    return acc + cur;
  });
  // 1 2 1
  // 3 3 2
console.log(result2);


result3 = ar.reduceRight((acc, cur, i) => {
    console.log(acc, cur, i);
    return acc + cur;
  }, 0);
  // 0 3 2
  // 3 2 1
  // 5 1 0
console.log(result3);


result4 = ar.reduce((acc, cur) => {
    acc.push(cur % 2 ? '홀수' : '짝수');
    return acc;
  }, []);
  console.log(result4);


result5 = ar.reduce((acc, cur) => {
    if (cur % 2) acc.push(cur);
    return acc;
  }, []);
  console.log(result5); // [1, 3]
*/






// ------------- 3월 24일 -------------------
// 46 reduce
// 1
/* let sum = [0, 1, 2, 3].reduce(function(a, c){
    console.log(a,c);
    return a + c;    
}, 0);
console.log(sum);

console.log(
    [0, 1, 2, 3].reduce((a, c) => a + c, 0)
);
 */
// 2
//  var sum = [{x: 1}, {x:2}, {x:3}].reduce(function (a, c) {
//     console.log(a, c);
//     return a + c.x;
// },0)
// console.log(sum)

// 3
// var flattened = [[0, 1], [2, 3], [4, 5]].reduce(
//     ( a, c ) => {
//         console.log(a, c);
//         return a.concat(c);
//     },[]
// );

// 4
// 뒤의 배열중에 10번 인덱스가 있나? - 데이터가 아님
// console.log(10 in [10, 20, 30, 40]);
// console.log(3 in [10, 20, 30, 40]); //true
// console.log('a' in {a:10, b:20}); //true


//5 굉장히 유명 - 정석 코드
// var names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
// var countedNames = names.reduce(function (allNames, name) {
//     (name in allNames) ? allNames[name]++ : allNames[name] = 1;
//     // allNames[name] = (name in allNames) ? allNames[name]++ : 1;
//     return allNames;
// }, {});
// // countedNames is:
// // { 'Alice': 2, 'Bob': 1, 'Tiff': 1, 'Bruce': 1 }
// console.log(countedNames);


// ex47
// 전에 한 내용, 람다는 this 사용 불가
/* let obj01 = {
    n:10,
    f1:function(){
        console.log(1);
        console.log(this.n);
    },
    f2:() => {
        console.log(2);
        console.log(this.n);
    }
}
// 이 코드는 window 상에서 돌아간다. 
// 람다의 this는 자신의 scope를 벗어난 window를 this로 본다. 
obj01.f1();
obj01.f2();

function Func(){ // 생성자 함수
    this.n = 10; 
    this.obj = {
        n:20,
        f1:function(){
            console.log(1, this.n); 
        },
        f2:() => {
            console.log(2, this.n); 
        },    
    };
}
let ins = new Func(); // 객체가 생성됨
ins.obj.f1(); // 20
ins.obj.f2(); // 10 
 */


// 48
/* function Func(name, age){
    // this.name = 'tiger';
    // this.age = 10;
    this.name = name;
    this.age = age;
    this.f1 = function(){
        console.log(this.name, this.age);
    };
}
let ins = new Func('lion',20);
ins.f1();  */

//49
//1
/* function f1(){
    return {
        a:10,
        f:function(){}
    }
}
let obj1 = f1();
let obj2 = f1();
console.log(obj1.f === obj2.f); // false 


function F1(){
    return {
        a:10,
        f:function(){}
    }
}
let ins1 = new F1();
let ins2 = new F1();
console.log(ins1.f === ins2.f); // false 

//3 
function F2(){
   this.a = 10;
}
F2.prototype.f = function(){};
let ins3 = new F2();
let ins4 = new F2();
console.log(ins3.f === ins4.f); //true
 */

//50
// 객체에서
/* let obj ={
    a:0,
};
obj.f1 = function(){
    console.log(1);
}
obj.f1();


// 생성자 함수에서
function F1(){
}
F1.prototype.f1 = function(){
    console.log(2);
};
let ins = new F1();
ins.f1();
 */
//51
//1
/* let obj0 = {name:'tiger0', n1:10, n2:60,};
let obj1 = {name:'tiger1', n1:20, n2:70,};
let obj2 = {name:'tiger2', n1:30, n2:80,};
let obj3 = {name:'tiger3', n1:40, n2:90,};
let obj4 = {name:'tiger4', n1:50, n2:10,};

let ar = [];
ar.push(obj0);
ar.push(obj1);
ar.push(obj2);
ar.push(obj3);
ar.push(obj4);

ar.forEach( (v, i) => {
    console.log(v.name, v.n1, v.n2);
} ) */

//2
/* let ar = [];
ar.push({name:'tiger0', n1:10, n2:60,});
ar.push({name:'tiger1', n1:20, n2:70,});
ar.push({name:'tiger2', n1:30, n2:80,});
ar.push({name:'tiger3', n1:40, n2:90,});
ar.push({name:'tiger4', n1:50, n2:10,});
ar.forEach( (v, i) => {
    console.log(v.name, v.n1, v.n2);
} ) */

//3
/* function makeInfo(name, n1, n2){
    return {
        name:name,
        n1:n1,
        n2:n2,
    }
}

let ar = [];
ar.push(makeInfo('tiger0', 10, 60));
ar.push(makeInfo('tiger1', 20, 70));
ar.push(makeInfo('tiger2', 30, 80));
ar.push(makeInfo('tiger3', 40, 90));
ar.push(makeInfo('tiger4', 50, 10));
ar.forEach( (v, i) => {
    console.log(v.name, v.n1, v.n2);
} ) */

// 4
/* function MakeInfo(name, n1, n2){
    this.name = name;
    this.n1 = n1;
    this.n2 = n2;
}

let ar = [];
ar.push(new MakeInfo('tiger0', 10, 60));
ar.push(new MakeInfo('tiger1', 20, 70));
ar.push(new MakeInfo('tiger2', 30, 80));
ar.push(new MakeInfo('tiger3', 40, 90));
ar.push(new MakeInfo('tiger4', 50, 10));
ar.forEach( (v, i) => {
    console.log(v.name, v.n1, v.n2);
} ) */

//5
/* function MakeInfo(name, n1, n2){
    this.name = name;
    this.n1 = n1;
    this.n2 = n2;
}
let ar = [];
ar.push(new MakeInfo('tiger0', 10, 60));
ar.push(new MakeInfo('tiger1', 20, 70));
ar.push(new MakeInfo('tiger2', 30, 80));
ar.push(new MakeInfo('tiger3', 40, 90));
ar.push(new MakeInfo('tiger4', 50, 10));

ar.forEach( (v, i) => {
    ar[i].sum = v.n1 + v.n2;
} );
ar.forEach( (v, i) => {
    console.log(v.name, v.n1, v.n2);
} ); */

// function Person(){
//     this.eyes = 2;
//     this.nose = 1;
// }

// Person.prototype.eyes = 2;
// Person.prototype.nose = 1;



// let kim = new Person();
// let park = new Person();

// park.eyes = 3;

// console.log(kim.eyes);
// console.log(park.eyes);




//6
// function MakeInfo(name, n1, n2){
//     this.name = name;
//     this.n1 = n1;
//     this.n2 = n2;
// }
// let ar = [];
// ar.push(new MakeInfo('tiger0', 10, 60));
// ar.push(new MakeInfo('tiger1', 20, 70));
// ar.push(new MakeInfo('tiger2', 30, 80));
// ar.push(new MakeInfo('tiger3', 40, 90));
// ar.push(new MakeInfo('tiger4', 50, 10));

// ar.forEach( (v, i) => {
//     ar[i].sum = v.n1 + v.n2;
// } );

// // 출력함수 생성
// MakeInfo.prototype.output = function(){
//     console.log(this.name, this.n1, this.n2); //MakeInfo하면  어떻게
// }

// for( const key in ar ){
//     ar[key].output();
// } 


// 6
/* function MakeInfo(name, n1, n2){
    this.name = name;
    this.n1 = n1;
    this.n2 = n2;
}
let ar = [];
ar.push(new MakeInfo('tiger0', 10, 60));
ar.push(new MakeInfo('tiger1', 20, 70));
ar.push(new MakeInfo('tiger2', 30, 80));
ar.push(new MakeInfo('tiger3', 40, 90));
ar.push(new MakeInfo('tiger4', 50, 10));

ar.forEach( (v, i) => {
    ar[i].sum = v.n1 + v.n2;
} );

// 출력함수 생성
MakeInfo.prototype.output = function(){
    console.log(this.name, this.n1, this.n2); //MakeInfo하면  어떻게
}

for( const key in ar ){
    console.log(ar[key]);
    ar[key].output();
} */



// 52
// 1
/* function Apple(){
    this.a = 10;    
}
function Banana(){
    this.b = 20;    
}

// 상속 코드
Banana.prototype = new Apple();
Banana.prototype.constructor = Banana;

const obj = new Banana();
console.log(obj.a, obj.b); */

//2
/* // apple 클래스 안에 query라는 속성이 존재
function Apple(){
    this.query = {
        name:'tiger',
        age:10,
    }   
}
function Banana(){
    this.request = {
        x:10,
        y:20,
    };    
}

// 상속 코드
Banana.prototype = new Apple();
Banana.prototype.constructor = Banana;

const ctx = new Banana();
console.log(ctx);
console.log(ctx.request);
console.log(ctx.query);
 */


//53
/* console.log(Math.PI);
console.log(Math.abs(-5)); // 5

console.log(Math.ceil(3.14)); // 4
console.log(Math.ceil(-3.14)); // -3

console.log(Math.floor(3.14)); // 3
console.log(Math.floor(-3.14)); // -4

console.log(Math.round(3.14)); // 3
console.log(Math.round(-3.14)); // -3

console.log(Math.round(3.5)); // 4
console.log(Math.round(3.499999999)); // 3
console.log(Math.round(-3.5)); // -3

console.log(Math.max(3, 5, 6, 7, 99, 88));
console.log(Math.min(3, 5, 6, 7, 99, 88));

console.log(Math.pow(3, 5));
 
console.log(Math.sqrt(4)); // 2
console.log(Math.sqrt(3)); // 1.7320..
console.log(Math.sqrt(3) * Math.sqrt(3)); // 2.999..

//sin(30º)
console.log(Math.sin(Math.PI * 30 / 180.0)); //0.4999..

function degreeToRadian(degree){
    return Math.PI * degree / 180.0;
}
console.log(Math.sin(degreeToRadian(30)));
console.log(' ');

for(let i = 0; i < 10; i++){
    // console.log(Math.random()); // 0~1
    // console.log(Math.random() * 10);
    console.log(Math.floor(Math.random() * 10)); 
}
*/

// 54
/* let obj1 = {
    a:10,
    b:'tiger',

};

// 직렬화 시킨다.
let str = JSON.stringify(obj1);
console.log(typeof str, str);
// 보낸다. 
// str은 네트워크 데이터 전송으로 사용된다. 

// 받았다. (역직렬화)
let obj2 = JSON.parse(str);
console.log(typeof obj2, obj2);
 */


// 56
//1
/* const obj = {
    name:'tiger',
    age:10,
}

// 비구조화 할당 문법 : 받는게 객체형식
// let {name, age} = obj; 
// console.log(name, age);

// //2
// function f1({name, age}){
//     console.log(name, age);
// }
// f1(obj);

//3
// const ar = [10, 20, 30];
// let [dog, cat, tiger] = ar;
// console.log(dog, cat, tiger);

//4
const obj2 = {
    name:'tiger',
    age:10,
}
// // name:aa >> rename이 일어난다. 
// let {name:aa, age:bb} = obj2;
// // console.log(name, age);
// console.log(aa, bb);

//5
function f1({name:aa, age:bb}){
    console.log(aa, bb);
}
f1(obj);


//6
const initalState = {
    post : {
        
    }
}

const payload = {
    data:{
        name:'tiger',
    }
}

const {data:post} = payload;
console.log(post);
console.log(post.name); */

//57
/* const a = 10;
const c = 30;
const obj = {
    a,
    b:20,
    c
}
console.log(obj); */

//58
/* function f1(a, b = 1000, c = 'tiger'){
    console.log(a, b, c);
}
f1(10);
f1(10, 2000);
f1(10, 2000, 'lion'); */



//다음주부터 시험 - 4지선다


// 





