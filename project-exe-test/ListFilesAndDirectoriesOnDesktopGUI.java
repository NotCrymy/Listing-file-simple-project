import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ListFilesAndDirectoriesOnDesktopGUI {
    public static void main(String[] args) {
        // chemin vers le bureau (Desktop)
        String desktopPath = System.getProperty("user.home") + "/Desktop";

        // objet File représentant le dossier du bureau
        File desktopDir = new File(desktopPath);

        // la fenêtre Swing
        JFrame frame = new JFrame("Liste des fichiers et dossiers sur le bureau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // panel pour afficher la liste des fichiers et dossiers
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // vérifications 
        if (desktopDir.exists() && desktopDir.isDirectory()) {
            // liste des fichiers et dossiers dans le dossier du bureau
            File[] filesAndDirs = desktopDir.listFiles();

            if (filesAndDirs != null) {
                JLabel titleLabel = new JLabel("Fichiers et dossiers sur le bureau :");
                panel.add(titleLabel);

                for (File fileOrDir : filesAndDirs) {
                    // Ajout du nom de chaque fichier ou dossier à la liste
                    JLabel itemLabel = new JLabel(fileOrDir.getName());
                    panel.add(itemLabel);
                }
            } else {
                JLabel emptyLabel = new JLabel("Le dossier du bureau est vide.");
                panel.add(emptyLabel);
            }
        } else {
            JLabel errorLabel = new JLabel("Le dossier du bureau n'existe pas / n'est pas accessible.");
            panel.add(errorLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}