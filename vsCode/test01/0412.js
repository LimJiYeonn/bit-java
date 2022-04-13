function f1( a, b ){
    let t = a; 
    a = b;
    b = t;
    return {a, b};
}

var a=10, b=20;
f1(a,b);
// console.log(f1( a, b )); 
// [a, b] = f1( a, b ); // 안돼...

// console.log(typeof f1( a, b ));
// console.log(typeof [a, b]);


console.log('출력1 : ', a, b);

let c=10, d=20;
[c, d] = [d, c];
console.log('출력2 : ', c, d);