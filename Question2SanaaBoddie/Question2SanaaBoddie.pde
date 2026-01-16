int buttonX, buttonY, diameter;
color c, backgroundColor;

void setup() {
  size(400, 400); 
  buttonX = width / 2; 
  buttonY = height / 2;  
  diameter = 50;  
  c = color(0, 0, 140);  
  background(255);
}

void draw() {
  background(backgroundColor);  
  
  float center = dist(mouseX, mouseY, buttonX, buttonY);
  if(center < diameter / 2){
    c = color(170, 220, 230);  
  }else{
    c = color(0, 0, 140);  
  }
  
  fill(c);
  ellipse(buttonX, buttonY, diameter, diameter);
}

void mousePressed() {
  float center = dist(mouseX, mouseY, buttonX, buttonY);
  if (center< diameter/2) {
    backgroundColor = color(random(255), random(255), random(255));

    diameter = diameter+ 10;
    if (diameter > 100) {
      diameter = 50;  
    }
  }
}

void keyPressed() {
  backgroundColor = color(255);
}
