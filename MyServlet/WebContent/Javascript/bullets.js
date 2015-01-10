log('Bullet class loaded!');

var all_bullets = {};
var bullet_next_id = 1;

function Bullet(x,y,angle){
this.angle = angle;
this.x = x;
this.y = y;
this.id = bullet_next_id;
bullet_next_id++;
all_bullets[this.id] = this;
}

Bullet.prototype.draw = function () {
var angle = this.angle;
var x = this.x;
var y = this.y;

var size = 10;

var startX = x - size*Math.cos(angle);
var startY = y - size*Math.sin(angle);

var endX = x + size*Math.cos(angle);
var endY = y + size*Math.sin(angle);

c.beginPath();
c.moveTo(startX,startY);
c.lineTo(endX,endY);

c.strokeStyle = 'red';
c.stroke();
}
Bullet.prototype.move = function() {
var speed = 5;

this.x = this.x + speed * Math.cos(this.angle);
this.y = this.y + speed * Math.sin(this.angle);

if(this.x < 0 || this.x > WIDTH || this.y > HEIGHT ||this.y<0) {
this.remove();
}
}

Bullet.prototype.remove = function() {
delete all_bullets[this.id];
}

Bullet.drawAll = function() {
for(id in all_bullets) {
all_bullets[id].draw();
}
}
Bullet.moveAll = function() {
for(id in all_bullets) {
all_bullets[id].move();
}
}
Bullet.removeAll = function() {
for(id in all_bullets) {
all_bullets[id].remove();
}
}
