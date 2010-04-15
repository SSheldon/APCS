import javax.swing.JOptionPane;

public class Exercise_P14_3
{
    public static void main(String[] args)
    {
        int purse = 0;
        do
        {
            JOptionPane.showInputDialog(null, "What is the name of the coin?");
            String value = JOptionPane.showInputDialog(null,
                "What is the value of the coin?");
            try
            {
                purse += Integer.parseInt(value);
            }
            catch (NumberFormatException e)
            {
                value = JOptionPane.showInputDialog(null,
                    "What is the value of the coin?");
                try
                {
                    purse += Integer.parseInt(value);
                }
                catch (NumberFormatException e2)
                {
                    return;
                }
            }
        } while (JOptionPane.showConfirmDialog(null,
            "Would you like to enter another coin?", "Select an Option",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null,
            "You entered coins with a total value of " + purse + ".");
    }
}
