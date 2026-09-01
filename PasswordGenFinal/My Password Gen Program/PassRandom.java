import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassRandom {
    Random rand = new Random();

    public String passWordLength(String n, int m) {
        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i < m; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String addRandomLetters(String n) {
        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i < n.length(); i++) {
            char randomLetter = (char) ('a' + rand.nextInt(26));
            sb.setCharAt(i, randomLetter);
        }
        return sb.toString();
    }

    public String changeToUpperCase(String n, boolean bruh) {
        StringBuilder sb = new StringBuilder(n);
        if(bruh == true) {
            for(int i = 0; i < n.length(); i++) {
                int randomNum = rand.nextInt(2);
                if(randomNum == 1) {
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                } else {
                    continue;
                }
            }

        } else {
            return n;
        }
        return sb.toString();
    }

    public String addNumbers(String n, boolean bruh) {
        StringBuilder sb = new StringBuilder(n);
        if(bruh == true) {
            for(int i = 0; i < n.length(); i++) {
                int randomNum = rand.nextInt(2);
                int randomNumAgain = rand.nextInt(10);
                if(randomNum == 1) {
                    sb.setCharAt(i, (char) ('0' + randomNumAgain));
                } else {
                    continue;
                }
            }

        } else {
            return n;
        }
        return sb.toString();
    }

    public String addUniqieCharacters(String n, boolean bruh) {
        List<Character> uniqueCharacters = new ArrayList<>();
        uniqueCharacters.add('!');
        uniqueCharacters.add('@');
        uniqueCharacters.add('#');
        uniqueCharacters.add('$');
        uniqueCharacters.add('%');

        StringBuilder sb = new StringBuilder(n);
        if(bruh == true) {
            for(int i = 0; i < n.length(); i++) {
                int randomVal = rand.nextInt(2);
                int randomArrayValue = rand.nextInt(5);
                if(randomVal == 1) {
                    sb.setCharAt(i, uniqueCharacters.get(randomArrayValue));
                }
            }
        } else {
            return n;
        }
        return sb.toString();
    }

    public String generatePassword(int passLength, boolean x, boolean y, boolean z, String usersPassword) {
        usersPassword = passWordLength(usersPassword, passLength);
        usersPassword = addRandomLetters(usersPassword);
        usersPassword = changeToUpperCase(usersPassword, x);
        usersPassword = addNumbers(usersPassword, y);
        usersPassword = addUniqieCharacters(usersPassword, z);

        return usersPassword;
    }
}
