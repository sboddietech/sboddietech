Baton[] batons = new Baton[6];

void setup() {
  size(600, 600, P3D);
  for (int i = 0; i < batons.length; i++) {
    batons[i] = new Baton(random(80, 200), random(0.01, 0.04), random(15, 30));
  }
}

void draw() {
  background(0);
  lights();
  translate(width/2, height/2, 0);
  fill(255, 255, 0);
  sphere(50);
  
  for (Baton b : batons) {
    b.update();
    b.display();
  }
}
