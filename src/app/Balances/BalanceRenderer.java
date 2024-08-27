package app.Balances;

import app.bd_conexion.balance_cbd;
import app.datos.balance;
import javax.swing.*;
import java.awt.*;

public class BalanceRenderer extends JLabel implements ListCellRenderer<balance> {
    private balance_cbd bcdb = new balance_cbd();

    public BalanceRenderer() {
        // Configurar la fuente
        setFont(new Font("Arial", Font.BOLD, 14));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends balance> list, balance value, int index, boolean isSelected, boolean cellHasFocus) {
        // Formatear el texto con espaciado adecuado
        String detalles = value.getDetalles();
        String valor = String.format("%,.2f", value.getValor());
        Integer tipoId = bcdb.obtenerIdTipo(value.getTipo());

        String textoFormateado;
        if (tipoId != null && tipoId == 2) { // Ingresos
            textoFormateado = String.format("<html><span style='color:black'><b>%s</b></span> &nbsp;&nbsp;&nbsp;&nbsp; <span style='color:green'><b>%s</b></span></html>", detalles, valor);
        } else if (tipoId != null && tipoId == 1) { // Gastos
            textoFormateado = String.format("<html><span style='color:black'><b>%s</b></span> &nbsp;&nbsp;&nbsp;&nbsp; <span style='color:red'><b>%s</b></span></html>", detalles, valor);
        } else {
            textoFormateado = String.format("<html><span style='color:black'><b>%s</b></span> &nbsp;&nbsp;&nbsp;&nbsp; <span style='color:black'><b>%s</b></span></html>", detalles, valor);
        }

        setText(textoFormateado);

        // Establecer el color de fondo si está seleccionado
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setOpaque(true); // Necesario para que el fondo se pinte
        } else {
            setBackground(list.getBackground());
            setOpaque(false);
        }

        setEnabled(list.isEnabled());

        return this;
    }
}
