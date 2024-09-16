import javax.swing.*;
import java.awt.*;

public class EstructuraWebSwing extends JFrame {

    public EstructuraWebSwing() {
        // Configuración de la ventana principal
        setTitle("Estructura Web Básica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Definir colores
        Color headerColor = new Color(210, 73, 58);  // Color rojo del header y otras secciones
        Color contentColor = new Color(203, 190, 130); // Color del article y section

        // <header> superior
        JPanel header = new JPanel();
        header.setBackground(headerColor);
        header.add(new JLabel("<header>"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weighty = 0.1;
        add(header, gbc);

        // <nav>
        JPanel nav = new JPanel();
        nav.setBackground(headerColor);
        nav.add(new JLabel("<nav>"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weighty = 1;
        add(nav, gbc);

        // <aside>
        JPanel aside = new JPanel();
        aside.setBackground(headerColor);
        aside.add(new JLabel("<aside>"));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        add(aside, gbc);

        // <section>
        JPanel section = new JPanel(new GridBagLayout());
        section.setBackground(headerColor);
        GridBagConstraints gbcSection = new GridBagConstraints();
        gbcSection.fill = GridBagConstraints.BOTH;
        gbcSection.weightx = 1;
        gbcSection.weighty = 1;

        // <header> dentro de section
        JPanel sectionHeader = new JPanel();
        sectionHeader.setBackground(contentColor);
        sectionHeader.add(new JLabel("<header>"));
        gbcSection.gridx = 0;
        gbcSection.gridy = 0;
        gbcSection.gridwidth = 1;
        gbcSection.gridheight = 1;
        gbcSection.weighty = 0.1;
        section.add(sectionHeader, gbcSection);

        // <article>
        JPanel article = new JPanel();
        article.setBackground(contentColor);
        article.add(new JLabel("<article>"));
        gbcSection.gridx = 0;
        gbcSection.gridy = 1;
        gbcSection.weighty = 1;
        section.add(article, gbcSection);

        // <footer> dentro de section
        JPanel sectionFooter = new JPanel();
        sectionFooter.setBackground(contentColor);
        sectionFooter.add(new JLabel("<footer>"));
        gbcSection.gridx = 0;
        gbcSection.gridy = 2;
        gbcSection.weighty = 0.1;
        section.add(sectionFooter, gbcSection);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        add(section, gbc);

        // <footer> inferior
        JPanel footer = new JPanel();
        footer.setBackground(headerColor);
        footer.add(new JLabel("<footer>"));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weighty = 0.1;
        add(footer, gbc);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new EstructuraWebSwing();
    }
}
