package p;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;
import java.math.*;
import java.awt.Toolkit;

public class main extends Applet implements Runnable {

    int[] uprequest;
    int[] downrequest;
    elevator e[] = new elevator[4];
    private Image i;
    private Graphics doubleG;
    // elevator e1;
    Button b11, b12, b13, b14, b15, b16, b17, b18, b19, b110, b1o, b1c, b1add, b1sub, b21,
            b22, b23, b24, b25, b26, b27, b28, b29, b210, b2o, b2c, b2add, b2sub, b31, b32,
            b33, b34, b35, b36, b37, b38, b39, b310, b3add, b3sub, b3o, b3c, b41, b42, b43,
            b44, b45, b46, b47, b48, b49, b410, b4o, b4c, b4add, b4sub;
    Button b0u, b0d, b1u, b1d, b2u, b2d, b3d, b3u, b4u, b4d, b5u, b5d, b6d,
            b6u, b7u, b7d, b8u, b8d, b9u, b9d;
    Button bpoweron, bpoweroff;

    //it starts first 

    public void init() {
        // e1 = new elevator();
        e[0] = new elevator();
        e[1] = new elevator();
        e[2] = new elevator();
        e[3] = new elevator();

        uprequest = new int[10];
        downrequest = new int[10];

        // for gui
        setSize(1500, 1500);
        setBackground(Color.gray);
        //elevators button
        b11 = new Button("0");
        b21 = new Button("0");
        b31 = new Button("0");
        b41 = new Button("0");
        b12 = new Button("1");
        b22 = new Button("1");
        b32 = new Button("1");
        b42 = new Button("1");
        b13 = new Button("2");
        b23 = new Button("2");
        b33 = new Button("2");
        b43 = new Button("2");
        b14 = new Button("3");
        b24 = new Button("3");
        b34 = new Button("3");
        b44 = new Button("3");
        b15 = new Button("4");
        b25 = new Button("4");
        b35 = new Button("4");
        b45 = new Button("4");
        b16 = new Button("5");
        b26 = new Button("5");
        b36 = new Button("5");
        b46 = new Button("5");
        b17 = new Button("6");
        b27 = new Button("6");
        b37 = new Button("6");
        b47 = new Button("6");
        b18 = new Button("7");
        b28 = new Button("7");
        b38 = new Button("7");
        b48 = new Button("7");
        b19 = new Button("8");
        b29 = new Button("8");
        b39 = new Button("8");
        b49 = new Button("8");
        b110 = new Button("9");
        b210 = new Button("9");
        b310 = new Button("9");
        b410 = new Button("9");
        //open close button
        b1o = new Button("o");
        b2o = new Button("o");
        b3o = new Button("o");
        b4o = new Button("o");
        b1c = new Button("c");
        b2c = new Button("c");
        b3c = new Button("c");
        b4c = new Button("c");
        
        //up dowm button on floor
        b0u = new Button("u");
        b0d = new Button("d");
        b1u = new Button("u");
        b1d = new Button("d");
        b2u = new Button("u");
        b2d = new Button("d");
        b3u = new Button("u");
        b3d = new Button("d");
        b4u = new Button("u");
        b4d = new Button("d");
        b5u = new Button("u");
        b5d = new Button("d");
        b6u = new Button("u");
        b6d = new Button("d");
        b7u = new Button("u");
        b7d = new Button("d");
        b8u = new Button("u");
        b8d = new Button("d");
        b9u = new Button("u");
        b9d = new Button("d");
        
        //button for adding pepple
        b1add = new Button("+");
        b1sub = new Button("-");
        b2add = new Button("+");
        b2sub = new Button("-");
        b3add = new Button("+");
        b3sub = new Button("-");
        b4add = new Button("+");
        b4sub = new Button("-");
        bpoweron = new Button("Power on");
        bpoweroff = new Button("Power off");
        
        //setting there  
        b11.setBounds(900, 200, 40, 30);
        b12.setBounds(942, 200, 40, 30);
        b13.setBounds(984, 200, 40, 30);
        b14.setBounds(900, 232, 40, 30);
        b15.setBounds(942, 232, 40, 30);
        b16.setBounds(984, 232, 40, 30);
        b17.setBounds(900, 264, 40, 30);
        b18.setBounds(942, 264, 40, 30);
        b19.setBounds(984, 264, 40, 30);
        b110.setBounds(900, 296, 40, 30);
        b1o.setBounds(942, 296, 40, 30);
        b1c.setBounds(984, 296, 40, 30);
        b1add.setBounds(858, 232, 40, 30);
        b1sub.setBounds(858, 264, 40, 30);
        b21.setBounds(1100, 200, 40, 30);
        b22.setBounds(1142, 200, 40, 30);
        b23.setBounds(1184, 200, 40, 30);
        b24.setBounds(1100, 232, 40, 30);
        b25.setBounds(1142, 232, 40, 30);
        b26.setBounds(1184, 232, 40, 30);
        b27.setBounds(1100, 264, 40, 30);
        b28.setBounds(1142, 264, 40, 30);
        b29.setBounds(1184, 264, 40, 30);
        b210.setBounds(1100, 296, 40, 30);
        b2o.setBounds(1142, 296, 40, 30);
        b2c.setBounds(1184, 296, 40, 30);
        b2add.setBounds(1226, 232, 40, 30);
        b2sub.setBounds(1226, 264, 40, 30);
        b31.setBounds(900, 400, 40, 30);
        b32.setBounds(942, 400, 40, 30);
        b33.setBounds(984, 400, 40, 30);
        b34.setBounds(900, 432, 40, 30);
        b35.setBounds(942, 432, 40, 30);
        b36.setBounds(984, 432, 40, 30);
        b37.setBounds(900, 464, 40, 30);
        b38.setBounds(942, 464, 40, 30);
        b39.setBounds(984, 464, 40, 30);
        b310.setBounds(900, 496, 40, 30);
        b3o.setBounds(942, 496, 40, 30);
        b3c.setBounds(984, 496, 40, 30);
        b3add.setBounds(858, 432, 40, 30);
        b3sub.setBounds(858, 464, 40, 30);
        b41.setBounds(1100, 400, 40, 30);
        b42.setBounds(1142, 400, 40, 30);
        b43.setBounds(1184, 400, 40, 30);
        b44.setBounds(1100, 432, 40, 30);
        b45.setBounds(1142, 432, 40, 30);
        b46.setBounds(1184, 432, 40, 30);
        b47.setBounds(1100, 464, 40, 30);
        b48.setBounds(1142, 464, 40, 30);
        b49.setBounds(1184, 464, 40, 30);
        b410.setBounds(1100, 496, 40, 30);
        b4o.setBounds(1142, 496, 40, 30);
        b4c.setBounds(1184, 496, 40, 30);
        b4add.setBounds(1226, 432, 40, 30);
        b4sub.setBounds(1226, 464, 40, 30);
        b0u.setBounds(30, 525, 20, 20);
        b0d.setBounds(50, 525, 20, 20);
        b1u.setBounds(30, 475, 20, 20);
        b1d.setBounds(50, 475, 20, 20);
        b2u.setBounds(30, 425, 20, 20);
        b2d.setBounds(50, 425, 20, 20);
        b3u.setBounds(30, 375, 20, 20);
        b3d.setBounds(50, 375, 20, 20);
        b4u.setBounds(30, 325, 20, 20);
        b4d.setBounds(50, 325, 20, 20);
        b5u.setBounds(30, 275, 20, 20);
        b5d.setBounds(50, 275, 20, 20);
        b6u.setBounds(30, 225, 20, 20);
        b6d.setBounds(50, 225, 20, 20);
        b7u.setBounds(30, 175, 20, 20);
        b7d.setBounds(50, 175, 20, 20);
        b8u.setBounds(30, 125, 20, 20);
        b8d.setBounds(50, 125, 20, 20);
        b9u.setBounds(30, 75, 20, 20);
        b9d.setBounds(50, 75, 20, 20);
        bpoweron.setBounds(942, 70, 126, 30);
        bpoweroff.setBounds(1070, 70, 124, 30);

		// addKeyListener(this);
        // b11.addActionListener(this);
        // b12.addActionListener(this);
        // b13.addActionListener(this);
        // addMouseMotionListener(this);
        // addMouseWheelListener(this);
        b0u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[0] == 0) {
                    System.out.println("b0u");
                    assignfromouter(0, 'u');
                    uprequest[0] = 1;

                }

            }
        });
        b1u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (uprequest[1] == 0) {
                    System.out.println("b0u");
                    assignfromouter(1, 'u');
                    uprequest[1] = 1;
                }

            }

        });
        b2u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (uprequest[2] == 0) {
                    assignfromouter(2, 'u');
                    uprequest[2] = 1;
                }

            }
        });
        b3u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[3] == 0) {
                    assignfromouter(3, 'u');
                    uprequest[3] = 1;
                }

            }
        });
        b4u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[4] == 0) {
                    assignfromouter(4, 'u');
                    uprequest[4] = 1;
                }

            }
        });
        b5u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[5] == 0) {
                    assignfromouter(5, 'u');
                    uprequest[5] = 1;
                }

            }
        });
        b6u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[6] == 0) {
                    System.out.println("u6");
                    assignfromouter(6, 'u');
                    uprequest[6] = 1;
                }

            }
        });
        b7u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[7] == 0) {
                    assignfromouter(7, 'u');
                    uprequest[7] = 1;
                }

            }
        });
        b8u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[8] == 0) {
                    assignfromouter(8, 'u');
                    uprequest[8] = 1;
                }

            }
        });
        b9u.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[9] == 0) {
                    assignfromouter(9, 'u');
                    uprequest[9] = 1;
                }

            }
        });
        b0d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[0] == 0) {
                    System.out.println("b0u");
                    assignfromouter(0, 'd');
                    uprequest[0] = 1;

                }

            }
        });
        b1d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (uprequest[1] == 0) {
                    System.out.println("b0u");
                    assignfromouter(1, 'd');
                    uprequest[1] = 1;
                }

            }

        });
        b2d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (uprequest[2] == 0) {
                    assignfromouter(2, 'd');
                    uprequest[2] = 1;
                }

            }
        });
        b3d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[3] == 0) {
                    assignfromouter(3, 'd');
                    uprequest[3] = 1;
                }

            }
        });
        b4d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[4] == 0) {
                    assignfromouter(4, 'd');
                    uprequest[4] = 1;
                }

            }
        });
        b5d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[5] == 0) {
                    assignfromouter(5, 'd');
                    uprequest[5] = 1;
                }

            }
        });
        b6d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[6] == 0) {
                    assignfromouter(6, 'd');
                    uprequest[6] = 1;
                }

            }
        });
        b7d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[7] == 0) {
                    assignfromouter(7, 'd');
                    uprequest[7] = 1;
                }

            }
        });
        b8d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[8] == 0) {
                    assignfromouter(8, 'd');
                    uprequest[8] = 1;
                }

            }
        });
        b9d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (uprequest[9] == 0) {
                    assignfromouter(9, 'd');
                    uprequest[9] = 1;
                }

            }
        });
        b11.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[0].current >= 0) {
                    e[0].addtomaxheap(0);
                    e[0].dir = 'd';
                }

            }
        });
        b12.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 1) {
                    e[0].addtominheap(1);
                    e[0].dir = 'u';
                }
                if (e[0].current > 1) {
                    e[0].addtomaxheap(1);
                    e[0].dir = 'd';
                }

            }
        });
        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 2) {
                    e[0].addtominheap(2);
                    e[0].dir = 'u';
                }
                if (e[0].current > 2) {
                    e[0].addtomaxheap(2);
                    e[0].dir = 'd';
                }
            }
        });
        b14.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[0].current <= 3) {
                    e[0].addtominheap(3);
                    e[0].dir = 'u';
                }
                if (e[0].current > 3) {
                    e[0].addtomaxheap(3);
                    e[0].dir = 'd';
                }
            }
        });
        b15.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 4) {
                    e[0].addtominheap(4);
                    e[0].dir = 'u';
                }
                if (e[0].current > 4) {
                    e[0].addtomaxheap(4);
                    e[0].dir = 'd';
                }
            }
        });
        b16.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 5) {
                    e[0].addtominheap(5);
                    e[0].dir = 'u';
                }
                if (e[0].current > 5) {
                    e[0].addtomaxheap(5);
                    e[0].dir = 'd';
                }
            }
        });
        b17.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 6) {
                    System.out.println("6");
                    e[0].addtominheap(6);
                    e[0].dir = 'u';
                }
                if (e[0].current > 6) {
                    System.out.println("6");
                    e[0].addtomaxheap(6);
                    e[0].dir = 'd';
                }
            }
        });
        b18.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 7) {
                    e[0].addtominheap(7);
                    e[0].dir = 'u';
                }
                if (e[0].current > 7) {
                    e[0].addtomaxheap(7);
                    e[0].dir = 'd';
                }
            }
        });
        b19.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 8) {
                    System.out.println("8");
                    e[0].addtominheap(8);
                    e[0].dir = 'u';
                }
                if (e[0].current > 8) {
                    System.out.println("8");
                    e[0].addtomaxheap(8);
                    e[0].dir = 'd';
                }
            }
        });
        b110.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current <= 9) {
                    e[0].addtominheap(9);
                    e[0].dir = 'u';
                }
                if (e[0].current > 9) {
                    e[0].addtomaxheap(9);
                    e[0].dir = 'd';
                }
            }
        });
        b21.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[1].current >= 0) {
                    e[1].addtomaxheap(0);
                    e[1].dir = 'd';
                }

            }
        });
        b22.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 1) {
                    e[1].addtominheap(1);
                    e[1].dir = 'u';
                }
                if (e[1].current > 1) {
                    e[1].addtomaxheap(1);
                    e[1].dir = 'd';
                }

            }
        });
        b23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 2)//&&e[1].findinminheap(2)==0)
                {
                    e[1].addtominheap(2);
                    e[1].dir = 'u';
                }
                if (e[1].current > 2)//&&e[1].findinmaxheap(2)==0)
                {
                    e[1].addtomaxheap(2);
                    e[1].dir = 'd';
                }
            }
        });
        b24.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[1].current <= 3)//&&e[1].findinminheap(3)==0)
                {
                    e[1].addtominheap(3);
                    e[1].dir = 'u';
                }
                if (e[1].current > 3)//&&e[1].findinmaxheap(3)==0)
                {
                    e[1].addtomaxheap(3);
                    e[1].dir = 'd';
                }
            }
        });
        b25.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 4)//&&e[1].findinminheap(4)==0)
                {
                    e[1].addtominheap(4);
                    e[1].dir = 'u';
                }
                if (e[1].current > 4)//&&e[1].findinmaxheap(4)==0)
                {
                    e[1].addtomaxheap(4);
                    e[1].dir = 'd';
                }
            }
        });
        b26.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 5)//&&e[1].findinminheap(5)==0)
                {
                    e[1].addtominheap(5);
                    e[1].dir = 'u';
                }
                if (e[1].current > 5)//&&e[1].findinmaxheap(5)==0)
                {
                    e[1].addtomaxheap(5);
                    e[1].dir = 'd';
                }
            }
        });

        b27.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 6)//&&e[1].findinminheap(6)==0)
                {
                    e[1].addtominheap(6);
                    e[1].dir = 'u';
                }
                if (e[1].current > 6)//&&e[1].findinmaxheap(6)==0)
                {
                    e[1].addtomaxheap(6);
                    e[1].dir = 'd';
                }
            }
        });
        b28.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 7)//&&e[1].findinminheap(7)==0)
                {
                    e[1].addtominheap(7);
                    e[1].dir = 'u';
                }
                if (e[1].current > 7)//&&e[1].findinmaxheap(7)==0)
                {
                    e[1].addtomaxheap(7);
                    e[1].dir = 'd';
                }
            }
        });
        b29.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 8)//&&e[1].findinminheap(8)==0)
                {
                    e[1].addtominheap(8);
                    e[1].dir = 'u';
                }
                if (e[1].current > 8)//&&e[1].findinmaxheap(8)==0)
                {
                    e[1].addtomaxheap(8);
                    e[1].dir = 'd';
                }
            }
        });
        b210.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current <= 9)//&&e[1].findinminheap(9)==0)
                {
                    e[1].addtominheap(9);
                    e[1].dir = 'u';
                }
                if (e[1].current > 9)//&&e[1].findinmaxheap(9)==0)
                {
                    e[1].addtomaxheap(9);
                    e[1].dir = 'd';
                }
            }
        });
        b31.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[2].current >= 0)//&&e[2].findinminheap(0)==0)
                {
                    e[2].addtomaxheap(0);
                    e[2].dir = 'd';
                }

            }
        });
        b32.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 1)//&&e[2].findinminheap(1)==0)
                {
                    e[2].addtominheap(1);
                    e[2].dir = 'u';
                }
                if (e[2].current > 1)//&&e[2].findinmaxheap(1)==0)
                {
                    e[2].addtomaxheap(1);
                    e[2].dir = 'd';
                }

            }
        });
        b33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 2)//&&e[2].findinminheap(2)==0)
                {
                    e[2].addtominheap(2);
                    e[2].dir = 'u';
                }
                if (e[2].current > 2)//&&e[2].findinmaxheap(2)==0)
                {
                    e[2].addtomaxheap(2);
                    e[2].dir = 'd';
                }
            }
        });
        b34.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[2].current <= 3)//&&e[2].findinminheap(3)==0)
                {
                    e[2].addtominheap(3);
                    e[2].dir = 'u';
                }
                if (e[2].current > 3)//&&e[2].findinmaxheap(3)==0)
                {
                    e[2].addtomaxheap(3);
                    e[2].dir = 'd';
                }
            }
        });
        b35.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 4)//&&e[2].findinminheap(4)==0)
                {
                    e[2].addtominheap(4);
                    e[2].dir = 'u';
                }
                if (e[2].current > 4)//&&e[2].findinmaxheap(4)==0)
                {
                    e[2].addtomaxheap(4);
                    e[2].dir = 'd';
                }
            }
        });
        b36.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 5)//&&e[2].findinminheap(5)==0)
                {
                    e[2].addtominheap(5);
                    e[2].dir = 'u';
                }
                if (e[2].current > 5)//&&e[2].findinmaxheap(5)==0)
                {
                    e[2].addtomaxheap(5);
                    e[2].dir = 'd';
                }
            }
        });

        b37.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 6)//&&e[2].findinminheap(6)==0)
                {
                    e[2].addtominheap(6);
                    e[2].dir = 'u';
                }
                if (e[2].current > 6)//&&e[2].findinmaxheap(6)==0)
                {
                    e[2].addtomaxheap(6);
                    e[2].dir = 'd';
                }
            }
        });
        b38.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 7)//&&e[2].findinminheap(7)==0)
                {
                    e[2].addtominheap(7);
                    e[2].dir = 'u';
                }
                if (e[2].current > 7)//&&e[2].findinmaxheap(7)==0)
                {
                    e[2].addtomaxheap(7);
                    e[2].dir = 'd';
                }
            }
        });
        b39.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 8)//&&e[2].findinminheap(8)==0)
                {
                    e[2].addtominheap(8);
                    e[2].dir = 'u';
                }
                if (e[2].current > 8)//&&e[2].findinmaxheap(8)==0)
                {
                    e[2].addtomaxheap(8);
                    e[2].dir = 'd';
                }
            }
        });
        b310.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current <= 9)//&&e[2].findinminheap(9)==0)
                {
                    e[2].addtominheap(9);
                    e[2].dir = 'u';
                }
                if (e[2].current > 9)//&&e[2].findinmaxheap(9)==0)
                {
                    e[2].addtomaxheap(9);
                    e[2].dir = 'd';
                }
            }
        });
        b41.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[3].current >= 0)//&&e[3].findinminheap(0)==0)
                {
                    e[3].addtomaxheap(0);
                    e[3].dir = 'd';
                }

            }
        });
        b42.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 1)//&&e[3].findinminheap(1)==0)
                {
                    e[3].addtominheap(1);
                    e[3].dir = 'u';
                }
                if (e[3].current > 1)//&&e[3].findinmaxheap(1)==0)
                {
                    e[3].addtomaxheap(1);
                    e[3].dir = 'd';
                }

            }
        });
        b43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 2)//&&e[3].findinminheap(2)==0)
                {
                    e[3].addtominheap(2);
                    e[3].dir = 'u';
                }
                if (e[3].current > 2)//&&e[3].findinmaxheap(2)==0)
                {
                    e[3].addtomaxheap(2);
                    e[3].dir = 'd';
                }
            }
        });
        b44.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[3].current <= 3)//&&e[3].findinminheap(3)==0)
                {
                    e[3].addtominheap(3);
                    e[3].dir = 'u';
                }
                if (e[3].current > 3)//&&e[3].findinmaxheap(3)==0)
                {
                    e[3].addtomaxheap(3);
                    e[3].dir = 'd';
                }
            }
        });
        b45.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 4)//&&e[3].findinminheap(4)==0)
                {
                    e[3].addtominheap(4);
                    e[3].dir = 'u';
                }
                if (e[3].current > 4)//&&e[3].findinmaxheap(4)==0)
                {
                    e[3].addtomaxheap(4);
                    e[3].dir = 'd';
                }
            }
        });
        b46.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 5)//&&e[3].findinminheap(5)==0)
                {
                    e[3].addtominheap(5);
                    e[3].dir = 'u';
                }
                if (e[3].current > 5)//&&e[3].findinmaxheap(5)==0)
                {
                    e[3].addtomaxheap(5);
                    e[3].dir = 'd';
                }
            }
        });

        b47.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 6)//&&e[3].findinminheap(6)==0)
                {
                    e[3].addtominheap(6);
                    e[3].dir = 'u';
                }
                if (e[3].current > 6)//&&e[3].findinmaxheap(6)==0)
                {
                    e[3].addtomaxheap(6);
                    e[3].dir = 'd';
                }
            }
        });
        b48.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 7)//&&e[3].findinminheap(7)==0)
                {
                    e[3].addtominheap(7);
                    e[3].dir = 'u';
                }
                if (e[3].current > 7)//&&e[3].findinmaxheap(7)==0)
                {
                    e[3].addtomaxheap(7);
                    e[3].dir = 'd';
                }
            }
        });
        b49.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 8)//&&e[3].findinminheap(8)==0)
                {
                    e[3].addtominheap(8);
                    e[3].dir = 'u';
                }
                if (e[3].current > 8)//&&e[3].findinmaxheap(8)==0)
                {
                    e[3].addtomaxheap(8);
                    e[3].dir = 'd';
                }
            }
        });
        b410.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current <= 9)//&&e[3].findinminheap(9)==0)
                {
                    e[3].addtominheap(9);
                    e[3].dir = 'u';
                }
                if (e[3].current > 9)//&&e[3].findinmaxheap(9)==0)
                {
                    e[3].addtomaxheap(9);
                    e[3].dir = 'd';
                }
            }
        });
        b1add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
				 //while(e[0].pn>6)
                //Toolkit.getDefaultToolkit().beep();
                if (e[0].pn <= 6) {
                    e[0].pn++;
                }

            }
        });
        b1sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[0].pn >= 1) {
                    e[0].pn--;
                }
            }
        });
        b2add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
				 //while(e[0].pn>6)
                //Toolkit.getDefaultToolkit().beep();
                if (e[1].pn <= 6) {
                    e[1].pn++;
                }

            }
        });
        b2sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[1].pn >= 1) {
                    e[1].pn--;
                }
            }
        });
        b3add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
				 //while(e[0].pn>6)
                //Toolkit.getDefaultToolkit().beep();
                if (e[2].pn <= 6) {
                    e[2].pn++;
                }

            }
        });
        b3sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[2].pn >= 1) {
                    e[2].pn--;
                }
            }
        });
        b4add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
				 //while(e[0].pn>6)

                if (e[3].pn <= 6) {
                    e[3].pn++;
                }

            }
        });
        b4sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                if (e[3].pn >= 1) {
                    e[3].pn--;
                }
            }
        });
        b1o.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[0].current_y == 45 || e[0].current_y == 95 || e[0].current_y == 145 || e[0].current_y == 195 || e[0].current_y == 245 || e[0].current_y == 295 || e[0].current_y == 345 || e[0].current_y == 395 || e[0].current_y == 445 || e[0].current_y == 495) {
                    {
                        if (e[0].dir == 'u' || e[0].dir == 's') {
                            e[0].addtominheap(e[0].current);
                        } else {
                            e[0].addtomaxheap(e[0].current);
                        }
                    }
                }
            }
        });
        b2o.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[1].current_y == 45 || e[1].current_y == 95 || e[1].current_y == 145 || e[1].current_y == 195 || e[1].current_y == 245 || e[1].current_y == 295 || e[1].current_y == 345 || e[1].current_y == 395 || e[1].current_y == 445 || e[1].current_y == 495) {
                    if (e[1].dir == 'u' || e[1].dir == 's') {
                        e[1].addtominheap(e[1].current);
                    } else {
                        e[1].addtomaxheap(e[1].current);
                    }
                }
            }
        });
        b3o.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[2].current_y == 45 || e[2].current_y == 95 || e[2].current_y == 145 || e[2].current_y == 195 || e[2].current_y == 245 || e[2].current_y == 295 || e[2].current_y == 345 || e[2].current_y == 395 || e[2].current_y == 445 || e[2].current_y == 495) {
                    if (e[2].dir == 'u' || e[2].dir == 's') {
                        e[2].addtominheap(e[2].current);
                    } else {
                        e[2].addtomaxheap(e[2].current);
                    }
                }
            }

        });
        b4o.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                if (e[3].current_y == 45 || e[3].current_y == 95 || e[3].current_y == 145 || e[3].current_y == 195 || e[3].current_y == 245 || e[3].current_y == 295 || e[3].current_y == 345 || e[3].current_y == 395 || e[3].current_y == 445 || e[3].current_y == 495) {
                    if (e[3].dir == 'u' || e[3].dir == 's') {
                        e[3].addtominheap(e[3].current);
                    } else {
                        e[3].addtomaxheap(e[3].current);
                    }
                }
            }
        });
        b1c.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[0].dir == 'u' || e[0].dir == 's') {
                    e[0].c = 147;
                } else {
                    e[0].l = 147;
                }
            }
        });
        b2c.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[1].dir == 'u' || e[1].dir == 's') {
                    e[1].c = 147;
                } else {
                    e[1].l = 147;
                }
            }
        });
        b3c.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[2].dir == 'u' || e[2].dir == 's') {
                    e[2].c = 147;
                } else {
                    e[2].l = 147;
                }
            }
        });
        b4c.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {

                if (e[3].dir == 'u' || e[3].dir == 's') {
                    e[3].c = 147;
                } else {
                    e[3].l = 147;
                }
            }
        });
        bpoweron.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                for (int i = 0; i < 4; i++) {
                    e[i].power = 1;
                }
            }
        });
        bpoweroff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e1) {
                for (int i = 0; i < 4; i++) {
                    e[i].power = 0;
                }
            }
        });
        setLayout(null);

        add(b0u);
        //add(b0d);
        add(b1u);
        add(b1d);
        add(b2u);
        add(b2d);
        add(b3u);
        add(b3d);
        add(b4u);
        add(b4d);
        add(b5u);
        add(b5d);
        add(b6u);
        add(b6d);
        add(b7u);
        add(b7d);
        add(b8u);
        add(b8d);
        //add(b9u);
        add(b9d);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);
        add(b18);
        add(b19);
        add(b110);
        add(b1o);
        add(b1c);
        add(b1add);
        add(b1sub);
        add(b21);
        add(b22);
        add(b23);
        add(b24);
        add(b25);
        add(b26);
        add(b27);
        add(b28);
        add(b29);
        add(b210);
        add(b2o);
        add(b2c);
        add(b2add);
        add(b2sub);
        add(b31);
        add(b32);
        add(b33);
        add(b34);
        add(b35);
        add(b36);
        add(b37);
        add(b38);
        add(b39);
        add(b310);
        add(b3o);
        add(b3c);
        add(b3add);
        add(b3sub);
        add(b41);
        add(b42);
        add(b43);
        add(b44);
        add(b45);
        add(b46);
        add(b47);
        add(b48);
        add(b49);
        add(b410);
        add(b4o);
        add(b4c);
        add(b4add);
        add(b4sub);
        add(bpoweron);
        add(bpoweroff);
        setVisible(true);
        /*
         * assignfromouter(2, 'u'); assignfromouter(4, 'u'); assignfromouter(0,
         * 'u'); assignfromouter(2, 'd'); assignfromouter(4, 'd');
         * assignfromouter(1, 'd');
         */

        for (int i = 0; i < 4; i++) {
            System.out.println(i + " ");
            e[i].printmin();
            System.out.println(" ");
            e[i].printmax();
            System.out.println("\n ");

        }
        Thread thread = new Thread(this);
        thread.start();// to call run
    }

    //run() starts in new thread and all other action listener continue in same thread

    public void run() {
        // System.out.println("a");
        while (true) {
            for (int i = 0; i < 4; i++) {
                // System.out.println("c");
                e[i].update(this);
                if (e[i].pn > 6) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("ting");
                }
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public boolean checking_dup_outer(int f, char d) {
        if (e[0].a[f] != 0 || e[1].a[f] != 0 || e[2].a[f] != 0
                || e[3].a[f] != 0) {
            return true;
        }
        return false;
    }


    /*
     * public boolean checking_dup_inner(elevator e1, int f) { if(e1.a[f]!=0) {
     * return true; } return false; }
     */
    public void assignfromouter(int f, char d)//called when button is pressed
    {
        int[] lift_arr = new int[4];
        int time;
        int min = 100, k = 0;
        if (d == 'u') {
            int i = 3;
            while (i >= 0)// cheking eligible lift
            {
                if ((e[i].dir == 'u' && e[i].current < f) || (e[i].dir == 's')) {
                    //System.out.println("c");
                    lift_arr[i] = 1;
                }
                i--;
            }
            i = 0;
            while (i < 4)// assigning lift to f floor
            {
                if (lift_arr[i] == 1) {

                    time = Math.abs(f - e[i].current);
                    if (time < min) {
                        min = time;
                        k = i;
                    }
                }
                i++;
            }
            if (e[k].current <= f && lift_arr[k] == 1) {
                e[k].addtominheap(f);
                if (e[k].current == f) {
                    e[k].dir = 's';
                }
                if (e[k].current < f) {
                    e[k].dir = 'u';
                }
            } else if (e[k].current > f && lift_arr[k] == 1) {

                e[k].addtomaxheap(f);
                e[k].dir = 'd';

            }

        }

        if (d == 'd') {
            int i = 3;
            while (i >= 0)// checking eligible lift
            {
                if ((e[i].dir == 'd' && e[i].current > f) || e[i].dir == 's') {
                    lift_arr[i] = 1;
                }
                i--;
            }

            i = 0;
            while (i < 4)// assigning lift to f floor
            {
                if (lift_arr[i] == 1) {

                    time = Math.abs(e[i].current - f);
                    if (time < min) {
                        min = time;
                        k = i;
                    }

                }
                i++;
            }
            if (e[k].current <= f && lift_arr[k] == 1) {
                e[k].addtominheap(f);
                if (e[k].current == f) {
                    e[k].dir = 's';
                }
                if (e[k].current < f) {
                    e[k].dir = 'u';
                }
            } else if (e[k].current >= f && lift_arr[k] == 1) {
                if (lift_arr[k] == 1) {
                    e[k].addtomaxheap(f);
                    e[k].dir = 'd';
                }
            }
        }
    }

    // to avoid flickering
    public void update(Graphics g) {
        if (i == null) {
            i = createImage(this.getSize().width, this.getSize().height);
            doubleG = i.getGraphics();

        }

        doubleG.setColor(getBackground());
        doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
        doubleG.setColor(getForeground());
        paint(doubleG);

        g.drawImage(i, 0, 0, this);
    }

    public void paint(Graphics g)// automatically get called after init()only once then by repai
            //nt that is running in seprate thread;
    {
        try {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g.setColor(Color.BLACK);
            for (int i = 0; i <= 10; i++) {
                g.drawLine(100, 50 * i + 40, 800, 50 * i + 40);
                if (i != 10) {
                    g.drawString("Floor No." + (10 - i - 1), 20, 50 * i + 70);
                }
            }
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("Elevator 1", 900, 180);
            g.drawString("Elevator 2", 1100, 180);
            g.drawString("Elevator 3", 900, 380);
            g.drawString("Elevator 4", 1100, 380);
            g.fillRect(897, 198, 129, 130);
            g.fillRect(1097, 198, 129, 130);
            g.fillRect(897, 398, 129, 130);
            g.fillRect(1097, 398, 129, 130);
            g.fillRect(939, 68, 258, 34);
            for (int i = 1; i <= 4; i++) {
                e[i - 1].paint(g, i);
            }

        } catch (Exception r) {
        }
    }

}
