class Rectangle{
  float x;
  float y;
  float w;
  float h;
  float speed;
  color c;
  
  Rectangle(float x, float y, float w, float h, float speed, color c){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.speed = speed;
    this.c = c;
  }
  
  void display(){
    fill(c);
    rect(x, y, w, h);
  }
  
  void move(){
    x = x+speed;
    if(x>550|| x < 0){
      speed = -speed;
    }
  }
}
