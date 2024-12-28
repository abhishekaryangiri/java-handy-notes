/**
 * 
 */
function abc(){
	console.log(abc.xyz)
}
abc()
abc.xyz=500;
abc.xyz=100
abc()

/*output: 
undefined
100*/