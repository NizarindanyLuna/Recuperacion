package Controlador;

import modelo.ReciboElectricidad;
import vista.dlgReciboElectricidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

    ReciboElectricidad RecElec;
    dlgReciboElectricidad vista;

    public Controlador(ReciboElectricidad RecElec, dlgReciboElectricidad vista) {

        this.RecElec = RecElec;
        this.vista = vista;

        vista.btnCancelar.addActionListener(this);
        vista.btnCerrar.addActionListener(this);
        vista.btnNuevo.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnMostrar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);

    }

    private void IniciarVista() {
        vista.setTitle("--:: ReciboElectricidad ::--");
        vista.setSize(580, 470);
        vista.setVisible(true);
    }

    public void limpiar() {
        vista.txtConsumido.setText("");
        vista.txtNombre.setText("");
        vista.txtNumRecibo.setText("");
        vista.txtDomicilio.setText("");
        vista.txtFecha.setText("");
        vista.txtCosto.setText("");
        vista.labelImpuesto.setText("");
        vista.labelSubtotal.setText("");
        vista.labelTPagar.setText("");
        vista.comboTipo.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnNuevo == e.getSource()) {
            vista.btnGuardar.setEnabled(true);
            vista.btnMostrar.setEnabled(true);
            vista.txtConsumido.setEnabled(true);
            vista.txtNombre.setEnabled(true);
            vista.txtNumRecibo.setEnabled(true);
            vista.txtDomicilio.setEnabled(true);
            vista.txtFecha.setEnabled(true);
            vista.txtCosto.setEnabled(true);
            vista.comboTipo.setEnabled(true);
        }

        if (vista.btnGuardar == e.getSource()) {

            try {
                RecElec.setNumRecibo(Integer.parseInt(vista.txtNumRecibo.getText()));
                RecElec.setNombre((vista.txtNombre.getText()));
                RecElec.setDomicilio((vista.txtDomicilio.getText()));
                RecElec.setFecha((vista.txtFecha.getText()));
                RecElec.setCostoKilow(Integer.parseInt(vista.txtCosto.getText()));
                RecElec.setKilowConsum(Integer.parseInt(vista.txtConsumido.getText()));
                RecElec.setTipoServicio((vista.comboTipo.getSelectedIndex()));
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vista, "ERROR: "+ex.getMessage());
            }catch(Exception ex2){
                JOptionPane.showMessageDialog(vista, "ERROR: "+ex2.getMessage());
            }
        }

        if (vista.btnMostrar == e.getSource()) {

            vista.txtNumRecibo.setText(String.valueOf(RecElec.getNumRecibo()));
            vista.txtNombre.setText((RecElec.getNombre()));
            vista.txtDomicilio.setText((RecElec.getDomicilio()));
            vista.txtFecha.setText((RecElec.getFecha()));
            vista.txtConsumido.setText(String.valueOf(RecElec.getKilowConsum()));
            vista.txtCosto.setText(String.valueOf(RecElec.getCostoKilow()));
            vista.comboTipo.setSelectedIndex(RecElec.getTipoServicio());

            vista.labelSubtotal.setText(String.valueOf(RecElec.CalcularSubTotal()));
            vista.labelImpuesto.setText(String.valueOf(RecElec.CalcularImpuesto()));
            vista.labelTPagar.setText(String.valueOf(RecElec.CalcularTotalPagar()));
        }

        if (vista.btnLimpiar == e.getSource()) {
            limpiar();
        }

        if (vista.btnCancelar == e.getSource()) {
            vista.btnGuardar.setEnabled(false);
            vista.btnMostrar.setEnabled(false);
            vista.txtConsumido.setEnabled(false);
            vista.txtNombre.setEnabled(false);
            vista.txtNumRecibo.setEnabled(false);
            vista.txtDomicilio.setEnabled(false);
            vista.txtFecha.setEnabled(false);
            vista.txtCosto.setEnabled(false);
            vista.comboTipo.setEnabled(false);
            vista.btnNuevo.setEnabled(true);
            limpiar();
        }

        if (vista.btnCerrar == e.getSource()) {
            int option=JOptionPane.showConfirmDialog(vista, "¿DESEAS SALIR?",
                    "Desicion",JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_NO_OPTION){
                vista.dispose();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        ReciboElectricidad RecElec = new ReciboElectricidad();
        dlgReciboElectricidad vista = new dlgReciboElectricidad();

        Controlador contr = new Controlador(RecElec, vista);
        contr.IniciarVista();

    }
}
