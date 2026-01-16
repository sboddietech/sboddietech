class Moon{
  float speed;
  float distance;
  float radius;
  float theta;
  color c;

  Moon(float speed, float distance, float radius, color c){
    this.speed = speed;
    this.distance = distance;
    this.radius = radius;
    this.c = c;
   
    theta = 0;
  }
  
  void display(){
      
      pushMatrix();
      fill(c);
      rotate(theta);
      translate(distance,0);
      sphere(radius);        
        
      popMatrix();
  }
  
  void orbit(){
    theta = theta+speed;
  }
}
