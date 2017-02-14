
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alumno
 */
public class Interfaz extends javax.swing.JFrame {

    
    public Interfaz() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empresas ibex");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void comprobarTabla(ArrayList <Empresa> empresas , int actualizacion){
        jTextArea1.append("ACTUALIZACION----"+actualizacion+"\n");
        boolean cambio=false;
        String[] aux = new String[10];
        for(int i=0;i<getjTable1().getRowCount();i++){
            aux[i]=getjTable1().getValueAt(i,3).toString();
        }
        for(int i=0;i<empresas.size();i++){
            if(!empresas.get(i).getPorcentaje().contentEquals(aux[i])){
                jTextArea1.append("La empresa "+empresas.get(i).getNombre()+" se ha modificado"+"\n");
                cambio=true;
            }
        }
        if(!cambio){
            jTextArea1.append("No hay cambios\n");
        }
    }
    
    public void actualizarTabla(ArrayList <Empresa> empresas, int actualizaciones) {
        if(actualizaciones>0){
            comprobarTabla(empresas, actualizaciones);
        }
        DefaultTableModel modelo = null;
        String[] titulos = {"Identificador", "Nombre", "Cambio", "Porcentaje"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Iterator<Empresa> iterador = empresas.iterator();
        while (iterador.hasNext()) {
            Empresa e = iterador.next();
            String[] fila = new String[4];
            fila[0] = e.getIdentificador();
            fila[1] = e.getNombre();
            if(e.isVerde()) fila[2] = "↑ ";
            else fila[2] = "↓ ";
            fila[2] += e.getCambio();
            fila[3] = e.getPorcentaje();
            modelo.addRow(fila);
            
        }
        getjTable1().setModel(modelo);
        
        for (int i = 0; i < 4; i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            getjTable1().getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }
}
