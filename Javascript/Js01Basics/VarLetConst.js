/*for(let i=0;i<5;i++){
	console.log(i);
}
console.log(i);
*/

/*let i = 0;
do {
  console.log(i);
  i++;
} while (i < 5);*/


let person = { name: "Alice", age: 25 };
for (let key in person) {
  console.log(key, person[key]);
}