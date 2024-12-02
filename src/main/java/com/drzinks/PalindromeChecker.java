package com.drzinks;

public class PalindromeChecker {

    public enum Type {
        //        ELEMENT_BY_ELEMENT,
        RECURSIVE{
            @Override
            public boolean isPalindrome(String text) {
                if (text == null || text.length() < 2)
                    return true;

                if(text.charAt(0) != text.charAt(text.length()-1))
                    return false;

                return isPalindrome(text.substring(1, text.length() - 1));
            }
        },
        COMPARE_HALVES {
            @Override
            public boolean isPalindrome(String text) {
                /* fail fast */
                if (text == null || text.length() < 2)
                    return true;

                //lol, kajak, madam,
                var len = text.length();
                for (int i = 0; i < len / 2; i++) {
                    if (text.charAt(i) != text.charAt(len - 1 - i))
                        return false;
                }

                return true;
            }
        };

        public abstract boolean isPalindrome(String text);
    }

}
