
animation effect

to draw some frames by some circules

---
drawString(String str,int x,int y)
```
g.drawString("Hello World!", 20, 50);
```
drawLine(int x1, int y1, int x2, int y2)
```
g.drawLine(20,80,120,80);
```
drawOval(int x, int y, int width, int height )
```
g.drawOval(100,100,30,40);
```
drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
```
g.drawArc(200,100,40,40,45,135);
```
draw3DRect(int x, int y, int width, int height, boolean raised)
```
g.draw3DRect(300,100,40,30,true);
```
See API guide for the class Graphics for more examples:
https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Graphics2D.html