Planet[] planets;

void setup(){
    size(600,600,P3D);
    planets = new Planet[5];
    for(int i = 0; i<planets.length; i++){
          planets[i] = new Planet(random(0.1,0.2), random(150,250), random(30,40), color(0,random(200,255),random(200,255)), (int)random(0,3));
    }
}


void draw(){
  background(255);
  noStroke();
  lights();
  
  fill(255,255,0);
  translate(width/2, height/2);
  sphere(80);

  for(int i = 0; i<planets.length; i++){
  planets[i].orbit();
  planets[i].display();
  }
}
