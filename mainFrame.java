import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//7
public class mainFrame  extends JFrame{
    private validator passwordValid;
    public mainFrame(){
        super("Password Validator");
        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        passwordValid = new validator();
        setLocationRelativeTo(null);
        addGUIComponents();
    }
    
    private void addGUIComponents(){
        //-------------------------------------------------------------
        //Creating a label to display the apps funtion
        JLabel titlLabel = new JLabel("Password Validator:");
        titlLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titlLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlLabel.setBounds(0, 10, 540, 39);
        add(titlLabel);
        //-------------------------------------------------------------
        //Creating a text area for the password to be read from the app
        JTextArea  passwordInput = new JTextArea();
        passwordInput.setFont(new Font("Dialog", Font.BOLD, 32));
        JScrollPane passwordInputPane = new JScrollPane(passwordInput);
        passwordInputPane.setBounds(25, 97, 479,70 );
        passwordInputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordInputPane);
        //-------------------------------------------------------------
        //creating toggle buttons
        //uppercase button
        JToggleButton upperCase = new JToggleButton("Uppercase");
        upperCase.setBounds(25,302,225,56);
        upperCase.setFont(new Font("Dialog",Font.PLAIN,26));
        add(upperCase);
        //lowercase button
        JToggleButton lowerCase = new JToggleButton("Lowercase");
        lowerCase.setBounds(275,302,225,56);
        lowerCase.setFont(new Font("Dialog",Font.PLAIN,26));
        add(lowerCase);
        //Symbols
        JToggleButton specialSymbols = new JToggleButton("Symbols");
        specialSymbols.setBounds(25,402,225,56);
        specialSymbols.setFont(new Font("Dialog",Font.PLAIN,26));
        add(specialSymbols);
        //numbers
        JToggleButton numbers = new JToggleButton("Numbers");
        numbers.setBounds(275,402,225,56);
        numbers.setFont(new Font("Dialog",Font.PLAIN,26));
        add(numbers);
        //validate button 
        JButton validate = new JButton("Validate");
        validate.setBounds(150,200,225,56);
        validate.setFont(new Font("Dialog",Font.BOLD,26));
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordInput.getText();
                if(passwordInput.getText().equals("") ) return;
                int minLength=0;
                if(upperCase.isSelected())minLength++;
                if(lowerCase.isSelected())minLength++;
                if(numbers.isSelected())minLength++;
                if(specialSymbols.isSelected())minLength++;
                if(passwordInput.getText().length()<minLength) JOptionPane.showMessageDialog(null, "The password is not valid", "Password Validator", JOptionPane.PLAIN_MESSAGE, null);
                boolean anyToggleButton = lowerCase.isSelected() || upperCase.isSelected() || numbers.isSelected() || specialSymbols.isSelected();
                if(anyToggleButton && passwordInput.getText().length()>=minLength ){
                    boolean password_validator = passwordValid.passwordValid(upperCase.isSelected(),lowerCase.isSelected(),numbers.isSelected(),specialSymbols.isSelected(),password);
                    if(password_validator) JOptionPane.showMessageDialog(null, "The password is valid", "Password Validator", JOptionPane.PLAIN_MESSAGE, null);
                    else JOptionPane.showMessageDialog(null, "The password is not valid", "Password Validator", JOptionPane.PLAIN_MESSAGE, null);
                }
            }
   

        });
        add(validate);
    }
}
