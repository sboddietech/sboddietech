class Planet{
  float speed;
  float distance;
  float radius;
  float theta;
  color c;
  int numofMoons;
  Moon [] moons;
  
  Planet(float speed, float distance, float radius, color c, int numofMoons){
    this.speed = speed;
    this.distance = distance;
    this.radius = radius;
    this.c = c;
    this.numofMoons = numofMoons;
    moons = new Moon[numofMoons];
    
    for(int i = 0; i<numofMoons; i++){
      moons[i] = new Moon(random(0.1,0.4), random(30,40), random(5,10), color(0,random(200,255),random(200,255)));
    }
    theta = 0;
  }
  
  void display(){
      
      pushMatrix();
      fill(c);
      rotate(theta);
      translate(distance,0);
      //circle(0,0,radius);
      sphere(radius);
      for(int i = 0; i<numofMoons; i++){
        moons[i].orbit();
        moons[i].display();
      }
      
      popMatrix();
  }
  
  void orbit(){
    theta = theta+speed;
  }
}
