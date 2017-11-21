package com.civilization.otherscript;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ImageDragTest extends JPanel
{
    static int frame_width = 600;
    static int frame_height = 300;
        
    PicPanel pic = null;
    private int pic_x;
    private int pic_y;
    
    //前一个位置
    int begin_x = 0;
    int begin_y = 0;
    
    boolean inThePic = false;
    

    public ImageDragTest()
    {
        pic = new PicPanel("source/otherScript/ImageDragTest/pic.jpg");
        setLayout(null);
        add(pic);
        
        pic_x = (int)((frame_width - pic.getWidth())/2);
        pic_y = (int)((frame_height - pic.getHeight())/2);
        
        pic.setLocation(pic_x, pic_y);  //定位
        
        //鼠标动作 监听器 注册
        addMouseListener(
            new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    //检测 落点 是否在图片上,只有落点在图片上时 才起作用
                    if(inPicBounds(e.getX(), e.getY()))
                    {
                        begin_x = e.getX();
                        begin_y = e.getY();
                        inThePic = true;
                    }
                    //记录当前坐标
                }
                //释放
                public void mouseReleased(MouseEvent e)
                {
                    inThePic = false;
                }
            }
        );
        
        //鼠标移动 监听器 注册
        addMouseMotionListener(
            new MouseMotionAdapter()
            {
                public void mouseDragged(MouseEvent e)
                {
                    if(inThePic && checkPoint(e.getX(),e.getY()))
                    {
                        //边界 检查
                        pic_x =pic_x - (begin_x - e.getX());
                        pic_y =pic_y - (begin_y - e.getY());
                        //System.out.println("pic_x=" + pic_x);
                        begin_x = e.getX();
                        begin_y = e.getY();
                        pic.setLocation(pic_x, pic_y);
                    }
                }
            }
        );
    }
    //-------------帮助方法-----------------//
    //检测 点(px,py) 是否在图片上
    private boolean inPicBounds(int px,int py)
    {
        if(px >= pic_x && px <= pic_x + pic.getWidth() &&
                            py >= pic_y && py <= pic_y + pic.getHeight())
            return true;
        else
            return false;
    }
    
    //越界 检查
    private boolean checkPoint(int px, int py)
    {
        if(px <0 || py <0)
            return false;
        if(px >getWidth() || py > getHeight())
            return false;
        return true;
    }
        
    public static void main(String[] args)
    {
        JPanel jpanel = new ImageDragTest();
        JFrame jframe = new JFrame("图片拖动");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().add(jpanel);
        jframe.setSize(frame_width, frame_height);
        jframe.setVisible(true);
    }
}
//图片面板,只是用来放置图片
class PicPanel extends JPanel
{
    int p_width = 0;
    int p_height = 0;
    Image im = null;
    
    int i = 0; //temp var
    public PicPanel(String picName)
    {
        ImageIcon imageIcon = new ImageIcon(picName);
        im = imageIcon.getImage();
        
        p_width = imageIcon.getIconWidth();
        p_height = imageIcon.getIconHeight();
        setBounds(0,0,p_width, p_height);
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(im,0,0,p_width,p_height,null);
    }
}