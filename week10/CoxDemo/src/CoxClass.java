/**
 * 文件名：CoxClass.java
 * 功能描述：
 */
import javax.swing.*;
import java.awt.*;

public class CoxClass extends JApplet
{
    int x,y;

    public void init()
    {
        //画画之前，必须先取得画笔
        Graphics g=getGraphics();
        //画x轴、y轴
        for(x=0;x<=750;x+=1)
        {
            g.drawString("·",x,200);
            if(x<=385) g.drawString("·",360,x);
        }
        g.drawString("Y",330,20);
        //画y轴箭头
        for(x=360;x<=370;x+=1)
        {
            g.drawString("·",x-10,375-x);
            g.drawString("·",x,x-355);
        }
        //画x轴箭头
        g.drawString("X",735,230);
        for(x=740;x<=750;x+=1)
        {
            g.drawString("·",x,x-550);
            g.drawString("·",x,950-x);
        }
        //画cox()曲线
        for(x=0;x<=720;x+=1)
        {
            double a=Math.cos(x*Math. PI/180+Math.PI);
            y=(int)(200+80*a);				//放大80倍并向下平移200个像素
            g.drawString("·",x,y);
        }
    }
}