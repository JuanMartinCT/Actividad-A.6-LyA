
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
//int a , b ; int c ; c = ( a + a ) * c ; $
//int var1 , var2 ; float var3 ; var3 = ( var2 + var2 ) * var3 ; $
public class Visual extends javax.swing.JFrame {
//Variables JFrame------------------------------------------
	javax.swing.JTextArea incad;
	javax.swing.JButton acep;
	javax.swing.JButton canc;
	javax.swing.JLabel sem;
	javax.swing.JLabel sin;
	javax.swing.JLabel error;
	javax.swing.JLabel lcadena;
	javax.swing.JScrollPane jScrollPane1;
	javax.swing.JScrollPane jScrollPane2;
	javax.swing.JScrollPane jScrollPane3;
	javax.swing.JScrollPane jScrollPane4;
	javax.swing.JTextArea textsem; 
	javax.swing.JTextArea textcon;
	javax.swing.JTextArea textsin;
//Fin Variables----------------------------------------------
	
//Variables Prog---------------------------------------------
	String cadena, middle="\n", word="", word1="", word2 ="", word3="";
	String vcad[];
	int ren=0, fil=0, ID=0;
	int TP[] = {1,2,3}; // 1 --> int | 2 --> float | 3 --> char
	int producciones[]= {0,1,1,2,2,2,10,26,3,13,13,25,14,27,28,15,19};
	String tabla[][]= new String[50][50];
	String tipodato;
	int rt,ft;
	int da=0;
	String auxcad;
	String operaciones[]= new String[50];
	boolean doit=false, doit2=false, doit3=false, banM=false;
	String val1, val2;
	int v=-1, v2=-1;
	boolean find=false;
	
	char valores[] = new char[10];
	
String encabezado[] = {
			"id", "int","float","char",",",  ";",  "+",  "-", "*", "/", "(",  ")", "$",  "P","tipo", "V", "A", "E", "T","F", "="};
int  matE[][]={ 
		     //id  int   float char     ,     ;     +     -    *    /    (     )    $     P   tipo    V    A    E    T    F   =
		/*0*/  { 7,  4,    5,    6,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,    1,    2,   -1,   3,  -1,  -1,  -1, -1},
		/*1*/  {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,   0,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*2*/  { 8, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*3*/  {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -2,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*4*/  {-3, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*5*/  {-4, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*6*/  {-5, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*7*/  {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1,  9},
		/*8*/  {-1, -1,   -1,   -1,    11,   12,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   10,  -1,  -1,  -1,  -1, -1},
		/*9*/  {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  13,  14,  15, -1},
		/*10*/ {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1, -32,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*11*/ {18, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*12*/ { 7,  4,    5,    6,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  19,   -1,    2,   -1,   3,  -1,  -1,  -1, -1},
		/*13*/ {-1, -1,   -1,   -1,    -1,   20,   21,   22,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*14*/ {-1, -1,   -1,   -1,    -1,  -11,  -11,  -11,  23,  24,  -1,  -11,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*15*/ {-1, -1,   -1,   -1,    -1,  -14,  -14,  -14, -14, -14,  -1,  -14,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*16*/ {-1, -1,   -1,   -1,    -1,  -16,  -16,  -16, -16, -16,  -1,  -16,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*17*/ {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  25,  14,  15, -1},
		/*18*/ {-1, -1,   -1,   -1,    11,   12,   -1,   -1,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   26,  -1,  -1,  -1,  -1, -1},
		/*19*/ {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -7,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*20*/ {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -8,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*21*/ {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  27,  19, -1},
		/*22*/ {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  28,  19, -1},
		/*23*/ {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  19, -1},
		/*24*/ {16, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  17,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, 21},
		/*25*/ {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   30,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*26*/ {-1, -1,   -1,   -1,    -1,   -1,   -1,   -1,  -1,  -1,  -1,   -1,  -6,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*27*/ {-1, -1,   -1,   -1,    -9,   -9,   -9,   -9,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*28*/ {-1, -1,   -1,   -1,   -10,  -10,  -10,  -10,  -1,  -1,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*29*/ {-1, -1,   -1,   -1,   -12,  -12,  -12,  -12, -12, -12,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*30*/ {-1, -1,   -1,   -1,   -13,  -13,  -13,  -13, -13, -13,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1},
		/*31*/ {-1, -1,   -1,   -1,   -15,  -15,  -15,  -15, -15, -15,  -1,   -1,  -1,   -1,   -1,   -1,  -1,  -1,  -1,  -1, -1}	   
			    
			};

String tokenEnt[]=new String[21];
Stack<String> pila = new Stack<String>();
Stack<String> Sinta = new Stack<String>();

boolean enc= false;
	
//Fin Variables----------------------------------------------

    public Visual() 
    {
        initComponents();
        
        tokenEnt[0] = "id";
		tokenEnt[1] = "int";
		tokenEnt[2] = "float";
		tokenEnt[3] = "char";
		tokenEnt[4] = ",";
		tokenEnt[5] = ";";
		tokenEnt[6] = "+";
		tokenEnt[7] = "-";
		tokenEnt[8] = "*";
		tokenEnt[9] = "/";
		tokenEnt[10] = "(";
		tokenEnt[11] = ")";
		tokenEnt[12] = "$";
		tokenEnt[13] = "P";
		tokenEnt[14] = "Tipo";
		tokenEnt[15] = "V";
		tokenEnt[16] = "A";
		tokenEnt[17] = "E";
		tokenEnt[18] = "T";
		tokenEnt[19] = "F";
		tokenEnt[20] = "=";
		
		valores[0] = '0';
		valores[1] = '1';
		valores[2] = '2';
		valores[3] = '3';
		valores[4] = '4';
		valores[5] = '5';
		valores[6] = '6';
		valores[7] = '7';
		valores[8] = '8';
		valores[9] = '9';
		
		
		pila.push("$");
		pila.push("I0");
        
        acep.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			cadena = incad.getText();
			Cadena(cadena);
			}
		});
        
        
    } 
                        
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        textsem = new javax.swing.JTextArea("");
        jScrollPane2 = new javax.swing.JScrollPane();
        textcon = new javax.swing.JTextArea("");
        jScrollPane3 = new javax.swing.JScrollPane();
        textsin = new javax.swing.JTextArea("");
        sem = new javax.swing.JLabel();
        sin = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        acep = new javax.swing.JButton();
        canc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        incad = new javax.swing.JTextArea();
        lcadena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textsem.setColumns(20);
        textsem.setRows(5);
        jScrollPane1.setViewportView(textsem);

        textcon.setColumns(20);
        textcon.setRows(5);
        jScrollPane2.setViewportView(textcon);

        textsin.setColumns(20);
        textsin.setRows(5);
        jScrollPane3.setViewportView(textsin);

        sem.setText("Sementico");

        sin.setText("Sintactico");

        error.setText("Consola de Errores");

        acep.setText("Acept");

        canc.setText("Cancel");

        incad.setColumns(20);
        incad.setRows(5);
        jScrollPane4.setViewportView(incad);

        lcadena.setText("Ingrese la cadena");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(acep)
                        .addGap(40, 40, 40)
                        .addComponent(canc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sin)
                        .addGap(247, 247, 247))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sem)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lcadena, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(error)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(error)
                    .addComponent(lcadena, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(canc)
                            .addComponent(acep))
                        .addGap(354, 389, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sin)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sem)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }                        

    public void Cadena(String cad)
	{		
		vcad=cad.split(" "); 
		
		for(int i=0; i<vcad.length;)
		{
			textsin.setText(textsin.getText()+("\nPos:"+i+" Envio --> "+vcad[i])+"\n");

			if(vcad[i].equals(encabezado[0])  || 
			   vcad[i].equals(encabezado[1])  || 
			   vcad[i].equals(encabezado[2])  || 
			   vcad[i].equals(encabezado[3])  || 
			   vcad[i].equals(encabezado[4])  ||
			   vcad[i].equals(encabezado[5])  ||
			   vcad[i].equals(encabezado[6])  ||
			   vcad[i].equals(encabezado[7])  ||
			   vcad[i].equals(encabezado[8])  ||
			   vcad[i].equals(encabezado[9])  ||
			   vcad[i].equals(encabezado[10]) ||
			   vcad[i].equals(encabezado[11]) ||
			   vcad[i].equals(encabezado[12]) ||
			   vcad[i].equals(encabezado[13]) ||
			   vcad[i].equals(encabezado[14]) ||
			   vcad[i].equals(encabezado[15]) ||
			   vcad[i].equals(encabezado[16]) ||
			   vcad[i].equals(encabezado[17]) ||
			   vcad[i].equals(encabezado[18]) ||
			   vcad[i].equals(encabezado[19]) ||
			   vcad[i].equals(encabezado[20]) 
			   )
			{
				if(vcad[i].equals(encabezado[1]))
				{
					
					TP[0]=1;
					Evaluar(vcad[i]); 
					if(enc) {
						i++;
					}	
				}
				else
				{
					if(vcad[i].equals(encabezado[2]))
					{
						TP[1]=2;
						Evaluar(vcad[i]);
						if(enc) {
							i++;
						}
					}
					else
					{
						if(vcad[i].equals(encabezado[3]))
						{
							TP[2]=3;
							Evaluar(vcad[i]);
							if(enc) {
								i++;	
							}
						}
						else
						{
							Evaluar(vcad[i]);
							if(enc) {
								i++;
							}
						}	
					}
				}
				try
				{
					tabla[rt][0]=vcad[i];					
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			
			else
			{ 
				textsem.setText(textsem.getText()+"Se convirtio "+vcad[i]+" en un id"+"\n");

				auxcad = vcad[i];
				operaciones[da]=auxcad;
				da++;
				
				if(doit && doit2)
					doit3=true;
				
				word = vcad[i];

				vcad[i] = "id";
				find=true;
				textsem.setText(textsem.getText()+("Pos:"+i+" Envio --> "+vcad[i])+"\n");
				
				Evaluar(vcad[i]);
				if(enc) {
					i++;	
				}
			}
		}
		
		/*System.out.println("Op pila "+Sinta);
		for(int y=0; y<da;y++)
		{
			System.out.println(operaciones[y]);
		}*/	
	}
    
    public void Evaluar(String cad)
	{
		if(cad.equals("+")  ||  cad.equals("-")|| cad.equals("/")  || cad.equals("*"))
		{
			doit=true;
		}
		if(cad.equals("="))
		{
			
		}
		
		enc=false;
		for(int i=0; i<tokenEnt.length; i++)//Recorre el vector de token para ver si la cadena es igual a alguno
		{
			if(cad.equals(tokenEnt[i]))
			{
				textsin.setText(textsin.getText()+("Renglon-> "+ren+". Estado-> I "+i+"\n"));
				textsin.setText(textsin.getText()+("Ir_a("+matE[ren][i]+") --> renglon\n"));
				
				switch(matE[ren][i])
				{
				    case -1:
				    	System.out.println("Cadena no aceptada, Error en: "+cad);
				    	System.exit(0);
				    	
				    	break;
					case 0://Aceptada
						ren = 1;
						enc=true;
						
						pila.pop();
						pila.pop();
						pila.pop();
						
						//pila.push("P");
						//System.out.println("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila.firstElement()+"\n");
						System.out.println("Cadena Aceptada");
						
						System.out.println("Código intermedio: "+middle);
						
						
						/*System.out.println("Tabla:");
						for(int l=0;l<rt;l++)
						{
							System.out.println();
							for(int l2=0; l2<2; l2++)
							{
								System.out.print(tabla[l][l2]+"  ");
							}
						}
						System.out.println();*/
						break;
						
					case -32://Estado 1
						ren = 1;
						pila.pop();
						pila.pop();
						textsin.setText(textsin.getText()+("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila)+"\n");
						break;
					case -2:
						
						pila.pop();
						pila.pop();
						
						pila.push("P");
						ren = 1;
						pila.push("I"+ren);
						break;
						
					case -3://int
						ren = producciones[matE[ren][i]*-1];
						
						pila.pop();
						pila.pop();
						pila.push("Tipo");
						pila.push("I"+ren);
						
						textsin.setText(textsin.getText()+("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila)+"\n");
						tipodato = "0";
						
						//middle+=vcad[(i)]+"; \n";

						ren = matE[0][14];
						
						break;
						
					case -4://float
						ren = producciones[matE[ren][i]*-1];
						pila.pop();
						pila.pop();
						pila.push("Tipo");
						pila.push("I"+ren);
						tipodato = "1";
						textsin.setText(textsin.getText()+("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila)+"\n");
						
						//middle+="id-4 ";
						
						break;
						
					case -5://char	
						ren = producciones[matE[ren][i]*-1];
						pila.pop();
						pila.push("I"+matE[ren][i]+"");
						tipodato = "2";
						textsin.setText(textsin.getText()+("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila)+"\n");
						
						//middle+="id-5 ";
						
						break;
						
					case -6://Estado 10
						ren = producciones[matE[ren][i]*-1];
						pila.pop();
						textsin.setText(textsin.getText()+("Entrada:  " /*ren "+ren+cad+*/+" \n  Pila "+pila)+"\n");
						
						break;
						
					case -7://Estado 26
						ren = producciones[matE[ren][i]*-1];
						pila.pop();
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						break;
					
					case -8:
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						
						pila.push("A");
						ren = 3;
						pila.push("I"+ren);
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						break;
					
					case -9:
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.push("I"+ren);
						ren=13;
						
						if(TP[0] > TP[2])
						{
							Sinta.push("FLOAT");	
						}
						else
						{
							Sinta.push("INT");
						}
						
						break;
					
					case -10:
						
					//	middle+=";-10 ";
						
						
						break;
						
					case -11://Produccion p11
						pila.pop();
						pila.pop();
						pila.push("E");
						pila.push("I"+(ren));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						if(cad=="*")
						{
							ren = 23;
						}
						else
						{
							ren = 13;
						}
						
						if(TP[0] > TP[2])
						{
							Sinta.push("FLOAT");	
						}
						else
						{
							Sinta.push("INT");
						}
						break;
						
					case -12:
						
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						ren=14;
						if(TP[0] > TP[2])
						{
							Sinta.push("FLOAT");	
						}
						else
						{
							Sinta.push("INT");
						}
						
						break;
						
					case -13:
						if(cad.equals("*") || cad.equals("/"))
						{
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							ren=14;
							pila.push("T");
							pila.push("I"+ren);
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							if(TP[0] > TP[2])
							{
								Sinta.push("FLOAT");	
							}
							else
							{
								Sinta.push("INT");
							}
							ren=14;
							
						}
						else
						{
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							
							if(TP[0] > TP[2])
							{
								Sinta.push("FLOAT");	
							}
							else
							{
								Sinta.push("INT");
							}
							ren =27;
						}
						break;
						
					case -14://Produccion p14
						pila.pop();
						pila.pop();
						pila.push("T");
						pila.push("I"+(ren));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						ren=14;
						break;
						
					case -15: 
						
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.pop();
						pila.push("F");
						pila.push("I"+ren);
						
						break;
						
					case -16: //Produccion p16
						
						if(cad.equals(")"))
						{
							
							pila.pop();
							pila.pop();
							pila.push("F");
							pila.push("I"+(ren-1));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							pila.pop();
							pila.pop();
							pila.push("T");
							pila.push("I"+(ren-2));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							pila.pop();
							
							ren = 25;
							pila.push("E");
							pila.push("I"+(ren));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							break;
						}
						
						
						if(cad.equals("*") || cad.equals("/"))
						{
							enc=true;
							pila.pop();
							pila.pop();
							pila.push("F");
							pila.push("I"+(ren-1));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							pila.pop();
							pila.pop();
							pila.push("T");
							pila.push("I"+(ren-2));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							pila.pop();
							pila.pop();
							pila.push("E");
							pila.push("I"+(ren-3));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							ren =17;
							
							break;
						}
						
						if(cad.equals("+") || cad.equals("-"))
						{
							pila.pop();
							pila.pop();
							pila.push("F");
							pila.push("I"+(ren-1));
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							ren=15;
							break;
						}
						else
						{
							
							fil=i;
							ren = producciones[matE[ren][fil]*-1];
							
							pila.push(encabezado[i]);
							pila.push("I"+(ren+1));
							
							enc=true;
							middle+="; \n";
							
							ren = matE[13][5];
							textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
							
							break;		
						}
							
					case 1:
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						enc=true;
						pila.push("I"+ren+"");
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						break;
						
					case 4:
					
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						
						enc=true;
						pila.push("I"+ren+"");
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						word = vcad[i];
						word1=word;
						middle+="int ";
						/*if(banM)
						{
							
							banM=false;
						}
						else	
							middle+="int ";
						*/
						break;	
						
					case 5:
						
						fil = i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						enc=true;
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						//System.out.println(pila.peek());
						middle+="float ";
						break;
					
					case 6:
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						enc=true;
						pila.push("I"+ren+"");
						//pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						middle+="char ";
						break;
						
					case 7:
					
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						word3=word;
						
						//middle+=word+" -";
						
						enc=true;
						
						
						//pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						if(tabla[rt][0]==null)
						{
							textcon.setText(textcon.getText()+("No se declaro id")+"\n");
						}
						
						break;
					case 8:
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						enc=true;
						
						tabla[rt][1]=tipodato;
						//System.out.println("Se agrego a tabla");
						rt++;
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						//System.out.println(pila.peek());
						
						
						middle+=word+";\n ";

						break;	
						
						
					case 9:
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						
						//middle+="= ";
						
						enc=true;
						
						//pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						if(tabla[rt][0]==null)
						{
							textcon.setText(textcon.getText()+("No se declaro id")+"\n");
						}
						break;
						
					case 11://Estado 11 id
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						enc=true;
						
						pila.push("I"+ren+"");						
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						//System.out.println(pila.peek());
						
						//if(ren)
						middle+="int ";
						//else
						//middle+="float ";
						
						banM=true;
						break;
						
					case 12: //$
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						
						
						
						tipodato="-1";
						
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						//System.out.println(pila.peek());
						
						//middle+=";\n";
						
						break;
						
						
							
					case 15:
						pila.pop();
						pila.pop();
						pila.push("T");
						pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						//System.out.println();
						ren = -14;
						break;
							
					case 16: 
						
						fil=i;
						ren=matE[ren][fil];
						pila.push(encabezado[fil]);
						
						enc=true;
						pila.push("I"+ren+"");
						//pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						pila.pop();
						pila.pop();
						pila.push("F");
						pila.push("I"+(ren-1));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						pila.pop();
						pila.pop();
						pila.push("T");
						pila.push("I"+(ren-2));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						pila.pop();
						pila.pop();
						pila.push("E");
						pila.push("I"+(ren-3));
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
					
						middle+=word+" ";
						
						doit2=true;
						break;
						
					case 17:
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						enc=true;
						
						
						
						//middle+="v1 = "+word1+";\n";
						
						//middle+="v2 = "+word2+";\n";
						
						middle+= word1+" = ";
						
						
						
					//	middle+="v3 = "+word3+";\n";
						
						
						//middle+=" ( ";
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						break;	
						
					case 18:
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[i]);
						pila.push("I"+ren);
						enc=true;
						
						tabla[rt][1]=tipodato;
						
						rt++;
						
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						
						word2 = word;
						middle+=word+"; \n ";
						
						break;
						
					case 19:
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.pop();
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						//System.out.println(pila.peek());
						break;
						
					case 20:
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						middle+="; ";
						textsin.setText(textsin.getText()+("entrada:   \n   Pila "+pila)+"\n");
						break;
						
					case 21://+
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						textsin.setText(textsin.getText()+("Entrada:  \n  Pila "+pila)+"\n");
						middle+="+ ";
						break;
						
					case 22://-
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						middle+="- ";
						textsin.setText(textsin.getText()+("Entrada:  \n  Pila "+pila)+"\n");
						break;	
						
					case 23:
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						middle+=word3+" = "+word1+" * ";
						textsin.setText(textsin.getText()+("Entrada:  \n  Pila "+pila)+"\n");
						
						break;
					case 24:
						
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren+"");
						enc=true;
						middle+=word3+" = "+word1+" / ";
						textsin.setText(textsin.getText()+("Entrada:  \n  Pila "+pila)+"\n");
						
						break;
						
					case 29:
						doit=true;
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						
						enc=true;
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						break;	
						
					case 30:
						fil=i;
						ren = matE[ren][fil];
						pila.push(encabezado[fil]);
						pila.push("I"+ren);
						
						enc=true;
						
						//middle+=") ";
						middle+=";\n";
						textsin.setText(textsin.getText()+("Entrada:  "+" \n  Pila "+pila)+"\n");
						doit2=true;
						break;	
				}		
			}
		}		
		
		if(doit && doit3)
		{
			val2=operaciones[da-2];
			val1=operaciones[da-1];
	
			//System.out.println("val1: "+val1+" val2: "+val2);
			for(int h=0; h<rt; h++)
			{
	
				if(val2.equals(tabla[h][0]))
				{
					
					v2=Integer.parseInt(tabla[h][1]);
					//System.out.println("Pen: "+v2);
				} 
				if(val1.equals(tabla[h][0]))
				{
					v=Integer.parseInt(tabla[h][1]);
					//System.out.println("Pen: "+v);
				}
				
			}
			//System.out.println("v: "+v+" v2: "+v2);
			if(v!=v2)
			{
				//textcon.setText(textcon.getText()+("Error Semantico en : "+val2+", "+val1+" Se espera el mismo tipo de dato")+"\n");
				textcon.setText(textcon.getText()+("Error Semantico en : "+val2+", "+val1+" Se espera el mismo tipo de dato, pero al ser float y int se acepta")+"\n");
				
				
				for(int y=0; y<da;y++)
				{
					//System.out.println(operaciones[y]);
				}	
				doit=false;
				doit2=false;
				doit3=false;
				
			}
			else
			{
				textsem.setText(textsem.getText()+"Se realizar operacion con "+val1+" y "+val2+"\n");
				doit=false;
				doit2=false;
				doit3=false;
			}
		}
		
	}
    
    
    
    public static void main(String args[]) {
    	new Visual();
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
            }
        });
    }                
}
