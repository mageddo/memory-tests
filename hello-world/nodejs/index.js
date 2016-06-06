var started = new Date().getTime();
var crypto = require('crypto');
var fs = require('fs'); 
var util = require('util'); 
var filename = 'foo'+crypto.randomBytes(4).readUInt32LE(0)+'bar';
var wstream = fs.createWriteStream(filename);

console.log('started');
console.log('writing to ', filename);
for(var i=100000; i > 0; i--){
	var str = util.format("linha de teste: %s", new Date().getTime());
	wstream.write(str);
}
wstream.end(function(){
	console.log(util.format("file writed in %d", (new Date().getTime() - started) / 1000.0));
	fs.unlinkSync(filename);
	setTimeout(function(){
		console.log('exited');
	}, 60 * 1000 * 60);
});

