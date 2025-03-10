package _20250221PasswordBuilder;

import java.util.*;

public class PasswordBuilder {
    // values for the Password
    private final String firstNameAndLastNameWithSpace;
    private final String favoriteAnimal;
    private final int birthYear;
    Random random = new Random();
    // Generated Password
    private StringBuilder password = new StringBuilder();


    // DONE - get user input for Values - every Value must be filled
    PasswordBuilder(String firstNameAndLastNameWithSpace, String favoriteAnimal, int birthYear) {
        if (firstNameAndLastNameWithSpace.length() + favoriteAnimal.length() < 8) //in case fav animal is cat :)
            throw new IllegalArgumentException("First name,last name and favourite animal together must have at least 8 Characters");
        if (birthYear < 1900)
            throw new IllegalArgumentException("Year of birth must be greater than 1900");

        this.birthYear = birthYear;
        this.firstNameAndLastNameWithSpace = firstNameAndLastNameWithSpace;
        this.favoriteAnimal = favoriteAnimal;
    }

    // DONE - write a method that returns a String with a generated Password from the information granted from the Values
    // DONE - you should use 4 Chars from both Strings
    // DONE - in the middle must be the last two numbers from the BirthYear
    // DONE - the Password should be 11 Characters long
    // DONE - the last char of the Password should be a special Character (like: !@#$%^&* or other) that makes 11 total chars in the PW
    // DONE - first Letter of the Password must be upper Case
    // DONE - all other Letters must be lower Case
    // DONE - no space (" ") in the PW allowed
    // DONE - the password is saved in the StringBuilder but the return to the main method is a String so the main method can Print the PW
    public String getPassword() {
        if (favoriteAnimal.length() < 4 || firstNameAndLastNameWithSpace.length() < 4){
            String nameAndAnimal = firstNameAndLastNameWithSpace + favoriteAnimal;
            nameAndAnimal = shuffleString(nameAndAnimal);

            int start = random.nextInt(nameAndAnimal.length()-8);
            password.append(nameAndAnimal, start, start + 8);
        } else {
            password.append(shuffleString(firstNameAndLastNameWithSpace).substring(0, 4).toUpperCase()); //4
            password.append(shuffleString(favoriteAnimal).substring(0, 4).toUpperCase()); // 8
        }

        String bDayStr = String.valueOf(birthYear); //for making length accessible
        password.append(bDayStr.substring(bDayStr.length() - 2)); //10, from second least index on

        char c;
        do { //changed it to ASCII, because I got chars like this at first: 來 :D
            c = (char) random.nextInt(33, 127); //ASCII without del or space //https://www.ascii-code.com/
        } while (Character.isLetterOrDigit(c)); //create char not alphanumeric or whitespace

        password.append(c); //11
        password.setCharAt(0, Character.toUpperCase(password.charAt(0))); //first upper (could swap, but so I learn more)
        password.replace(1, password.length(), password.substring(1).toLowerCase()); // rest lower
        cleanSpaces();
        return password.toString();
    }

    private String shuffleString(String str) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(""))); //suggestion IDE,
        // didn't know that was possible. I tried to pass a char Array made of the string the whole time.
        Collections.shuffle(list);
        return String.join("", list); //suggestion IDE
    }

    private void cleanSpaces() {
        while (password.toString().contains(" "))
            password.setCharAt(password.indexOf(" "), getRandomChar());
    }


    private char getRandomChar() {
        return (char) (random.nextInt(26) + 'a');
    }


    // test user input if PW is correct -> return a boolean
    public boolean checkPassword(String password) {
        return password.contentEquals(this.password); //Suggestion IDE
    }

    // write a method to reverse the PW -> return a String
    public String reversePassword() {
        return new StringBuilder(password).reverse().toString(); //non-persistent, only a return
    }

    // write a method to remove the last Character -> return a String
    public String removeLastChar() {
        return password.substring(0, password.length() - 1);
    }

}

//help: use: .append(), .equals(), .insert(), .deleteCharAt(), .reverse()