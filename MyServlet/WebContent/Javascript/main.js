var log = console.log.bind(console);
log("Logging works! Bob said, \"hi\"");


var c, canvas;

var NORTH = 3 * Math.PI / 2;
var SOUTH = Math.PI / 2;
var EAST  = 0;
var WEST  = Math.PI;

var WIDTH  = 480;
var HEIGHT = 480;

var UP_KEY    = 38;
var DOWN_KEY  = 40;
var LEFT_KEY  = 37;
var RIGHT_KEY = 39;
var SPACE_KEY = 65;

var keys = {};


var ship;

window.onload = init;
window.onkeydown = keyPress;
window.onkeyup = keyRelease;


function init() {
log("Window is Loaded!");
canvas = document.getElementById("myCanvas");
c= canvas.getContext("2d");

log("My canvas: " + canvas);
log("My context:" + c);

 ship = new SpaceShip(100,100,NORTH);
 //new Bullet(200,300,NORTH);
    animate();
}
function animate() {
	window.addEventListener("keydown", function(e) {
	    // space and arrow keys
	    if([32, 37, 38, 39, 40].indexOf(e.keyCode) > -1) {
	        e.preventDefault();
	    }
	}, false);
 log(keys);
    if (keys[UP_KEY]) {
       ship.speedUp();
    }
 
    if (keys[DOWN_KEY]) {
        ship.speedDown();
    }
   if (keys[RIGHT_KEY]) {
        ship.turnRight();
    }
    if (keys[LEFT_KEY]) {
        ship.turnLeft();
    }
	if(keys[SPACE_KEY]){
	ship.shoot();
	}
  ship.move();
 Bullet.moveAll();
    c.clearRect(0, 0, WIDTH, HEIGHT);
Bullet.drawAll();
    ship.draw();
    window.requestAnimationFrame(animate);
 
}
 
function drawLine(){
c.beginPath();
c.moveTo(20,20);
c.lineTo(300,100);
c.strokeSytle = 'red';
c.stroke();
}
function keyPress(event) {
    keys[event.which] = true;
  //  log("Press: " + event.which);
}
 
function keyRelease(event) {
    delete keys[event.which];
    log("Release: " + event.which);
}
function drawShip(x, y, angle) {
 
    var size = 15;
 
    var headx = size * Math.cos(angle) + x;
    var heady = size * Math.sin(angle) + y;
 
    var leftx = size * Math.cos(angle - 2.5) + x;
    var lefty = size * Math.sin(angle - 2.5) + y;
 
    var rightx = size * Math.cos(angle + 2.5) + x;
    var righty = size * Math.sin(angle + 2.5) + y;
 
    c.beginPath();
 
    c.moveTo(headx, heady);
    c.lineTo(leftx, lefty);
    c.lineTo(rightx, righty);
    c.closePath();
 
    c.strokeStyle = 'green';
    c.stroke();
	}