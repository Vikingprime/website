log("SpaceShip class loaded");
var force= 0.1;
var maxspeed = 5;
var turn = 0.05;


function SpaceShip(x,y,angle){
this.angle=angle;
this.speed = 0;
this.x = x;
this.y = y;
}
SpaceShip.prototype.draw = function() {
var angle = this.angle;
var x = this. x;
var y = this.y;
var size = 15;

var headx = size*Math.cos(angle)+x;
var heady = size*Math.sin(angle)+y;

var leftx = size*Math.cos(angle-2.5)+x;
var lefty = size*Math.sin(angle-2.5)+y;

var rightx = size*Math.cos(angle+2.5)+x;
var righty = size*Math.sin(angle+2.5)+y;

c.beginPath();

c.moveTo(headx,heady);
c.lineTo(leftx,lefty);
c.lineTo(rightx,righty);
c.closePath();

c.strokeStyle = 'green';
c.stroke();

}
SpaceShip.prototype.move = function() {
this.speed *= 0.98;

this.x += this.speed*Math.cos(this.angle);
this.y += this.speed*Math.sin(this.angle);

if(this.x>WIDTH) {
this.x = 0;
}
if(this.x<0){
this.x = WIDTH;
}
if(this.y<0){
this.y = HEIGHT;
}
if(this.y>HEIGHT){
this.y = 0;
}
}
SpaceShip.prototype.speedUp = function() {
this.speed += force;
if(this.speed > maxspeed) {
this.speed = maxspeed;
}
}
SpaceShip.prototype.speedDown = function() {
this.speed -= 2*force;
if(this.speed<0){
this.speed = 0;
}
}
SpaceShip.prototype.turnLeft = function() {
this.angle -= turn;
}
SpaceShip.prototype.turnRight = function() {
this.angle += turn;
}
SpaceShip.prototype.shoot = function() {
new Bullet(this.x,this.y,this.angle);
}