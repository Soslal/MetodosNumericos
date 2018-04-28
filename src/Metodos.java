import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	
	class miPanel extends JPanel{
		
		Image icono=new ImageIcon("img/menu.jpg").getImage();
		
		public miPanel(){
			
		}
		
		public void paintComponent(Graphics g){
			g.drawImage(icono,0,0,getWidth(),getHeight(),this);
		}
	}

	public class Metodos extends JFrame{
		int ancho=1300;
		JPanel panelMenu=new miPanel();
		JPanel panelBiseccion=new miPanel();
		JPanel panelFalsaPosicion=new miPanel();
		JPanel panelNewtonRaphson=new miPanel();
		
		boolean visible=false;
		
		public Metodos() {
			
			setVisible(true);
			setSize(ancho,530);
			setTitle("Metodos Numericos");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocation(10,10);
			setResizable(true);
			setLayout(null);
			
			menu();
			
		}
		public void jaja() {
			int a=0;
		}
		public void jajsa() {
			int a=0;
		}
		public void menu(){
			removeAll();
			add(panelMenu);
			repaint();
			panelMenu.setLayout(null);
			panelMenu.setBounds(0,0, ancho,500);	
			
			JLabel titulo1=new JLabel("Metodos Numericos 4to Semestre");
			titulo1.setBounds(60, 10, 350, 50);
			font(titulo1, "Times New Roman", 24);
			
		
			panelMenu.add(titulo1); 
			JLabel titulo2=new JLabel("Alumno: Omar Daniel Verdugo Ambriz");
			font(titulo2,"Times New Roman",18);
			titulo2.setBounds(60, 50, 350, 50);
			panelMenu.add(titulo2);
			
			JButton biseccion=new JButton("Bisección");
			biseccion.setBounds(50, 150, 100, 30);
			panelMenu.add(biseccion);
			biseccion.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					biseccion();
					
				}
				
			});
			
			JButton falsapos=new JButton("Falsa Posicion");
			falsapos.setBounds(170, 150, 120, 30);
			panelMenu.add(falsapos);
			falsapos.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					falsaPosicion();
					
				}
				
			});
			
			JButton newton=new JButton("Newton-Raphson");
			newton.setBounds(310, 150, 150, 30);
			panelMenu.add(newton);
			newton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					newtonRaphson();
					
				}
				
			});
			
			
		}
		public void font(JLabel label,String tipo,int size){
			
			Font font=new Font(tipo,Font.BOLD,size);
			label.setFont(font);
		
		}
		public void biseccion() {
			removeAll();
			add(panelBiseccion);
			repaint();
			panelBiseccion.setLayout(null);
			panelBiseccion.setBounds(0,0, ancho,500);	
			
			
			JLabel jA=new JLabel("a =");
			jA.setBounds(10, 10, 30, 30);
			panelBiseccion.add(jA);
			
			JTextField a=new JTextField();
			a.setBounds(35, 10, 100, 30);
			panelBiseccion.add(a);
			
			JLabel jB=new JLabel("b =");
			jB.setBounds(10, 50, 30, 30);
			panelBiseccion.add(jB);
			
			JTextField b=new JTextField();
			b.setBounds(35, 50, 100, 30);
			panelBiseccion.add(b);
			//Funcion Cubica
			JTextField tcubico=new JTextField();
			tcubico.setBounds(10, 140,30, 30);
			tcubico.setVisible(visible);
			panelBiseccion.add(tcubico);
			
			JLabel x3=new JLabel("x3");
			x3.setBounds(50, 140, 30, 30);
			x3.setVisible(visible);
			panelBiseccion.add(x3);
			
			JTextField tcuadratico=new JTextField();
			tcuadratico.setBounds(80, 140,30, 30);
			tcuadratico.setVisible(visible);
			panelBiseccion.add(tcuadratico);
			
			JLabel x2=new JLabel("x2");
			x2.setBounds(120, 140, 30, 30);
			x2.setVisible(visible);
			panelBiseccion.add(x2);
			
			JTextField tlineal=new JTextField();
			tlineal.setBounds(160,140,30,30);
			tlineal.setVisible(visible);
			panelBiseccion.add(tlineal);
			
			JLabel x=new JLabel("x");
			x.setBounds(190, 140, 30, 30);
			x.setVisible(visible);
			panelBiseccion.add(x);
			
			JTextField tindependiente=new JTextField();
			tindependiente.setBounds(220, 140,30, 30);
			tindependiente.setVisible(visible);
			panelBiseccion.add(tindependiente);
			
			JButton fCubica=new JButton("Funcion");
			fCubica.setBounds(10, 100,130, 30);
			panelBiseccion.add(fCubica);
			fCubica.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(visible==false) {
						visible=true;
					}else {
						visible=false;
					}
					tcubico.setVisible(visible);
					x3.setVisible(visible);
					tcuadratico.setVisible(visible);
					x2.setVisible(visible);
					tlineal.setVisible(visible);
					x.setVisible(visible);
					tindependiente.setVisible(visible);
				}
				
			});
			
			JLabel jtolerancia=new JLabel("Tolerancia: ");
			jtolerancia.setBounds(160, 20, 80, 30);
			panelBiseccion.add(jtolerancia);
			
			JTextField t=new JTextField();
			t.setBounds(230, 20,60, 30);
			panelBiseccion.add(t);
			
			//Funcion Cubica
			JButton clean=new JButton("Limpiar");
			clean.setBounds(330, 180, 100, 30);
			panelBiseccion.add(clean);
			clean.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					tcubico.setText("");
					tcuadratico.setText("");
					tlineal.setText("");
					tindependiente.setText("");
					t.setText("");
					a.setText("");
					b.setText("");
					panelBiseccion.removeAll(); 
					panelBiseccion.repaint();
					biseccion();
				}
				
			});
			
			JButton biseccion=new JButton("Calcular Raiz");
			biseccion.setBounds(170, 180, 150, 30);
			panelBiseccion.add(biseccion);
			biseccion.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(t.getText().isEmpty()||a.getText().isEmpty()||b.getText().isEmpty()) {
						JOptionPane.showMessageDialog(biseccion, "Por favor ingrese los valores");
					}else {
						double numA=Double.parseDouble(a.getText());
						
						double numB=Double.parseDouble(b.getText());
						double numT=Double.parseDouble(t.getText());
						double tCub=0;
						if(tcubico.getText().isEmpty()) {
							tCub=1;
						}else {
							tCub=Double.parseDouble(tcubico.getText());
				
						}
						double tCua=0;
						if(tcuadratico.getText().isEmpty()) {
							tCua=0;
						}else {
							tCua=Double.parseDouble(tcuadratico.getText());
						}
						
						double tLin=0;
						if(tlineal.getText().isEmpty()) {
							tLin=0;
						}else {
							tLin=Double.parseDouble(tlineal.getText());
						}
						double tInd=0;
						if(tindependiente.getText().isEmpty()) {
							tInd=0;
						}else {
							 tInd=Double.parseDouble(tindependiente.getText());
						}
					
						
						double error = 0;
						double m=0;
						double mAnt=0;
						double fa=0;
						double fb=0;
						double fm=0;
						double aux=0;
						int iteracion=-1;
						double mActual=0;
						double mAnterior=0;
						int y=210;
						JLabel tabla;
						
						panelBiseccion.add(jA);
						do {
							mAnterior=m;
							iteracion++;
							m=(numA+numB)/2;
							if(iteracion==0) {
								error=1;
								
							}
							if(iteracion>0) {
								
								mActual=m;
								error=(mActual-mAnterior)/mActual;
							}
							
								fa=(tCub*(Math.pow(numA, 3))+(tCua*(Math.pow(numA, 2))+((tLin)*(Math.pow(numA, 1))+tInd)));
								System.out.println(fa);
								fb=(tCub*(Math.pow(numB, 3))+(tCua*(Math.pow(numB, 2))+((tLin)*(Math.pow(numB, 1))+tInd)));
								System.out.println(fb);
								System.out.println(fa*fb);
								if(fa*fb<0) {
									fm=(tCub*(Math.pow(m, 3))+(tCua*(Math.pow(m, 2))+((tLin)*(Math.pow(m, 1))+tInd)));
									error=Math.abs(error);
									
									if(iteracion==0) {
										tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" m "+m+" f(a): "+fa +" f(b): "+fb+" f(m): "+fm+" error: NA");
										tabla.setBounds(10,y,1300,30);
									}else {
										tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" m "+m+" f(a): "+fa +" f(b): "+fb+" f(m): "+fm+" error: "+error);
										tabla.setBounds(10,y,1300,30);
									}
									if(fa*fm>0) {
										numA=m;
									}else if(fa*fm<0) {
										numB=m;
									}
									panelBiseccion.repaint();
									
									y+=20;
									panelBiseccion.add(tabla);
									System.out.println("Iteracion #"+iteracion+" fa: "+fa +" fb"+fb+" fm "+fm+" error: "+error);
									
								}
								else {
									JOptionPane.showMessageDialog(biseccion, "No hay raiz");
								}
								
						}while(error>=numT);
						if(iteracion>0) {
							JOptionPane.showMessageDialog(biseccion,"La Raiz se encuentra en la iteración #: "+iteracion);
						}
						
					}
					
				}
				
			});
			
			JButton menu=new JButton("Volver al menu");
			menu.setBounds(10, 180, 150, 30);
			panelBiseccion.add(menu);
			menu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					menu();
					
				}
				
			});
			
		}
		
		public void falsaPosicion() {
			removeAll();
			add(panelFalsaPosicion);
			repaint();
			panelFalsaPosicion.setLayout(null);
			panelFalsaPosicion.setBounds(0,0, ancho,500);	
			
			
			JLabel jA=new JLabel("a =");
			jA.setBounds(10, 10, 30, 30);
			panelFalsaPosicion.add(jA);
			
			JTextField a=new JTextField();
			a.setBounds(35, 10, 100, 30);
			panelFalsaPosicion.add(a);
			
			JLabel jB=new JLabel("b =");
			jB.setBounds(10, 50, 30, 30);
			panelFalsaPosicion.add(jB);
			
			JTextField b=new JTextField();
			b.setBounds(35, 50, 100, 30);
			panelFalsaPosicion.add(b);
			//Funcion Cubica
			JTextField tcubico=new JTextField();
			tcubico.setBounds(10, 140,30, 30);
			tcubico.setVisible(visible);
			panelFalsaPosicion.add(tcubico);
			
			JLabel x3=new JLabel("x3");
			x3.setBounds(50, 140, 30, 30);
			x3.setVisible(visible);
			panelFalsaPosicion.add(x3);
			
			JTextField tcuadratico=new JTextField();
			tcuadratico.setBounds(80, 140,30, 30);
			tcuadratico.setVisible(visible);
			panelFalsaPosicion.add(tcuadratico);
			
			JLabel x2=new JLabel("x2");
			x2.setBounds(120, 140, 30, 30);
			x2.setVisible(visible);
			panelFalsaPosicion.add(x2);
			
			JTextField tlineal=new JTextField();
			tlineal.setBounds(160,140,30,30);
			tlineal.setVisible(visible);
			panelFalsaPosicion.add(tlineal);
			
			JLabel x=new JLabel("x");
			x.setBounds(190, 140, 30, 30);
			x.setVisible(visible);
			panelFalsaPosicion.add(x);
			
			JTextField tindependiente=new JTextField();
			tindependiente.setBounds(220, 140,30, 30);
			tindependiente.setVisible(visible);
			panelFalsaPosicion.add(tindependiente);
			
			JButton fCubica=new JButton("Funcion");
			fCubica.setBounds(10, 100,130, 30);
			panelFalsaPosicion.add(fCubica);
			fCubica.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(visible==false) {
						visible=true;
					}else {
						visible=false;
					}
					tcubico.setVisible(visible);
					x3.setVisible(visible);
					tcuadratico.setVisible(visible);
					x2.setVisible(visible);
					tlineal.setVisible(visible);
					x.setVisible(visible);
					tindependiente.setVisible(visible);
				}
				
			});
			
			JLabel jtolerancia=new JLabel("Tolerancia: ");
			jtolerancia.setBounds(160, 20, 80, 30);
			panelFalsaPosicion.add(jtolerancia);
			
			JTextField t=new JTextField();
			t.setBounds(230, 20,60, 30);
			panelFalsaPosicion.add(t);
			
			//Funcion Cubica
			JButton clean=new JButton("Limpiar");
			clean.setBounds(330, 180, 100, 30);
			panelFalsaPosicion.add(clean);
			clean.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					tcubico.setText("");
					tcuadratico.setText("");
					tlineal.setText("");
					tindependiente.setText("");
					t.setText("");
					a.setText("");
					b.setText("");
					panelFalsaPosicion.removeAll(); 
					panelFalsaPosicion.repaint();
					biseccion();
				}
				
			});
			
			JButton falsapos=new JButton("Calcular Raiz");
			falsapos.setBounds(170, 180, 150, 30);
			panelFalsaPosicion.add(falsapos);
			falsapos.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(t.getText().isEmpty()||a.getText().isEmpty()||b.getText().isEmpty()) {
						JOptionPane.showMessageDialog(falsapos, "Por favor ingrese los valores");
					}else {
						double numA=Double.parseDouble(a.getText());
						
						double numB=Double.parseDouble(b.getText());
						double numT=Double.parseDouble(t.getText());
						double tCub=0;
						if(tcubico.getText().isEmpty()) {
							tCub=1;
						}else {
							tCub=Double.parseDouble(tcubico.getText());
				
						}
						double tCua=0;
						if(tcuadratico.getText().isEmpty()) {
							tCua=0;
						}else {
							tCua=Double.parseDouble(tcuadratico.getText());
						}
						
						double tLin=0;
						if(tlineal.getText().isEmpty()) {
							tLin=0;
						}else {
							tLin=Double.parseDouble(tlineal.getText());
						}
						double tInd=0;
						if(tindependiente.getText().isEmpty()) {
							tInd=0;
						}else {
							 tInd=Double.parseDouble(tindependiente.getText());
						}
					
						
						double error = 0;
						double xr=0;
						double mAnt=0;
						double fa=0;
						double fb=0;
						double fm=0;
						double aux=0;
						int iteracion=-1;
						double mActual=0;
						double mAnterior=0;
						int y=210;
						JLabel tabla;
						
						panelFalsaPosicion.add(jA);
						do {
							
							
								fa=(tCub*(Math.pow(numA, 3))+(tCua*(Math.pow(numA, 2))+((tLin)*(Math.pow(numA, 1))+tInd)));
								System.out.println(fa);
								fb=(tCub*(Math.pow(numB, 3))+(tCua*(Math.pow(numB, 2))+((tLin)*(Math.pow(numB, 1))+tInd)));
								System.out.println(fb);
								System.out.println(fa*fb);
								
								
								mAnterior=xr;
								iteracion++;
								xr=numA-((fa)*(numB-numA)/((fb)-(fa)));
								if(iteracion==0) {
									error=1;
									
								}
								if(iteracion>0) {
									
									mActual=xr;
									error=(mActual-mAnterior)/mActual;
								}
								
								if(fa*fb<0) {
									fm=(tCub*(Math.pow(xr, 3))+(tCua*(Math.pow(xr, 2))+((tLin)*(Math.pow(xr, 1))+tInd)));
									error=Math.abs(error);
									
									if(iteracion==0) {
										tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" Xr "+xr+" f(a): "+fa +" f(b): "+fb+" f(Xr): "+fm+" error: NA");
										tabla.setBounds(10,y,1300,30);
									}else {
										tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" Xr "+xr+" f(a): "+fa +" f(b): "+fb+" f(Xr): "+fm+" error: "+error);
										tabla.setBounds(10,y,1300,30);
									}
									if(fa*fm>0) {
										numA=xr;
									}else if(fa*fm<0) {
										numB=xr;
									}
									panelFalsaPosicion.repaint();
									
									y+=20;
									panelFalsaPosicion.add(tabla);
									System.out.println("Iteracion #"+iteracion+" fa: "+fa +" fb"+fb+" fm "+fm+" error: "+error);
									
								}
								else {
									JOptionPane.showMessageDialog(falsapos, "No hay raiz");
								}
								
						}while(error>=numT);
						if(iteracion>0) {
							JOptionPane.showMessageDialog(falsapos,"La Raiz se encuentra en la iteración #: "+(iteracion-1));
						}
						
					}
					
				}
				
			});
			
			JButton menu=new JButton("Volver al menu");
			menu.setBounds(10, 180, 150, 30);
			panelFalsaPosicion.add(menu);
			menu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					menu();
					
				}
				
			});
		}
		
		public void newtonRaphson() {
			removeAll();
			add(panelNewtonRaphson);
			repaint();
			panelNewtonRaphson.setLayout(null);
			panelNewtonRaphson.setBounds(0,0, ancho,500);	
			
			
			JLabel jA=new JLabel("Xn =");
			jA.setBounds(10, 10, 30, 30);
			panelNewtonRaphson.add(jA);
			
			JTextField a=new JTextField();
			a.setBounds(35, 10, 100, 30);
			panelNewtonRaphson.add(a);
			
			
			//Funcion Cubica
			JTextField tcubico=new JTextField();
			tcubico.setBounds(10, 140,30, 30);
			tcubico.setVisible(visible);
			panelNewtonRaphson.add(tcubico);
			
			JLabel x3=new JLabel("x3");
			x3.setBounds(50, 140, 30, 30);
			x3.setVisible(visible);
			panelNewtonRaphson.add(x3);
			
			JTextField tcuadratico=new JTextField();
			tcuadratico.setBounds(80, 140,30, 30);
			tcuadratico.setVisible(visible);
			panelNewtonRaphson.add(tcuadratico);
			
			JLabel x2=new JLabel("x2");
			x2.setBounds(120, 140, 30, 30);
			x2.setVisible(visible);
			panelNewtonRaphson.add(x2);
			
			JTextField tlineal=new JTextField();
			tlineal.setBounds(160,140,30,30);
			tlineal.setVisible(visible);
			panelNewtonRaphson.add(tlineal);
			
			JLabel x=new JLabel("x");
			x.setBounds(190, 140, 30, 30);
			x.setVisible(visible);
			panelNewtonRaphson.add(x);
			
			JTextField tindependiente=new JTextField();
			tindependiente.setBounds(220, 140,30, 30);
			tindependiente.setVisible(visible);
			panelNewtonRaphson.add(tindependiente);
			
			JButton fCubica=new JButton("Funcion");
			fCubica.setBounds(10, 100,130, 30);
			panelNewtonRaphson.add(fCubica);
			fCubica.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(visible==false) {
						visible=true;
					}else {
						visible=false;
					}
					tcubico.setVisible(visible);
					x3.setVisible(visible);
					tcuadratico.setVisible(visible);
					x2.setVisible(visible);
					tlineal.setVisible(visible);
					x.setVisible(visible);
					tindependiente.setVisible(visible);
				}
				
			});
			
			JLabel jtolerancia=new JLabel("Tolerancia: ");
			jtolerancia.setBounds(160, 20, 80, 30);
			panelNewtonRaphson.add(jtolerancia);
			
			JTextField t=new JTextField();
			t.setBounds(230, 20,60, 30);
			panelNewtonRaphson.add(t);
			
			//Funcion Cubica
			JButton clean=new JButton("Limpiar");
			clean.setBounds(330, 180, 100, 30);
			panelNewtonRaphson.add(clean);
			clean.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					tcubico.setText("");
					tcuadratico.setText("");
					tlineal.setText("");
					tindependiente.setText("");
					t.setText("");
					a.setText("");
					
					panelNewtonRaphson.removeAll(); 
					panelNewtonRaphson.repaint();
					newtonRaphson();
				}
				
			});
			
			JButton falsapos=new JButton("Calcular Raiz");
			falsapos.setBounds(170, 180, 150, 30);
			panelNewtonRaphson.add(falsapos);
			falsapos.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					if(t.getText().isEmpty()||a.getText().isEmpty()) {
						JOptionPane.showMessageDialog(falsapos, "Por favor ingrese los valores");
					}else {
						double numA=Double.parseDouble(a.getText());
						
						
						double numT=Double.parseDouble(t.getText());
						double tCub=0;
						if(tcubico.getText().isEmpty()) {
							tCub=1;
						}else {
							tCub=Double.parseDouble(tcubico.getText());
				
						}
						double tCua=0;
						if(tcuadratico.getText().isEmpty()) {
							tCua=0;
						}else {
							tCua=Double.parseDouble(tcuadratico.getText());
						}
						
						double tLin=0;
						if(tlineal.getText().isEmpty()) {
							tLin=0;
						}else {
							tLin=Double.parseDouble(tlineal.getText());
						}
						double tInd=0;
						if(tindependiente.getText().isEmpty()) {
							tInd=0;
						}else {
							 tInd=Double.parseDouble(tindependiente.getText());
						}
					
						
						double error = 0;
						double xr=0;
						double mAnt=0;
						double fa=0;
						double fb=0;
						double fm=0;
						double aux=0;
						int iteracion=-1;
						double mActual=0;
						double mAnterior=0;
						int y=210;
						JLabel tabla;
						
						panelNewtonRaphson.add(jA);
						do {
							
							
								fa=(tCub*(Math.pow(numA, 3))+(tCua*(Math.pow(numA, 2))+((tLin)*(Math.pow(numA, 1))+tInd)));
								System.out.println(fa);
								System.out.println(fa*fb);
								
								numA=
								mAnterior=xr;
								iteracion++;
								
								if(iteracion==0) {
									error=1;
									
								}
								if(iteracion>0) {
									
									mActual=xr;
									error=(mActual-mAnterior)/mActual;
								}
								
								if(fa*fb<0) {
									fm=(tCub*(Math.pow(xr, 3))+(tCua*(Math.pow(xr, 2))+((tLin)*(Math.pow(xr, 1))+tInd)));
									error=Math.abs(error);
									
									if(iteracion==0) {
									//	tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" Xr "+xr+" f(a): "+fa +" f(b): "+fb+" f(Xr): "+fm+" error: NA");
										//tabla.setBounds(10,y,1300,30);
									}else {
									//	tabla=new JLabel("Iteracion #"+iteracion+" a "+numA+" b "+numB+" Xr "+xr+" f(a): "+fa +" f(b): "+fb+" f(Xr): "+fm+" error: "+error);
										//tabla.setBounds(10,y,1300,30);
									}
									if(fa*fm>0) {
										numA=xr;
									}
									panelNewtonRaphson.repaint();
									
									y+=20;
									//panelFalsaPosicion.add(tabla);
									System.out.println("Iteracion #"+iteracion+" fa: "+fa +" fb"+fb+" fm "+fm+" error: "+error);
									
								}
								else {
									JOptionPane.showMessageDialog(falsapos, "No hay raiz");
								}
								
						}while(error>=numT);
						if(iteracion>0) {
							JOptionPane.showMessageDialog(falsapos,"La Raiz se encuentra en la iteración #: "+(iteracion-1));
						}
						
					}
					
				}
				
			});
			
			JButton menu=new JButton("Volver al menu");
			menu.setBounds(10, 180, 150, 30);
			panelNewtonRaphson.add(menu);
			menu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					menu();
					
				}
				
			});
		}
		
		public void removeAll() {
			remove(panelMenu);
			remove(panelBiseccion);
			remove(panelFalsaPosicion);
			remove(panelNewtonRaphson);
		}
	}