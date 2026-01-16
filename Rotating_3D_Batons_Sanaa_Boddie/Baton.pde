class Baton {
  float x;
  float y;
  float z;
  float angle;
  float speed;
  float radius;
  
  Baton(float distance, float speed, float radius) {
    this.x = distance;
    this.y = random(80, 200);
    this.z = 0;
    this.angle = random(TWO_PI);
    this.speed = speed;
    this.radius = radius;
  }
  
  void update() {
    angle += speed;
  }
  
  void display() {
    float cx = cos(angle)*x;
    float sz = sin(angle)*x;
    pushMatrix();
    translate(cx, y, sz);
    fill(255, 0, 0);
    sphere(radius);
    popMatrix();
    
    pushMatrix();
    translate(-cx, -y, -sz);
    fill(0, 0, 255);
    sphere(radius);
    popMatrix();
    
    stroke(255);
    line(cx, y, sz, -cx, -y, -sz);
  }
}
