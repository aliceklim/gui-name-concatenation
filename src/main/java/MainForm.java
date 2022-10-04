import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private JPanel mainPanel;
    private JTextField surname;
    private JTextField name;
    private JTextField middleName;
    private JLabel surnameLabel;
    private JLabel nameLabel;
    private JLabel middleNameLabel;
    private JTextArea textArea1;
    private JButton collapseButton;
    private JButton expandButton;
    private String fullName;

    public JPanel getMainPanel(){
        return mainPanel;
    }
    
    public MainForm(){
        textArea1.setVisible(false);
        expandButton.setVisible(false);
        expandButton.addActionListener(new Action(){
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {
            }

            @Override
            public void setEnabled(boolean b) {
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
               String text = textArea1.getText();

               String[] fullname = text.split(" ");
               if (fullname.length == 2){
                   name.setText(fullname[1]);
                   surname.setText(fullname[0]);
               } else if (fullname.length == 3) {
                   name.setText(fullname[1]);
                   surname.setText(fullname[0]);
                   middleName.setText(fullname[2]);
               }
               name.setVisible(true);
               surname.setVisible(true);
               middleName.setVisible(true);
               collapseButton.setVisible(true);
               textArea1.setVisible(false);
               expandButton.setVisible(false);
                nameLabel.setVisible(true);
                surnameLabel.setVisible(true);
                middleNameLabel.setVisible(true);

            }
        });
        collapseButton.addActionListener(new Action(){
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {
            }

            @Override
            public void setEnabled(boolean b) {
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().length() != 0 || surname.getText().length() != 0){
                    fullName = surname.getText() + " " + name.getText() + " " + middleName.getText();
                    System.out.println(fullName);
                    surname.setVisible(false);
                    name.setVisible(false);
                    middleName.setVisible(false);
                    collapseButton.setVisible(false);
                    textArea1.setVisible(true);
                    textArea1.setText(fullName);
                    expandButton.setVisible(true);
                    nameLabel.setVisible(false);
                    surnameLabel.setVisible(false);
                    middleNameLabel.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Фамилия и имя обязательны для заполнения",
                            "Ошибка",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }
            }
        });
    }

}
