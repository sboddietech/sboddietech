Rectangle[] rectangles;

void setup(){
  size(600,600);
  rectangles = new Rectangle[5];
  for(int i = 0; i<rectangles.length; i++){
    rectangles[i] = new Rectangle(0,random(100,400), random(50,100), random(50,100), random(1,5), color(random(0,255), random(0,255), random(0,255)));
  }
}

void draw(){
  background(255);
  for(int i = 0; i<rectangles.length; i++){
    rectangles[i].display();
    rectangles[i].move();
  }
}
