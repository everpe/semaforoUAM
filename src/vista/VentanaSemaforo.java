package vista;

import cliente.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author YOGA 500
 */
public class VentanaSemaforo extends javax.swing.JFrame 
{    
    private String ipSemaforo;
    private Semaforo semaforo;
    private Thread a= new Thread();
    private Thread b=new Thread();
    private Thread c=new Thread();
    private boolean bandera=true;
    /**
     * Creates new form ejecutable
     */
    public VentanaSemaforo(String ipSemaforo) 
    {
        this.ipSemaforo = ipSemaforo;
        initComponents();
        semaforo = new Semaforo(rojo,amarillo,verde,txtTiempo, 
                                this.lblColor, this.ipSemaforo);

        this.setLocationRelativeTo(null);
        
        //Coloca a recibir() el semaforo infinitamente y le asigna el ID.
        semaforo.inicializar();
        
         new Thread(() -> {
            for(;;)
            {
                txtTiempo.setText(this.semaforo.getId()+"");
            }
            
        }).start(); 
         
//          new Thread(() -> {
//            semaforo.getCliente().enviar("Mi,"+"id,"+this.semaforo.getId());
//            while(true)
//            {
//                String cadena=semaforo.getCliente().recibir();
//                System.out.println("Cadenannananananannanananana: "+cadena);
//            }
//
//        }).start();
 
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rojo = new javax.swing.JButton();
        amarillo = new javax.swing.JButton();
        verde = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblEncabezado = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        rojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rojoActionPerformed(evt);
            }
        });

        amarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amarilloActionPerformed(evt);
            }
        });

        verde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verdeActionPerformed(evt);
            }
        });

        btnActivar.setBackground(new java.awt.Color(46, 145, 169));
        btnActivar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(255, 255, 255));
        btnActivar.setText("Activar semaforo");
        btnActivar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setText("Semáforo UAM");

        lblEncabezado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEncabezado.setText("Identificador");

        txtTiempo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTiempo.setForeground(new java.awt.Color(0, 0, 102));
        txtTiempo.setEnabled(false);

        lblColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rojo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(amarillo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verde, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEncabezado)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActivar)
                .addGap(11, 11, 11)
                .addComponent(rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verde, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        //esto es`para saber la cantidad de integrantes del grupo.
        semaforo.getCliente().enviar("Mi,"+"id,"+this.semaforo.getId());
        System.out.println("El id:: "+this.semaforo.getId());
        //Activa el contador y los colores
        //Pone el primero Verde para seguir la secuencia lògica.
        if(this.semaforo.getId()==1)
        {
            a= new Thread(() -> {
                if(this.semaforo.getId()==1)
                {
                    this.semaforo.getCliente().enviar("yoVerde,"+"yoVerde,"+this.semaforo.getId()); 
                }
            });a.start();

            //Coloca en amarillo el siguiente y el actual sigue verde.
           b= new Thread(() -> {
                int siguiente=this.semaforo.getId()+1;
                 if(this.semaforo.getId()==1)
                {
                    this.semaforo.getCliente().enviar("yoVerde,"+"tuAmarillo,"+siguiente+"");
                }
            });b.start();
            //a.stop(); //Logger.getLogger(VentanaSemaforo.class.getName()).log(Level.SEVERE, null, ex);

            //Los pone todos Rojos
            c=  new Thread(() -> {
                int siguiente=this.semaforo.getId()+1;
                this.semaforo.getCliente().enviar("Rojo,"+"Rojo,"+siguiente);
            });c.start();
            btnActivar.setEnabled(false);
    }
        btnActivar.setEnabled(false);
        
        
        
        
       
    }//GEN-LAST:event_btnActivarActionPerformed

    private void rojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rojoActionPerformed
       
        
    }//GEN-LAST:event_rojoActionPerformed

    private void amarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amarilloActionPerformed
//        new Thread(() -> {
//            this.semaforo.getCliente().enviar("yoVerde,"+"yoVerde,"+this.semaforo.getId());
//        }).start();    
//        
//        System.out.println("EL ID DEL SEMAFORO ES: " + this.semaforo.getId());
    }//GEN-LAST:event_amarilloActionPerformed

    private void verdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verdeActionPerformed
//        try {
//            this.semaforo.getCliente().enviar("fin,"+"fin,"+"fin");
//            a.interrupt();b.interrupt();c.interrupt();
//            System.out.println("jejejejj");
//        } catch (Exception e) {
//        }
        
        
//        new Thread(() -> {
////                if(this.semaforo.getId()==1)
////                {
//                    this.semaforo.getCliente().enviar("yoVerde,"+"yoVerde,"+this.semaforo.getId()); 
////                }
//            }).start();
//
//            //Coloca en amarillo el siguiente y el actual sigue verde.
//            new Thread(() -> {
//                int siguiente=this.semaforo.getId()+1;
//                 if(this.semaforo.getId()==1)
//                {
//                    this.semaforo.getCliente().enviar("yoVerde,"+"tuAmarillo,"+siguiente+"");
//                }
//            }).start();
//            //a.stop(); //Logger.getLogger(VentanaSemaforo.class.getName()).log(Level.SEVERE, null, ex);
//
//            //Los pone todos Rojos
//              new Thread(() -> {
//                int siguiente=this.semaforo.getId()+1;
//                this.semaforo.getCliente().enviar("Rojo,"+"Rojo,"+siguiente);
//            }).start();
        
        
        
    }//GEN-LAST:event_verdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amarillo;
    private javax.swing.JButton btnActivar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JButton rojo;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JButton verde;
    // End of variables declaration//GEN-END:variables
}
